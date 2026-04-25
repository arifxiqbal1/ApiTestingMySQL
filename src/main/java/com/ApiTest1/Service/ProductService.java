package com.ApiTest1.Service;

import com.ApiTest1.Entity.Product;
import com.ApiTest1.Repository.ProdRepo;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

//     List<Product> products =  new ArrayList<>(Arrays.asList(
//            new Product(1,"Mobile", 23000),
//            new Product(2, "Laptop", 399900)));
    @Autowired
    public ProdRepo repo;

    public List<Product> getProduct(){
        return repo.findAll();
    }

    public Product getProductById(int id){
        return repo.findById(id).orElse(new Product(0,"none", 0));
    }

    public void addProduct(Product product){
        repo.save(product);
    }

    public void deleteProduct(int id){
        repo.deleteById(id);
    }

    public void updateData(Product prod){
        repo.save(prod);
    }
}
