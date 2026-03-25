package com.example.warehouseinventorymanagementbackend.service;

import com.example.warehouseinventorymanagementbackend.dto.ProductDTO;
import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {

  ProductEntity saveProduct(ProductDTO dto);

  Page<ProductEntity> fetchProducts(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortBy);

  void deleteProduct(@PathVariable Integer id);

  void buyStock(@PathVariable Integer id);

  void dispatchProduct(@PathVariable Integer id, Integer quantity);

  Double calculateTotalValue();
}
