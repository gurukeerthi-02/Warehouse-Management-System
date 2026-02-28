package com.example.warehouseinventorymanagementbackend.controller;

import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import com.example.warehouseinventorymanagementbackend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

  @Autowired
  private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductEntity> saveProduct(@Valid @RequestBody ProductEntity productEntity) {
        ProductEntity savedProduct = productService.saveProduct(productEntity);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
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
