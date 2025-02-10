package com.springsecurity.springsecurity.document.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.springsecurity.springsecurity.document.entity.AnnualEnterprise;
import com.springsecurity.springsecurity.repo.AnnualEnterpriseDao;

import jakarta.annotation.Resource;

@Service("annualEnterprise")
public class AnnualEnterpriseService {

	@Resource(name="annualEnterpriseDao")
	private AnnualEnterpriseDao annualEnterpriseDao;
	String line = "";
	
	public void saveCustomerDate() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/annual-enterprise-survey-2023-financial-year-provisional-size-bands.csv"));
		while((line=br.readLine())!=null) {
			String [] data = line.split(",");
			AnnualEnterprise c = new AnnualEnterprise();
			c.setIndustry_name_ANZSIC(data[0]);
			c.setIndustryCodeAnzsic(data[1]);
			c.setRmeSizeGrp(data[2]);
			c.setUnit(data[3]);
			c.setValue(data[3]);
			c.setVariable(data[4]);
			c.setYear(data[5]);
			annualEnterpriseDao.save(c);
		}
			
		}
	
}
