package com.amydosh.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admins")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adminID;
	String adminUN;
	String adminPW;
	
	public Admin() {
		super();
	}
	public Admin(Integer adminID, String adminUN, String adminPW) {
		super();
		this.adminID = adminID;
		this.adminUN = adminUN;
		this.adminPW = adminPW;
	}
	public String getAdminUN() {
		return adminUN;
	}
	public void setAdminUN(String adminUN) {
		this.adminUN = adminUN;
	}
	public String getAdminPW() {
		return adminPW;
	}
	public void setAdminPW(String adminPW) {
		this.adminPW = adminPW;
	}
	public Integer getAdminID() {
		return adminID;
	}
	@Override
	public String toString() {
		return String.format("Admin [adminID=%s, adminUN=%s, adminPW=%s]", adminID, adminUN, adminPW);
	}
	
}
