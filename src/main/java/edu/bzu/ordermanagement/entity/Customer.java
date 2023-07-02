package edu.bzu.ordermanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "customer")
@Table
public class Customer {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private Date dOB;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getdOB() {
        return dOB;
    }
}
