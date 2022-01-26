package com.amydosh.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_categories")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryID;
	private String categoryName;
	
	public Category(Integer categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	
	public Category() {
		super();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	@Override
	public String toString() {
		return String.format("Category [categoryID=%s, categoryName=%s]", categoryID, categoryName);
	}

	
	
}
