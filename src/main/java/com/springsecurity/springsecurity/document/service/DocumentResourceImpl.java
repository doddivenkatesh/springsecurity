package com.springsecurity.springsecurity.document.service;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.controller.DocumentResource;
import com.springsecurity.springsecurity.document.entity.OrderDetail;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = { APPLICATION_OCTET_STREAM_VALUE, APPLICATION_JSON_VALUE })
public class DocumentResourceImpl implements DocumentResource{
	
	private final BillDocumentServiceImpl billDocumentService;

	//private final BarcodeDocumentServiceImpl barcodeDocumentServiceImpl;

	//private final CustomerXlsDocumentService customerXlsDocumentService;

	//private final CustomerXLSUsualDocumentService customerXLSUsualDocumentService;


	@Override
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setStatus(HttpStatus.OK.value());
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Test.pdf");
		//barcodeDocumentServiceImpl.generatePDF(request, response);
	}

	@Override
	public void downloadBill(OrderDetail orderDetail, HttpServletRequest request, HttpServletResponse response) {
		billDocumentService.downloadBill(orderDetail, response);
	}

	@Override
	public void downloadXlsGenericDocument(String docName, HttpServletRequest request, HttpServletResponse response) {
		//customerXlsDocumentService.generateXlsDocument(docName, response);
	}

	@Override
	public void downloadXlsDocument(String docName, HttpServletRequest request, HttpServletResponse response) {
		//customerXLSUsualDocumentService.generateXlsDocument(docName, response);
	}


}
