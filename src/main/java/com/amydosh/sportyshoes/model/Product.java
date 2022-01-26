package com.amydosh.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_products")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer theId;
	String productStyle;
	String productSize;
	String productColor;
	double productPrice;
	
	public Product(Integer theId, String productStyle, String productSize, String productColor, double productPrice) {
		super();
		this.theId = theId;
		this.productStyle = productStyle;
		this.productSize = productSize;
		this.productColor = productColor;
		this.productPrice = productPrice;
	}

	public Product() {
		super();
	}

	public String getProductStyle() {
		return productStyle;
	}

	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getId() {
		return theId;
	}

	@Override
	public String toString() {
		return String.format("Product [prodID=%s, productStyle=%s, productSize=%s, productColor=%s, productPrice=%s]",
				theId, productStyle, productSize, productColor, productPrice);
	}

	
	
}
