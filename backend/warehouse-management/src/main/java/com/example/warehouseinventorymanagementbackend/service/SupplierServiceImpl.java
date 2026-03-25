package com.example.warehouseinventorymanagementbackend.service;

import com.example.warehouseinventorymanagementbackend.entity.SupplierEntity;
import com.example.warehouseinventorymanagementbackend.repository.supplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private supplierRepository supplierRepository;


    @Override
    public List<SupplierEntity> getAllSuppliers(){
        return supplierRepository.findAll();
    }

}
