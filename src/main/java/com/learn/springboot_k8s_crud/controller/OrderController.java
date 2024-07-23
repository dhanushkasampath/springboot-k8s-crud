package com.learn.springboot_k8s_crud.controller;

import com.learn.springboot_k8s_crud.dto.CreateOrderRequestDto;
import com.learn.springboot_k8s_crud.dto.UpdateOrderRequestDto;
import com.learn.springboot_k8s_crud.entity.Order;
import com.learn.springboot_k8s_crud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j//by using this annotation we do not need to declare and initialize the logger manually
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

//    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody CreateOrderRequestDto requestDto){
        log.info("Request received to add a new Order: {}", requestDto);
        Order responseDto = orderService.addOrder(requestDto);
        log.info("Response returned with created new order: {}",responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        log.info("Request received to get all orders");
        List<Order> responseDtoList = orderService.getOrders();
        log.info("Response returned with all orders: {}",responseDtoList);
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id){
        log.info("Request received to get order by id: {}", id);
        Order responseDto = orderService.getOrderById(id);
        log.info("Response returned with requested order: {}",responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Order> updateOrderById(@RequestBody UpdateOrderRequestDto requestDto){
        log.info("Request received to update the order of id: {}", requestDto.getId());
        Order responseDto = orderService.updateOrder(requestDto);
        log.info("Response returned after updating the order with id: {} | {}",responseDto.getId(), responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Integer id){
        log.info("Request received to delete order by id: {}", id);
        orderService.deleteOrderById(id);
        log.info("Response returned after deleting the order with id: {}",id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
