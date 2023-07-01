package edu.bzu.ordermanagement.entity.id;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ProductOrderId implements Serializable {
    private Long orderId;
    private Long productId;

}

