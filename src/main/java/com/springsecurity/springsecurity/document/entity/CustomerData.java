package com.springsecurity.springsecurity.document.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerData {

	//@XLSColumn(columnIndex = 0, headerName = "Customer Id")
	private long customerId;

	//@XLSColumn(columnIndex = 1, headerName = "Email Address")
	private String emailAddress;

	//@XLSColumn(columnIndex = 2, headerName = "Full Name")
	private String fullName;
}
