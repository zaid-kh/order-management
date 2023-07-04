package edu.bzu.ordermanagement.entity;

import edu.bzu.ordermanagement.entity.id.ProductOrderId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table
public class ProductOrder {
    // id is a composite primary key
    // productId is a foreign key from the product table
    // orderId is a foreign key from the order table
    // https://www.baeldung.com/jpa-composite-primary-keys , this link aids in understanding composite primary keys
    @EmbeddedId
    private ProductOrderId id;

    @MapsId("orderId") // this annotation makes it work over the defined ManyToOne relationship
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @MapsId("productId")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    @Size(max = 10)
    private double price;
    @Size(max = 10)
    private double vat;

    @PrePersist
    public void calculateVat() {
        this.vat = this.price * 0.17;
    }
}
