package com.springDataMapping.Dto;

import lombok.Data;

@Data

public class OrderRequestDto {
	
	private String name;
	private String email;
	private String gender;
	private String productName;
	private Integer price;


	public OrderRequestDto(String name, String email, String gender, String productName, Integer price) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.productName = productName;
		this.price = price;
	}




    
}
