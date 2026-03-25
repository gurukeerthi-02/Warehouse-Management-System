package com.example.warehouseinventorymanagementbackend.repository;

import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<ProductEntity,Integer> {

    @Query("SELECT SUM (p.productPrice * p.productQuantity) FROM ProductEntity p")
    Double calculateTotalValue();
}
