package com.learn.springboot_k8s_crud.repository;

import com.learn.springboot_k8s_crud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
