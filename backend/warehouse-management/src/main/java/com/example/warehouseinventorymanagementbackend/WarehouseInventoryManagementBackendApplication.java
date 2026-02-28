package com.example.warehouseinventorymanagementbackend;

import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import com.example.warehouseinventorymanagementbackend.entity.SupplierEntity;
import com.example.warehouseinventorymanagementbackend.repository.productRepository;
import com.example.warehouseinventorymanagementbackend.repository.supplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WarehouseInventoryManagementBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(WarehouseInventoryManagementBackendApplication.class, args);

  }

    @Bean
    public CommandLineRunner handleDataSeeding(productRepository productRepo, supplierRepository supplierRepo) {
      return args ->{
          SupplierEntity wordsWorth = new SupplierEntity();
          wordsWorth.setSupplierName("Words Worth Enterprise");
          wordsWorth.setEmail("wwe@gmail.com");

          supplierRepo.save(wordsWorth);

          ProductEntity ballPens = new ProductEntity();
          ballPens.setProductName("Ball pens");
          ballPens.setProductPrice(20d);
          ballPens.setProductQuantity(10);

          ballPens.setSupplier_id(wordsWorth);

          productRepo.save(ballPens);

          System.out.println("Data seeding is successful");
          System.out.println("The product "+ballPens.getProductName()+" has been linked with supplierid "+wordsWorth.getSupplierId());
      };
    }

}
