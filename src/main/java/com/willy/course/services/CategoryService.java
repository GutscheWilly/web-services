package com.willy.course.services;

import com.willy.course.entities.Category;
import com.willy.course.repositories.CategoryRepository;
import com.willy.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
