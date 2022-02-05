package com.amydosh.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amydosh.sportyshoes.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

	List<Purchase> getByPurchasedBy(String purchasedBy);

	List<Purchase> getPurchaseByPurchaseDate(String purchaseDate);

}
