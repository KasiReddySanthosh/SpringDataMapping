package com.springDataMapping.model;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	private int productId;
	private String productName;
	private int quantity;
	private int price;

}
