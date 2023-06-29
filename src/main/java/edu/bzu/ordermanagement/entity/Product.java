package edu.bzu.ordermanagement.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slug; // unique (human-readable) identifier for a product
    private String name;
    private double price;
    private double vat = getPrice() * 0.17; // vat is 17% of the price
    private boolean stockable;
    private String reference;
}
