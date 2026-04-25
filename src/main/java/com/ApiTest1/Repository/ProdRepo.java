package com.ApiTest1.Repository;

import com.ApiTest1.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepo extends JpaRepository<Product, Integer>{

}
