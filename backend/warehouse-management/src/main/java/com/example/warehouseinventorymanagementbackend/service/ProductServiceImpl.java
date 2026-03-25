package com.example.warehouseinventorymanagementbackend.service;

import com.example.warehouseinventorymanagementbackend.dto.ProductDTO;
import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import com.example.warehouseinventorymanagementbackend.entity.SupplierEntity;
import com.example.warehouseinventorymanagementbackend.exception.InsufficientStockException;
import com.example.warehouseinventorymanagementbackend.repository.productRepository;
import com.example.warehouseinventorymanagementbackend.repository.supplierRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {

  @Autowired
  private productRepository productRepository;

  @Autowired
  private supplierRepository supplierRepository;

  @Override
  public ProductEntity saveProduct(ProductDTO dto) {
    ProductEntity savedProduct = new ProductEntity();
    savedProduct.setProductName(dto.getProductName());
    savedProduct.setProductQuantity(dto.getProductQuantity());
    savedProduct.setProductPrice(dto.getProductPrice());

    SupplierEntity suppplier = supplierRepository.findById(dto.getSupplierId()).orElseThrow(
            () -> new EntityNotFoundException("Supplier not found")
    );

    savedProduct.setSupplierId(suppplier);
    return productRepository.save(savedProduct);

  }

  @Override
  public Page<ProductEntity> fetchProducts(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortBy) {
      Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
      return productRepository.findAll(pageable);
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

  @Transactional
  @Override
  public void dispatchProduct(Integer id, Integer quantity) {
      ProductEntity productEntity = productRepository.findById(id).orElseThrow(
              () -> new EntityNotFoundException("Product not found with id " + id));
      if(quantity >  productEntity.getProductQuantity()) {
          throw new InsufficientStockException("Insufficient quantity for ID: " + id);
      }
      productEntity.setProductQuantity(productEntity.getProductQuantity() - quantity);
      productRepository.save(productEntity);

  }

  @Override
    public Double calculateTotalValue(){
      Double total = productRepository.calculateTotalValue();

      return total != null? total : 0;
  }

}
