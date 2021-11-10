package com.accolite.study.graphql.customer.view;

import com.accolite.study.graphql.customer.constant.OrderStatus;
import com.accolite.study.graphql.customer.model.OrderEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrderDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6426870909658342534L;

    private String id;
    private String customerId;
    private Integer totalQuantity;
    private Double total;
    private OrderStatus status;

    public static OrderDTO of(final OrderEntity orderEntity) {

        return new OrderDTO(
            orderEntity.getId().toString(),
            orderEntity.getCustomerId().toString(),
            orderEntity.getTotalQuantity(),
            orderEntity.getTotal(),
            orderEntity.getStatus()
        );
    }
}
