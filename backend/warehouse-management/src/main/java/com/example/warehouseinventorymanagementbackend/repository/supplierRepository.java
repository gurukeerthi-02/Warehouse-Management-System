package com.example.warehouseinventorymanagementbackend.repository;

import com.example.warehouseinventorymanagementbackend.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface supplierRepository extends JpaRepository<SupplierEntity,Integer> {

}
