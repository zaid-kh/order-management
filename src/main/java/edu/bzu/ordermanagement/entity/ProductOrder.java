package edu.bzu.ordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class ProductOrder {
    // id is a composite primary key
    // productId is a foreign key from the product table
    // orderId is a foreign key from the order table
    @Id
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private int quantity;
    private double price;
    private double vat = getPrice() * 0.17; // vat is 17% of the price
}
