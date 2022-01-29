package com.example.multidatasourcepoc.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.multidatasourcepoc.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
