package com.amydosh.sportyshoes.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

import com.amydosh.sportyshoes.exception.CustomerNotFoundException;
import com.amydosh.sportyshoes.model.Customer;
import com.amydosh.sportyshoes.service.CustomerService;


@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	
	// Trying Model and View:
	@GetMapping(path="/showViewPage")
	public String passParametersWithModel(Model model) {
		Map<String, String> map = new HashMap<>();
		map.put("spring", "mvc");
		model.addAttribute("message", "Baeldung");
		model.mergeAttributes(map);
		return "viewPage";
	}

	
//	@GetMapping(path="/addCustomer")
//	public String addCustomerView(Model model) {
//		model.addAttribute("customer", new Customer());
//		return "view-customers";
//	}
	
	// FUNCTIONAL
	@GetMapping(path="/customers")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		System.out.println("Showing all customers in database.");
		return customerService.getAllCustomers();
	}
	
	
	
	// ----------------------------------------------------
	
	
	// FUNCTIONAL
	@GetMapping(path="customers/{custId}")
	public @ResponseBody Customer retrieveCustomer(@PathVariable Integer custId) {
		Customer theCustomer = customerService.getCustomer(custId);
		System.out.println("Showing specific customer in database: "+theCustomer);
		return theCustomer;
	}

	
	// FUNCTIONAL
	@PostMapping(path="/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer theCustomer) {
		Customer savedCustomer = customerService.addCustomer(theCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custId}").buildAndExpand(savedCustomer.getCustID()).toUri();
		System.out.println("Created New Customer: "+savedCustomer);
		return ResponseEntity.created(location).build();
	}
	
	
	// FUNCTIONAL
	@PutMapping(path="/customers/{custId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable Integer custId, @RequestBody Customer theCustomer) {
		Customer savedCustomer = customerService.getCustomer(custId);
		savedCustomer.setCustPW(theCustomer.getCustPW());
		savedCustomer.setCustEmail(theCustomer.getCustEmail());
		savedCustomer.setCustName(theCustomer.getCustName());
		customerService.saveCustomer(savedCustomer);
		System.out.println("Saved Customer Information for: "+savedCustomer);
	}

	
	// FUNCTIONAL!
	@DeleteMapping(path="/customers/{custId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Integer custId) throws CustomerNotFoundException {
		Customer theCustomer = customerService.getCustomer(custId);
		
		// --> NOT FUNCTIONAL
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer ID: "+custId+" was not found.");
		}
		customerService.deleteCustomer(custId);
		System.out.println("Deleting Customer with ID: "+custId);
	}

}
