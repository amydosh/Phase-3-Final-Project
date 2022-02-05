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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amydosh.sportyshoes.exception.PurchaseNotFoundException;
import com.amydosh.sportyshoes.model.Product;
import com.amydosh.sportyshoes.model.Purchase;
import com.amydosh.sportyshoes.service.PurchaseService;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	// FUNCTIONAL
	@GetMapping(path="/purchases")
	public @ResponseBody Iterable<Purchase> getAllPurchases() {
		System.out.println("Showing all purchases in database.");
		return purchaseService.getAllPurchases();
	}
	
	@GetMapping(path="/purchases/filterbyuser/{purchasedBy}")
	public @ResponseBody List<Purchase> retrievePurchasesByPurchasedBy(@PathVariable String purchasedBy) {
		List<Purchase> thePurchases = purchaseService.getPurchaseByPurchasedBy(purchasedBy);
		System.out.println("Showing all products of style "+purchasedBy+" in database: "+thePurchases);
		return thePurchases;
	}
	
	@GetMapping(path="/purchases/filterbydate/{purchaseDate}")
	public @ResponseBody List<Purchase> retrievePurchasesByPurchaseDate(@PathVariable String purchaseDate){
		List<Purchase> thePurchases = purchaseService.getPurchaseByPurchaseDate(purchaseDate);
		System.out.println("Showing all purchases made on date: "+purchaseDate+" ----"+thePurchases);
		return thePurchases;
	}
	
	// FUNCTIONAL
	@GetMapping(path="purchases/{transRecord}")
	public @ResponseBody Purchase retrievePurchase(@PathVariable Integer transRecord) {
		Purchase thePurchase = purchaseService.getPurchase(transRecord);
		System.out.println("Showing specific customer in database: "+thePurchase);
		return thePurchase;
	}
	
	// FUNCTIONAL
	@PostMapping(path="/purchases")
	public ResponseEntity<Purchase> createPurchase(@Valid @RequestBody Purchase thePurchase) {
		Purchase savedPurchase = purchaseService.addPurchase(thePurchase);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{transRecord}").buildAndExpand(savedPurchase.getTransRecord()).toUri();
		System.out.println("Created New Customer: "+savedPurchase);
		return ResponseEntity.created(location).build();
	}
	
	// FUNCTIONAL
	@PutMapping(path="/purchases/{transRecord}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePurchase(@PathVariable Integer transRecord, @RequestBody Purchase thePurchase) {
		Purchase savedPurchase = purchaseService.getPurchase(transRecord);
		savedPurchase.setPurchaseDate(thePurchase.getPurchaseDate());
		savedPurchase.setPurchasedBy(thePurchase.getPurchasedBy());
		savedPurchase.setPurchasedProducts(thePurchase.getPurchasedProducts());
		savedPurchase.setTotalPrice(thePurchase.getTotalPrice());
		purchaseService.savePurchase(thePurchase);
		System.out.println("Saved Customer Information for: "+savedPurchase);
	}

	// FUNCTIONAL
	@DeleteMapping(path="/purchases/{transRecord}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePurchase(@PathVariable Integer transRecord) throws PurchaseNotFoundException {
		Purchase thePurchase = purchaseService.getPurchase(transRecord);
		
		// --> NOT FUNCTIONAL
		if (thePurchase == null) {
			throw new PurchaseNotFoundException("Purchase Transaction Record: "+transRecord+" was not found.");
		}
		purchaseService.deletePurchase(transRecord);
		System.out.println("Deleting Purchase Transaction Record: "+transRecord);
	}

}
