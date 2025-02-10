package com.springsecurity.springsecurity.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.springsecurity.document.service.AnnualEnterpriseService;

import jakarta.annotation.Resource;

@RestController
public class AnnualRestController {
	@Resource(name="annualEnterprise")
	private AnnualEnterpriseService annualEnterprise;
	
	@RequestMapping(path="feed")
	public void setDataDB() throws IOException {
		annualEnterprise.saveCustomerDate();
	}

}
