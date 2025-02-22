package com.springsecurity.springsecurity.document.service;

import java.util.Locale;




import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.springsecurity.springsecurity.document.entity.Item;
import com.springsecurity.springsecurity.document.entity.OrderDetail;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BillDocumentServiceImpl extends AbstractDocumentService {
	private final TemplateEngine templateEngine;

	public void downloadBill(OrderDetail orderDetail, HttpServletResponse response) {
		final Context ctx = new Context(Locale.getDefault());
		ctx.setVariable("billData", calculateTotalAmount(orderDetail));
		String xmlTemplate = templateEngine.process("test-bill-template.xml", ctx);
		generateDocument(response, xmlTemplate);
	}

	public double discountCalculate(double totalAmount, double discountPercentage) {
		discountPercentage /= 100;
		double discountAmount = discountPercentage * totalAmount;
		return discountAmount;
	}

	public OrderDetail calculateTotalAmount(OrderDetail orderDetail) {
		orderDetail.getItems().forEach(i -> i.setItemPrice(i.getQuantity() * i.getPerUnitPrice()));
		double totalAmount = orderDetail.getItems().stream().mapToDouble(Item::getItemPrice).sum();
		orderDetail.setTotalAmount(totalAmount);
		if (orderDetail.getReductionPercentage() > 0) {
			double totalDiscount = discountCalculate(totalAmount, orderDetail.getReductionPercentage());
			orderDetail.setTotalAmount(orderDetail.getTotalAmount() - totalDiscount);
			orderDetail.setTotalDiscount(totalDiscount);
		}
		return orderDetail;
	}
}
