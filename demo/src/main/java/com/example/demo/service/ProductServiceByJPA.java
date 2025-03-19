package com.example.demo.service;

import com.example.demo.modle.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceByJPA {
    @Autowired
    ProductRepository repository;

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById (int prodId){
        return repository.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product product){
        repository.save(product);
    }

    public void updateProduct(Product product)
    {
        repository.save(product);
    }

    public void deleteProduct(int prodId){
        repository.deleteById(prodId);
    }
}
