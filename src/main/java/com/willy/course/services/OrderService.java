package com.willy.course.services;

import com.willy.course.entities.Order;
import com.willy.course.repositories.OrderRepository;
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

    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        try {
            orderRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException exception) {
            throw new DatabaseException(exception.getMessage());
        }
    }

    public Order update(Long id, Order updatedOrder) {
        try {
            Order currentOrder = orderRepository.getReferenceById(id);
            updateData(currentOrder, updatedOrder);
            return orderRepository.save(currentOrder);
        }
        catch (EntityNotFoundException exception) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Order currentOrder, Order updatedOrder) {
        currentOrder.setMoment(updatedOrder.getMoment());
        currentOrder.setOrderStatus(updatedOrder.getOrderStatus());
        currentOrder.setClient(updatedOrder.getClient());
    }
}
