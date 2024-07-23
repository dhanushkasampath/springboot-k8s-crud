package com.learn.springboot_k8s_crud.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOrderRequestDto {

    @NotNull(message = "ID can not be null")
    private Integer id;
    private String name;
    private Integer qty;
    private Double price;
}
