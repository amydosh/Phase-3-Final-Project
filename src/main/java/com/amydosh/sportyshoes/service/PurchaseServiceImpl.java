package com.amydosh.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amydosh.sportyshoes.model.Product;
import com.amydosh.sportyshoes.model.Purchase;
import com.amydosh.sportyshoes.repository.ProductRepository;
import com.amydosh.sportyshoes.repository.PurchaseRepository;

@Service(value="purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
    private PurchaseRepository purchaseRepository;


    @Override
    public Purchase addPurchase(Purchase thePurchase){
    	return purchaseRepository.saveAndFlush(thePurchase);
    }


	@Override
	public Purchase getPurchase(Integer transRecord) {
		return purchaseRepository.getById(transRecord);
	}
	
	@Override
	public Iterable<Purchase> getAllPurchases() {
		return purchaseRepository.findAll();
	}


	@Override
	public Purchase savePurchase(Purchase thePurchase) {
		return purchaseRepository.save(thePurchase);
	}


	@Override
	public void deletePurchase(Integer transRecord) {
		purchaseRepository.deleteById(transRecord);
		
	}


	@Override
	public List<Purchase> getPurchaseByPurchasedBy(String purchasedBy) {
		return purchaseRepository.getByPurchasedBy(purchasedBy);
	}


	@Override
	public List<Purchase> getPurchaseByPurchaseDate(String purchaseDate) {
		return purchaseRepository.getPurchaseByPurchaseDate(purchaseDate);
	}


}
