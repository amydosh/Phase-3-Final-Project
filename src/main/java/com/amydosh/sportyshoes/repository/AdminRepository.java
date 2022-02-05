package com.amydosh.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amydosh.sportyshoes.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
