package com.amydosh.sportyshoes.service;

import java.util.List;

import javax.validation.Valid;

import com.amydosh.sportyshoes.model.Customer;

public interface CustomerService {
	
	public Customer getCustomer(Integer custId);

	public Iterable<Customer> getAllCustomers();

	public Customer saveCustomer(Customer theCustomer);

	public Customer addCustomer(Customer theCustomer);

	public void deleteCustomer(Integer custId);

//	List<Customer> getByNameAsc(String name);
//
//	List<Customer> getByNameDesc(String name);
//
//	Customer saveCustomer(Customer theCustomer);
//
//	void deleteCustomer(Integer theId);

}
