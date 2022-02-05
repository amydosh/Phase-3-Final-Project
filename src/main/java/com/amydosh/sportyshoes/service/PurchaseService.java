package com.amydosh.sportyshoes.service;

import java.util.List;

import com.amydosh.sportyshoes.model.Purchase;

public interface PurchaseService {

	public Purchase getPurchase(Integer transRecord);

	public Iterable<Purchase> getAllPurchases();

	public Purchase savePurchase(Purchase thePurchase);

	public Purchase addPurchase(Purchase thePurchase);

	public void deletePurchase(Integer transRecord);

	public List<Purchase> getPurchaseByPurchasedBy(String purchasedBy);

	public List<Purchase> getPurchaseByPurchaseDate(String purchaseDate);
}
