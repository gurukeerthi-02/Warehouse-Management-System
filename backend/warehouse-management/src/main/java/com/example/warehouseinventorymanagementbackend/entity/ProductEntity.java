package com.example.warehouseinventorymanagementbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer productId;
  private String productName;
  private Double productPrice;
  private Integer productQuantity;

  @ManyToOne()
  @JoinColumn(name = "supplier_id")
  SupplierEntity supplier_id;
}
