package com.amydosh.sportyshoes.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amydosh.sportyshoes.exception.ProductNotFoundException;
import com.amydosh.sportyshoes.model.Product;
import com.amydosh.sportyshoes.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// FUNCTIONAL
	@GetMapping(path="/products")
	public @ResponseBody Iterable<Product> getAllProducts() {
		System.out.println("Showing all products in database.");
		return productService.getAllProducts();
	}

	// FUNCTIONAL
	@GetMapping(path="/products/{theId}")
	public @ResponseBody Product retrieveProducts(@PathVariable Integer theId) {
		Product theProduct = productService.getProduct(theId);
		System.out.println("Showing specific product in database: "+theProduct);
		return theProduct;
	}
	
	// FUNCTIONAL
	@GetMapping(path="/products/filterbystyle/{productStyle}")
	public @ResponseBody List<Product> retrieveProductsByStyle(@PathVariable String productStyle) {
		List<Product> theProducts = productService.getProductByProductStyle(productStyle);
		System.out.println("Showing all products of style "+productStyle+" in database: "+theProducts);
		return theProducts;
	}
	
	// FUNCTIONAL
	@GetMapping(path="/products/filterbycolor/{productColor}")
	public @ResponseBody List<Product> retrieveProductsByColor(@PathVariable String productColor) {
		List<Product> theProducts = productService.getProductByProductColor(productColor);
		System.out.println("Showing all products of color "+productColor+" in database: "+theProducts);
		return theProducts;
	}

	// FUNCTIONAL
	@PostMapping(path="/products")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product theProduct) {
		Product savedProduct = productService.addProduct(theProduct);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{theId}").buildAndExpand(savedProduct.getId()).toUri();
		System.out.println("Created New Product: "+savedProduct);
		return ResponseEntity.created(location).build();
	}
	
	// FUNCTIONAL
	@PutMapping(path="/products/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable Integer theId, @RequestBody Product theProduct) {
		Product savedProduct = productService.getProduct(theId);
		savedProduct.setProductColor(theProduct.getProductColor());
		savedProduct.setProductPrice(theProduct.getProductPrice());
		savedProduct.setProductSize(theProduct.getProductSize());
		savedProduct.setProductStyle(theProduct.getProductStyle());
		productService.saveProduct(savedProduct);
		System.out.println("Saved Product Information for: "+savedProduct);
	}

	// FUNCTIONAL
	@DeleteMapping(path="/products/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer theId) throws ProductNotFoundException {
		Product theProduct = productService.getProduct(theId);
		
		// --> NOT FUNCTIONAL
		if (theProduct == null) {
			throw new ProductNotFoundException("Product ID: "+theId+" was not found.");
		}
		productService.deleteProduct(theId);
		System.out.println("Deleting Product with ID: "+theId);
	}

}
