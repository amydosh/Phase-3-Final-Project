package com.amydosh.sportyshoes.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amydosh.sportyshoes.exception.AdminNotFoundException;
import com.amydosh.sportyshoes.exception.ProductNotFoundException;
import com.amydosh.sportyshoes.model.Admin;
import com.amydosh.sportyshoes.model.Product;
import com.amydosh.sportyshoes.service.AdminService;
import com.amydosh.sportyshoes.service.ProductService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
//	@RequestMapping(value="")
//	public String index(Model model) {
//		model.addAttribute("title", "My Cheeses");
//		return "admin/categories";
//	}	
	
	// FUNCTIONAL
	@GetMapping(path="/admins")
	public @ResponseBody Iterable<Admin> getAllAdmins() {
		System.out.println("Showing all Admin accounts.");
		return adminService.getAllAdmins();
	}

	
	// --> NOT FUNCTIONAL
	@GetMapping(path="admins/{adminID}")
	public @ResponseBody Admin retrieveAdmins(@PathVariable Integer adminID) {
		Admin theAdmin = adminService.getAdmin(adminID);
		System.out.println("Showing Admin: "+theAdmin);
		return theAdmin;
	}

	
	// FUNCTIONAL
	@PostMapping(path="/admins")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin theAdmin) {
		Admin savedAdmin = adminService.addAdmin(theAdmin);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{adminID}").buildAndExpand(savedAdmin.getAdminID()).toUri();
		System.out.println("Created New Admin Account: "+savedAdmin);
		return ResponseEntity.created(location).build();
	}
	
	
	// FUNCTIONAL
	@PutMapping(path="/admins/{adminID}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateAdmin(@PathVariable Integer adminID, @RequestBody Admin theAdmin) {
		Admin savedAdmin = adminService.getAdmin(adminID);
		savedAdmin.setAdminUN(theAdmin.getAdminUN());
		savedAdmin.setAdminPW(theAdmin.getAdminPW());
		adminService.saveAdmin(savedAdmin);
		System.out.println("Saved Admin Information for: "+savedAdmin);
	}

	
	// FUNCTIONAL!
	@DeleteMapping(path="/admins/{adminID}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAdmin(@PathVariable Integer adminID) throws AdminNotFoundException {
		Admin theAdmin = adminService.getAdmin(adminID);
		
		// --> NOT FUNCTIONAL
		if (theAdmin == null) {
			throw new AdminNotFoundException("Admin ID: "+adminID+" was not found.");
		}
		adminService.deleteAdmin(adminID);
		System.out.println("Deleting Admin with ID: "+adminID);
	}

	
}
