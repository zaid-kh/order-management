package edu.bzu.ordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table
public class Stock {
    @Id
    private Long id;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product product;
    private int quantity;
    private Date updatedAt;
}
