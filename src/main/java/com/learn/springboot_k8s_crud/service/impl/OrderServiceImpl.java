package com.learn.springboot_k8s_crud.service.impl;

import com.learn.springboot_k8s_crud.dto.CreateOrderRequestDto;
import com.learn.springboot_k8s_crud.dto.UpdateOrderRequestDto;
import com.learn.springboot_k8s_crud.entity.Order;
import com.learn.springboot_k8s_crud.repository.OrderRepository;
import com.learn.springboot_k8s_crud.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Order addOrder(CreateOrderRequestDto requestDto) {
        Order order = modelMapper.map(requestDto, Order.class);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateOrder(UpdateOrderRequestDto requestDto) {
        Order order = modelMapper.map(requestDto, Order.class);
        return orderRepository.save(order);
    }
}
