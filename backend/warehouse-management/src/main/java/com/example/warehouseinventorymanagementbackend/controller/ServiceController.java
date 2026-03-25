package com.example.warehouseinventorymanagementbackend.controller;

import com.example.warehouseinventorymanagementbackend.entity.SupplierEntity;
import com.example.warehouseinventorymanagementbackend.repository.supplierRepository;
import com.example.warehouseinventorymanagementbackend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/fetchSuppliers")
    public List<SupplierEntity> getSuplliers(){
        return supplierService.getAllSuppliers();
    }
}
