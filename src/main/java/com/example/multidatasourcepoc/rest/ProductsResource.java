package com.example.multidatasourcepoc.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multidatasourcepoc.model.Product;
import com.example.multidatasourcepoc.repo.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductsResource {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {

        return StreamSupport.stream((productRepository.findAll().spliterator()), false).collect(Collectors.toList());
    }

}
