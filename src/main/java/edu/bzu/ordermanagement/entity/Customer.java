package edu.bzu.ordermanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Entity(name = "customer")
@Table
public class Customer {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private Date dOB;
}
