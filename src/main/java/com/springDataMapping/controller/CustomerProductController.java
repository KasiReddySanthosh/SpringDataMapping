package com.springDataMapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springDataMapping.Dto.OrderRequestDto;
import com.springDataMapping.model.Customer;
import com.springDataMapping.service.CustomerProductService;

@RestController
@RequestMapping("/order")
public class CustomerProductController {

	@Autowired
	CustomerProductService customerProductService;
	
	
	  @PostMapping("/customersave")
	  public Customer createCustomer(@RequestBody Customer customer) {
		  Customer create = customerProductService.CustomerSave(customer); 
		  return create;
		  
	  }
	  
	  @GetMapping("/all")
	  public List<Customer> getInfo(Customer customer){
		return customerProductService.getInfo(customer);		  
	  }
	  
	  @GetMapping("/multiFields")
	  public List<OrderRequestDto> getMultiFields(OrderRequestDto order){  
	    return customerProductService.getMultiFields(order);
	}
	  @GetMapping("/get/{id}")
     public List<Customer> getById(@PathVariable("id") int id){
    	 return customerProductService.getById(id);
     }
     
	  @GetMapping("fetch/{name}/{productName}")
	  public List<Customer> getByNameAndProductName(@PathVariable("name") String name,
			                                        @PathVariable("productName") String productName){
		  
	  return customerProductService.getByNameAndProductName(name, productName);		  
	  }
	  
	  @GetMapping("/getOrderBy")
	  public List<OrderRequestDto> getOrderByProductName(){
		return customerProductService.getOrderByProductName();            		  
	  }
	  
		/*
		 * @GetMapping("/getCustomers") public String getCustomers(Model model) {
		 * List<Customer> customer = customerProductService.getData();
		 * model.addAttribute("listCustomers",customer); return "listCustomers";
		 * 
		 * }
		 */
	  @GetMapping("/getAllCustomers")
	  public ModelAndView getAllCustomer() {
		  ModelAndView mav = new ModelAndView("listCustomers"); 
		  mav.addObject("employees",customerProductService.getData());
		  return mav;		  
	  }
}
