package edu.bzu.ordermanagement.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slug; // unique (human-readable) identifier for a product
    private String name;
    @Size(max = 10)
    private double price;
    @Size(max = 10)
    private double vat;
    private boolean stockable;
    private String reference;
    // make sure price's format is 0.00
    // https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java

    private void setPrice(double price) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedPrice = decimalFormat.format(price);
        this.price = Double.parseDouble(formattedPrice);
    }

    @PrePersist
    @PostUpdate
    public void calculateVat() {
        double calculatedVat = this.price * 0.17; // 17% VAT

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedVat = decimalFormat.format(calculatedVat);
        this.vat = Double.parseDouble(formattedVat);
    }
}
