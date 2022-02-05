package com.amydosh.sportyshoes.service;

import javax.validation.Valid;

import com.amydosh.sportyshoes.model.Admin;

public interface AdminService {

	Iterable<Admin> getAllAdmins();

	Admin getAdmin(Integer adminID);

	Admin addAdmin(@Valid Admin theAdmin);

	Admin saveAdmin(Admin savedAdmin);

	void deleteAdmin(Integer adminID);

}
