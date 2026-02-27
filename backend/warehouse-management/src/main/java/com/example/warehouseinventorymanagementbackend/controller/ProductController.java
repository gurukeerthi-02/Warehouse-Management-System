package com.example.warehouseinventorymanagementbackend.controller;

import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import com.example.warehouseinventorymanagementbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/products")
  public ProductEntity saveProduct(@RequestBody ProductEntity productEntity){
    return productService.saveProduct(productEntity);

  }

  @GetMapping("/greet")
  public String greet(){
    return "Hello World";
  }

  @GetMapping("/fetchProducts")
  public List<ProductEntity> fetchProducts(){
    return (List<ProductEntity>) productService.fetchProducts();
  }

  @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id){
      productService.deleteProduct(id);
  }

  @PatchMapping("/buyStock/{id}")
    public void buyStock(@PathVariable Integer id){
      productService.buyStock(id);

  }

}
