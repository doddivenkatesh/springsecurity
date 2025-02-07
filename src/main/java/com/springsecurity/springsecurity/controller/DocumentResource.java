package com.springsecurity.springsecurity.controller;

import java.io.IOException;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springsecurity.springsecurity.document.entity.OrderDetail;
import com.springsecurity.springsecurity.document.service.DocumentResponse;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface DocumentResource {
	@DocumentResponse
	@Operation(summary = "Download PDF with Code39 Barcode")
	@GetMapping(path = "/barcodes")
	void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

	@DocumentResponse
	@Operation(summary = "Download PDF for Bills")
	@PostMapping(path = "/bills")
	void downloadBill(@RequestBody OrderDetail orderDetail, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;

	void downloadXlsDocument(String docName, HttpServletRequest request, HttpServletResponse response);

	void downloadXlsGenericDocument(String docName, HttpServletRequest request, HttpServletResponse response);

}
