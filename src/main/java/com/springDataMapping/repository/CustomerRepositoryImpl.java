package com.springDataMapping.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springDataMapping.Dto.OrderRequestDto;
import com.springDataMapping.model.Customer;
import com.springDataMapping.model.Product;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    
	@Autowired
	private EntityManager em;

	@Override
	public Customer save(Customer customer) {
	    em.persist(customer);
		return customer;
	}

	@Override
	public List<Customer> getInfo(Customer customer) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> r = cq.from(Customer.class);
		cq.select(r);
		List<Customer> result = em.createQuery(cq).getResultList();
		return result;
	}
	@Override
	public List<Customer> getById(int id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> r = cq.from(Customer.class);
		cq.select(r);
		cq.where(cb.equal(r.get("id"),id));
		List<Customer> list = em.createQuery(cq).getResultList();
		return list;
	}

	@Override
	public List<Customer> getByNameAndProduct(String name, String productName) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> r = cq.from(Customer.class);
		cq.select(r);
		cq.where(cb.equal(r.get("name"), r.get("productName")));
		List<Customer> list = em.createQuery(cq).getResultList();
		return  list;
	}

	@Override
	public List<OrderRequestDto> getMultiFields(OrderRequestDto order) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderRequestDto> cq = cb.createQuery(OrderRequestDto.class);
		Root<Customer> root = cq.from(Customer.class);
		Join<Customer, Product> p = root.join("product");
		cq.multiselect(root.get("name"),root.get("email"),root.get("gender"), p.get("productName"),p.get("price"));
		List<OrderRequestDto> list = em.createQuery(cq).getResultList();
		return list;
	}

	@Override
	public List<OrderRequestDto> getOrderBy() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OrderRequestDto> cq = cb.createQuery(OrderRequestDto.class);
		Root<Customer> r = cq.from(Customer.class);
		Join<Customer, Product> j = r.join("product");
		cq.multiselect(r.get("name"),r.get("email"),r.get("gender"),j.get("productName"),j.get("price"));
		cq.orderBy(cb.desc(j.get("productName")));
		List<OrderRequestDto> list = em.createQuery(cq).getResultList();
		return list;
	}

	@Override
	public List<Customer> getData() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> r = cq.from(Customer.class);
		cq.select(r);
		List<Customer> result = em.createQuery(cq).getResultList();
		return result;
	}
	
}
