package com.management.products.controller;

import com.management.products.model.Product;
import com.management.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController  {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> listProducts() {
        return service.listProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        try {
            Product product = service.getProductById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existingProduct = service.getProductById(id);
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            service.saveProduct(existingProduct);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
    }
}
