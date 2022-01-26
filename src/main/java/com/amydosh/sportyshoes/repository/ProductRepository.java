package com.amydosh.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amydosh.sportyshoes.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
