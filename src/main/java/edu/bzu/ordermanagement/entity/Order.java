package edu.bzu.ordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "orders") // order is a reserved keyword in sql
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    // error : 'Basic' attribute type should not be 'Persistence Entity'  solved by relationship annotation
    @ManyToOne
    private Customer customer;

    private Date orderedAt;
}
