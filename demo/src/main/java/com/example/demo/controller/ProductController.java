package com.example.demo.controller;

import com.example.demo.modle.Product;
import com.example.demo.service.ProductServiceByJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductServiceByJPA service;
    @GetMapping("/get")
  public List<Product> getProducts(){
      return service.getProducts();
  }

  @GetMapping("/get/{prodId}")
  public Product getProductById(@PathVariable int prodId){
       return service.getProductById(prodId);
  }
  @PostMapping("/post")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
  }

  @PutMapping("/put")
    public void update(@RequestBody Product product){
        service.updateProduct(product);
  }

  @DeleteMapping("/delete/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
  }
}
