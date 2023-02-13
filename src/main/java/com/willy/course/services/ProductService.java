package com.willy.course.services;

import com.willy.course.entities.Product;
import com.willy.course.repositories.ProductRepository;
import com.willy.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
