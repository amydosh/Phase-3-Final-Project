package com.amydosh.sportyshoes.service;

import com.amydosh.sportyshoes.model.Customer;
import com.amydosh.sportyshoes.model.Product;

public interface ProductService {

	public Product getProduct(Integer theId);

	public Iterable<Product> getAllProducts();

	public Product saveProduct(Product theProduct);

	public Product addProduct(Product theProduct);

	public void deleteProduct(Integer theId);
	
}
