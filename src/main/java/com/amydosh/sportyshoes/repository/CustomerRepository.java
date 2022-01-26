package com.amydosh.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amydosh.sportyshoes.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{



}
