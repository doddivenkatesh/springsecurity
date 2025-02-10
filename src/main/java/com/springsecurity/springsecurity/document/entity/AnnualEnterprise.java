package com.springsecurity.springsecurity.document.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ANNUAL_ENTERPRISE")
@Entity
public class AnnualEnterprise {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY	)
	private Long id;
	
	@Column(name="year")
	private String year;
	@Column(name="industry_code_ANZSIC")
	private String industryCodeAnzsic;
	@Column(name="industry_name_ANZSIC")
	private String industry_name_ANZSIC;
	@Column(name="rme_size_grp")
	private String rmeSizeGrp;
	@Column(name="variable")
	private String variable;
	@Column(name="value")
	private String value;
	@Column(name="unit")
	private String unit;
}
