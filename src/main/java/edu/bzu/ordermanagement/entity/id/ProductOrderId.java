package edu.bzu.ordermanagement.entity.id;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Schema(hidden = true)
@Data
@Embeddable
public class ProductOrderId implements Serializable {
    private Long orderId;
    private Long productId;

}

