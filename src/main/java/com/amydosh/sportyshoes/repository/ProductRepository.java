package com.amydosh.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amydosh.sportyshoes.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> getByProductStyle(String productStyle);

	List<Product> getByProductColor(String productColor);

}
