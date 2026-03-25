package com.example.warehouseinventorymanagementbackend;

import com.example.warehouseinventorymanagementbackend.entity.ProductEntity;
import com.example.warehouseinventorymanagementbackend.entity.SupplierEntity;
import com.example.warehouseinventorymanagementbackend.repository.productRepository;
import com.example.warehouseinventorymanagementbackend.repository.supplierRepository;
import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

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

          SupplierEntity salesWorth = new SupplierEntity();
          salesWorth.setSupplierName("Sales Worth Enterprise");
          salesWorth.setEmail("salesworth@gmail.com");
          supplierRepo.save(salesWorth);

          for(int i=0;i<10;i++){
              if(i%2==0){
                  ProductEntity ballPens = new ProductEntity();
                  ballPens.setProductName("Ball pens");
                  ballPens.setProductPrice(i+10d);
                  ballPens.setProductQuantity(i+20);
                  ballPens.setSupplierId(wordsWorth);

                  productRepo.save(ballPens);
              }else{
                  ProductEntity Books = new ProductEntity();
                  Books.setProductName("Books");
                  Books.setProductPrice(i+10d);
                  Books.setProductQuantity(i+20);
                  Books.setSupplierId(salesWorth);
                  productRepo.save(Books);
              }


          }


          System.out.println("Data seeding is successful");
//          System.out.println("The product "+ballPens.getProductName()+" has been linked with supplierid "+wordsWorth.getSupplierId());
      };
    }

}
