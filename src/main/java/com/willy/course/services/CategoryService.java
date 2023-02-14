package com.willy.course.services;

import com.willy.course.entities.Category;
import com.willy.course.repositories.CategoryRepository;
import com.willy.course.services.exceptions.DatabaseException;
import com.willy.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        try {
            categoryRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException exception) {
            throw new DatabaseException(exception.getMessage());
        }
    }

    public Category update(Long id, Category updatedCategory) {
        try {
            Category currentCategory = categoryRepository.getReferenceById(id);
            updateData(currentCategory, updatedCategory);
            return categoryRepository.save(currentCategory);
        }
        catch (EntityNotFoundException exception) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Category currentCategory, Category updatedCategory) {
        currentCategory.setName(updatedCategory.getName());
    }
}
