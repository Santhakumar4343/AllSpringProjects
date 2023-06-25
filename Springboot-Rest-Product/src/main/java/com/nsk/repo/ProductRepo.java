package com.nsk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsk.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
