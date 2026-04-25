package com.ApiTest1.Controller;

import com.ApiTest1.Entity.Product;
import com.ApiTest1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    public ProductService service;

    @GetMapping("/")
    public String greet(){
        return "Hello";
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
    return service.getProduct();
    }


    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }


    @PutMapping("products")
    public void updateProduct(@RequestBody Product prod){
      service.updateData(prod);
    }

}
