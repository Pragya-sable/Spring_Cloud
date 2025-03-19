package com.example.demo.service;

import com.example.demo.modle.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceByList {


   /* List<Product> products = new ArrayList<>(Arrays.asList(new Product(101,"Mobile",10000),new Product(102,"Laptop",45000)
    ));
    public List<Product> getProducts(){

        return products;
    }

    public Product getProductById(int prodId) {
        return products.stream().filter(p -> p.getProdId() == prodId).findFirst().get();
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        int index = 0 ;
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProdId() == product.getProdId()){
                index = i;
            }
        }
        products.set(index,product);
    }

    public void deleteProduct(int prodId){
        int index = 0 ;
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProdId() == prodId){
                index = i;
            }
        }
        products.remove(index);
    }*/
}
