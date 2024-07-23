package com.learn.springboot_k8s_crud.service;

import com.learn.springboot_k8s_crud.dto.CreateOrderRequestDto;
import com.learn.springboot_k8s_crud.dto.UpdateOrderRequestDto;
import com.learn.springboot_k8s_crud.entity.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(CreateOrderRequestDto requestDto);

    List<Order> getOrders();

    Order getOrderById(Integer id);

    void deleteOrderById(Integer id);

    Order updateOrder(UpdateOrderRequestDto requestDto);
}
