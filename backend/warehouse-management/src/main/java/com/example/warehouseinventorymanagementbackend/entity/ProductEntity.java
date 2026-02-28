package com.example.warehouseinventorymanagementbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

  @NotBlank(message = "Product name cannot be blank.")
  private String productName;

  @NotNull(message = "Product price is required.")
  @Min(value = 0, message = "Product price cannot be negative.")
  private Double productPrice;

  @NotNull(message = "Product quantity is required")
  @Min(value = 0, message = "Product quantity cannot be negative")
  private Integer productQuantity;

  @ManyToOne()
  @JoinColumn(name = "supplier_id")
  SupplierEntity supplier_id;
}
