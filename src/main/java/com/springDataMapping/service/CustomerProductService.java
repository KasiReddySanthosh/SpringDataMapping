package com.springDataMapping.service;

import java.util.List;

import com.springDataMapping.Dto.OrderRequestDto;
import com.springDataMapping.model.Customer;


public interface CustomerProductService {

	Customer CustomerSave(Customer customer);
	List<Customer> getInfo(Customer customer);
	List<Customer> getById(int id);
	List<Customer> getByNameAndProductName(String name,String productName);
	List<OrderRequestDto> getMultiFields(OrderRequestDto order);
	List<OrderRequestDto> getOrderByProductName();
	List<Customer> getData();
}
