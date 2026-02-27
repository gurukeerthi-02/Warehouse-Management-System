package com.example.warehouseinventorymanagementbackend.service;

import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import com.example.warehouseinventorymanagementbackend.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {

  @Autowired
  private productRepository productRepository;

  @Override
  public ProductEntity saveProduct(ProductEntity productEntity) {
    return productRepository.save(productEntity);
  }

  @Override
  public List<ProductEntity> fetchProducts() {
    return (List<ProductEntity>) productRepository.findAll();
  }

  @Override
  public void deleteProduct(@PathVariable Integer id) {
      productRepository.deleteById(id);
  }

  @Override
    public void buyStock(@PathVariable Integer id) {
      ProductEntity productEntity = productRepository.findById(id).get();
      productEntity.setProductQuantity(productEntity.getProductQuantity() - 1);
      productRepository.save(productEntity);
  }


}
