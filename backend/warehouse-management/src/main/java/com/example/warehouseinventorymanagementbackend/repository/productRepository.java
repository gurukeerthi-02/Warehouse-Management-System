package com.example.warehouseinventorymanagementbackend.repository;

import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends CrudRepository<ProductEntity,Integer> {
}
