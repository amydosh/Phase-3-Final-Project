package com.amydosh.sportyshoes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amydosh.sportyshoes.model.Customer;
import com.amydosh.sportyshoes.repository.CustomerRepository;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer addCustomer(Customer customer){
    	return customerRepository.saveAndFlush(customer);
    }


	@Override
	public Customer getCustomer(Integer custId) {
		return customerRepository.getById(custId);
	}
	
	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}


	@Override
	public Customer saveCustomer(Customer theCustomer) {
		return customerRepository.save(theCustomer);
	}


	@Override
	public void deleteCustomer(Integer custId) {
		customerRepository.deleteById(custId);
		
	}
	
	

//	@Override
//	public List<Customer> getByNameAsc(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public List<Customer> getByNameDesc(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//

}
