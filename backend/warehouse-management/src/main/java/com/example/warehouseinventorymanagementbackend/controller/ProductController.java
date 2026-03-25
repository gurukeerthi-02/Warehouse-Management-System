package com.example.warehouseinventorymanagementbackend.controller;

import com.example.warehouseinventorymanagementbackend.dto.ProductDTO;
import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import com.example.warehouseinventorymanagementbackend.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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

    @PostMapping("/addProduct")
    public ResponseEntity<ProductEntity> saveProduct(@Valid @RequestBody ProductDTO dto) {
        ProductEntity savedProduct = productService.saveProduct(dto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

  @GetMapping("/greet")
  public String greet(){
    return "Hello World";
  }

  @GetMapping("/fetchProducts")
  public Page<ProductEntity> fetchProducts(
          @Valid
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(defaultValue = "productId") String sortBy){
    return productService.fetchProducts(page, size, sortBy);
  }

  @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id){
      productService.deleteProduct(id);
  }

  @PatchMapping("/buyStock/{id}")
    public void buyStock(@PathVariable Integer id){
      productService.buyStock(id);

  }


  @Operation(summary = "Purchase stock", description = "Deducts quantity from a product and handles stock validation.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Stock updated successfully"),
        @ApiResponse(responseCode = "400", description = "Insufficient stock or invalid ID")
    })
  @PatchMapping("/purchaseStock")
    public void purchaseStock(
            @RequestParam Integer id,
            @RequestParam Integer quantity
  ){
        productService.dispatchProduct(id, quantity);
  }

  @GetMapping("/totalValue")
    public Double getTotalValue(){
        return productService.calculateTotalValue();
  }
}
