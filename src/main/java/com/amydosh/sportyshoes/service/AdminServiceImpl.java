package com.amydosh.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amydosh.sportyshoes.model.Admin;
import com.amydosh.sportyshoes.model.Customer;
import com.amydosh.sportyshoes.repository.AdminRepository;
import com.amydosh.sportyshoes.repository.CustomerRepository;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminRepository adminRepository;


    @Override
    public Admin addAdmin(Admin admin){
    	return adminRepository.saveAndFlush(admin);
    }


	@Override
	public Admin getAdmin(Integer adminID) {
		return adminRepository.getById(adminID);
	}
	
	@Override
	public Iterable<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}


	@Override
	public Admin saveAdmin(Admin theAdmin) {
		return adminRepository.save(theAdmin);
	}


	@Override
	public void deleteAdmin(Integer adminID) {
		adminRepository.deleteById(adminID);
		
	}
	
	
}
