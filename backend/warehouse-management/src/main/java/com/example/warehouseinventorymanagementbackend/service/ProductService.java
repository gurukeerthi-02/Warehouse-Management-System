package com.example.warehouseinventorymanagementbackend.service;

import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {

  ProductEntity saveProduct(ProductEntity productEntity);

  List<ProductEntity> fetchProducts();

  void deleteProduct(@PathVariable Integer id);

  void buyStock(@PathVariable Integer id);
}
