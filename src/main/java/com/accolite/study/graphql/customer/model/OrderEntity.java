package com.accolite.study.graphql.customer.model;

import com.accolite.study.graphql.customer.constant.OrderStatus;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrderEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2413644430889834422L;

    private UUID id;
    private UUID customerId;
    private Integer totalQuantity;
    private Double total;
    private OrderStatus status;
}
