package com.willy.course.services;

import com.willy.course.entities.Product;
import com.willy.course.repositories.ProductRepository;
import com.willy.course.services.exceptions.DatabaseException;
import com.willy.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Product insert(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        try {
            productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException exception) {
            throw new DatabaseException(exception.getMessage());
        }
    }

    public Product update(Long id, Product updatedProduct) {
        try {
            Product currentProduct = productRepository.getReferenceById(id);
            updateData(currentProduct, updatedProduct);
            return productRepository.save(currentProduct);
        }
        catch (EntityNotFoundException exception) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product currentProduct, Product updatedProduct) {
        currentProduct.setName(updatedProduct.getName());
        currentProduct.setDescription(updatedProduct.getDescription());
        currentProduct.setPrice(updatedProduct.getPrice());
        currentProduct.setImageUrl(updatedProduct.getImageUrl());
    }
}
