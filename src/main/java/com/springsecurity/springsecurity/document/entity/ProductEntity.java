package com.springsecurity.springsecurity.document.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Data
@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "RELEASE_DATE")
	private LocalDate releaseDate;

	@Column(name = "AVAILABLE")
	private boolean available;

}
