package com.amydosh.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.amydosh.sportyshoes.model.Product;
import com.amydosh.sportyshoes.repository.CustomerRepository;
import com.amydosh.sportyshoes.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductRepository productRepository;


    @Override
    public Product addProduct(Product theProduct){
    	return productRepository.saveAndFlush(theProduct);
    }


	@Override
	public Product getProduct(Integer theId) {
		return productRepository.getById(theId);
	}
	
	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}


	@Override
	public Product saveProduct(Product theProduct) {
		return productRepository.save(theProduct);
	}


	@Override
	public void deleteProduct(Integer theId) {
		productRepository.deleteById(theId);
		
	}

}
