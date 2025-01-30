package com.springsecurity.springsecurity.document.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {

	private String name;

	private String id;

	private String address;

}
