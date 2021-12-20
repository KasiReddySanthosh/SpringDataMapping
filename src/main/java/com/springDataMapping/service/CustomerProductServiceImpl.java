package com.springDataMapping.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDataMapping.Dto.OrderRequestDto;
import com.springDataMapping.model.Customer;
import com.springDataMapping.repository.CustomerRepository;

@Service
public class CustomerProductServiceImpl implements CustomerProductService{

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public Customer CustomerSave(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getInfo(Customer customer) {
		
		return customerRepository.getInfo(customer);
	}

	@Override
	public List<OrderRequestDto> getMultiFields(OrderRequestDto order) {
		return customerRepository.getMultiFields(order);
	}

	@Override
	public List<Customer> getById(int id) {
		return customerRepository.getById(id);
	}

	@Override
	public List<Customer> getByNameAndProductName(String name, String productName) {
		// TODO Auto-generated method stub
		return customerRepository.getByNameAndProduct(name, productName);
	}

	@Override
	public List<OrderRequestDto> getOrderByProductName() {
		return customerRepository.getOrderBy();
	}

	@Override
	public List<Customer> getData() {
		return customerRepository.getData();
	}

}
