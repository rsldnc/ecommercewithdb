package com.turkcell.ecommercewdb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name= "products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private double price;

    @ManyToOne()
    @JoinColumn(name="categoryid")
    private Category category;

    @ManyToOne()
    @JoinColumn(name="brandid")
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderProduct> orderProductList;
}
