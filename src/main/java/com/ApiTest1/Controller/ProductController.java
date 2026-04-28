package com.ApiTest1.Controller;

import com.ApiTest1.DTO.ProductRequest;
import com.ApiTest1.DTO.ResponseProduct;
import com.ApiTest1.Entity.Product;
import com.ApiTest1.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String greet(){
        return "Hello";
    }

    @GetMapping("/products")
    public ResponseEntity<List<ResponseProduct>> getProducts(){
    return ResponseEntity.ok(service.getProduct());
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ResponseProduct> getProductById(@PathVariable int id){
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<ResponseProduct> addProduct(@Valid @RequestBody ProductRequest request){
        ResponseProduct prod = service.addProduct(request);
        return ResponseEntity.status(201).body(prod);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }


    @PutMapping("products/{id}")
    public ResponseEntity<ResponseProduct> updateProduct(@PathVariable int id, @RequestBody @Valid ProductRequest request){
      ResponseProduct response = service.updateData(id, request);
      return ResponseEntity.ok(response);

    }

}
