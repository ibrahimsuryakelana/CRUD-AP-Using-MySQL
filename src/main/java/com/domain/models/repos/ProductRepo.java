package com.domain.models.repos;

import com.domain.models.entities.Product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Menambahkan extend CrudRepository agar otomatis crud - <Nama Entities, tipe data id>
public interface ProductRepo extends CrudRepository<Product,Long> {
    
    List<Product> findByNameContains(String name); //berhubung search by name tidak ada diCrudRepository jadi kita custom sendiri
}
