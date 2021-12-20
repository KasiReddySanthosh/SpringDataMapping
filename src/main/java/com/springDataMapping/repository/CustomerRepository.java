package com.springDataMapping.repository;

import java.util.List;

import com.springDataMapping.Dto.OrderRequestDto;
import com.springDataMapping.model.Customer;

public interface CustomerRepository {

	Customer save(Customer customer);
	List<Customer> getInfo(Customer customer);
	List<Customer> getById(int id);
	List<Customer> getByNameAndProduct(String name, String productName);
	List<OrderRequestDto> getMultiFields(OrderRequestDto order);
	List<OrderRequestDto> getOrderBy();
	List<Customer> getData();
}
