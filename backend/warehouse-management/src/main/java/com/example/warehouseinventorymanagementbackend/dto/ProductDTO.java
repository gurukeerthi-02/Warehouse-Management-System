package com.example.warehouseinventorymanagementbackend.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
    private Integer supplierId;
}
