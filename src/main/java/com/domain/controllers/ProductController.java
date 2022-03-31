package com.domain.controllers;

import com.domain.dto.ResponseData;
import com.domain.models.entities.Product;
import com.domain.services.ProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product") // untuk memberi urlnya
public class ProductController {
    
//Controller akan memanggil Services dan services akan memanggil Repo
    @Autowired
    public ProductServices productServices;

//Membuat data
//menghadel validasi secara proper
    @PostMapping//@Valid -> anotasi valid ini untuk ngecek dulu data yg dikirim di repo itu valid ga?.
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors) {
        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors() ) {
                ResponseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productServices.save(product));
        return ResponseEntity.ok(responseData);
    }

//Mencari semua data
    @GetMapping
    public Iterable<Product> findAll(){
        return productServices.findAll();
    }

//mencari data berdasarkan id
    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id")Long id) {
        return productServices.findOne(id);
    }

//Update Data 
    @PutMapping
    public Product update(@RequestBody Product product) {
        return productServices.save(product);
    }

//Void itu untuk yg tidak butuh return
    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long id) {
        productServices.removeOne(id);
    }
}
