//Folder Entities itu untuk migrate Table ke db
package com.domain.models.entities;

import org.apache.logging.log4j.message.Message;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
    
    private static final long serialVersionUID = 1L;
//Membuat field ID
    @Id // Mendeklarasikan bahwa fiel id ini adalah id dari tb_product
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Agar ID Autoincrement dan Primarykey
    private Long id;

//Membuat field Name
    @NotEmpty(message = "Name is Requared ")//Validasi nama tidak boleh kosong
    @Column(name="product_name", length=100)//kalo salah menamakan field kita bisa ubah menggunakan @Column
    private String name;

//Membuat field Description
    @NotEmpty(message = "Description is requared") //Validasi deskripsi tidak boleh kosong
    @Column(name="product_description", length = 500) //kalo salah menamakan field kita bisa ubah menggunakan @Column
    private String description;

//Membuat field Price
    private double price;

//Setelah membuat field, lakukan Setters & getters
    public Product() {
    }

    public Product(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
