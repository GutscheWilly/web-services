package com.willy.course.services;

import com.willy.course.entities.Order;
import com.willy.course.repositories.OrderRepository;
import com.willy.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> optional = orderRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
