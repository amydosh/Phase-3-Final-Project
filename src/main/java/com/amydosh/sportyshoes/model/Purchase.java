package com.amydosh.sportyshoes.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_purchases")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Purchase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transRecord;
	private String purchasedBy;
	private String purchaseDate;
	private Integer purchasedProducts;
	private Double totalPrice;
	
	public Purchase(Integer transRecord, String purchasedBy, String purchaseDate, Integer purchasedProducts,
			Double totalPrice) {
		super();
		this.transRecord = transRecord;
		this.purchasedBy = purchasedBy;
		this.purchaseDate = purchaseDate;
		this.purchasedProducts = purchasedProducts;
		this.totalPrice = totalPrice;
	}
	public Purchase() {
		super();
	}
	public String getPurchasedBy() {
		return purchasedBy;
	}
	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Integer getPurchasedProducts() {
		return purchasedProducts;
	}
	public void setPurchasedProducts(Integer purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getTransRecord() {
		return transRecord;
	}
	@Override
	public String toString() {
		return String.format(
				"Purchase [transRecord=%s, purchasedBy=%s, purchaseDate=%s, purchasedProducts=%s, totalPrice=%s]",
				transRecord, purchasedBy, purchaseDate, purchasedProducts, totalPrice);
	}
}
