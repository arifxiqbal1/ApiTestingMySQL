package com.ApiTest1.Service;

import com.ApiTest1.DTO.ProductRequest;
import com.ApiTest1.DTO.ResponseProduct;
import com.ApiTest1.Entity.Product;
import com.ApiTest1.Exceptions.ProductNotFoundException;

import com.ApiTest1.Repository.ProdRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    @Autowired
    public ProdRepo repo;

    public ProductService(ProdRepo repo) {
        this.repo = repo;
    }

    private ResponseProduct mapToResponse(Product product) {
        ResponseProduct response = new ResponseProduct();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        return response;
    }

    public List<ResponseProduct> getProduct(){
        return repo.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public ResponseProduct getProductById(int id){
        Product product = repo.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found with id: " + id));
        return mapToResponse(product);
    }

    public ResponseProduct addProduct(ProductRequest request){

        // Step 1 — create empty Product entity
        Product product = new Product();

        // Step 2 — fill it with data from request
        // request has name and price from client
        // we copy them into the entity
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        // Step 3 — save to database
        // after save, product.getId() has the auto-generated id
        Product saved = repo.save(product);

        // Step 4 — convert saved entity to response DTO
        // client needs to know the id that was generated
        ResponseProduct response = new ResponseProduct();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setPrice(saved.getPrice());

        // Step 5 — return response to controller
        return response;
    }

    public void deleteProduct(int id){
        if (!repo.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        repo.deleteById(id);
    }

    public ResponseProduct updateData(int id, ProductRequest prod){
        Product product = repo.findById(id).orElseThrow(() ->
         new ProductNotFoundException("Product not found with id: " + id));

            product.setName(prod.getName());
            product.setPrice(prod.getPrice());
         Product updated = repo.save(product);
         return mapToResponse(updated);
        }
}


