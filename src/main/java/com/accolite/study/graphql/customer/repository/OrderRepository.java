package com.accolite.study.graphql.customer.repository;

import com.accolite.study.graphql.customer.constant.OrderStatus;
import com.accolite.study.graphql.customer.model.OrderEntity;
import com.accolite.study.graphql.customer.view.CustomerDTO;
import com.accolite.study.graphql.util.Utils;
import com.ibm.icu.text.Collator;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository(value = "orderRepository")
public class OrderRepository {

    public List<OrderEntity> customerOrders(CustomerDTO customer) {
        return IntStream
            .rangeClosed(1, Utils.getRandomNumber(8))
            .mapToObj(orderNumber -> {

                var totalQuantity = Utils.getRandomNumber(100);
                var total = Double.valueOf(totalQuantity * Utils.getRandomNumber(10));

                return new OrderEntity(
                    UUID.randomUUID(),
                    UUID.fromString(customer.getId()),
                    totalQuantity,
                    total,
                    Math.random() > 0.5 ? OrderStatus.SUCCESS : OrderStatus.FAILED
                );
            }).collect(Collectors.toList());
    }
}
