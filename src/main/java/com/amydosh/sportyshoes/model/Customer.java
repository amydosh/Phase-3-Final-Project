package com.amydosh.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_customers")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer custID;
	String custName;
	String custEmail;
	String custPW;
	
	public Customer(Integer custID, String custName, String custEmail, String custPW) {
		super();
		this.custID = custID;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPW = custPW;
	}
	public Customer() {
		super();
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPW() {
		return custPW;
	}
	public void setCustPW(String custPW) {
		this.custPW = custPW;
	}
	public Integer getCustID() {
		return custID;
	}
	@Override
	public String toString() {
		return String.format("Customer [custID=%s, custName=%s, custEmail=%s, custPW=%s]", custID, custName, custEmail,
				custPW);
	}
}
