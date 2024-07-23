package com.learn.springboot_k8s_crud.dto;

import lombok.Data;

@Data
public class CreateOrderRequestDto {

    private String name;
    private Integer qty;
    private Double price;
}
