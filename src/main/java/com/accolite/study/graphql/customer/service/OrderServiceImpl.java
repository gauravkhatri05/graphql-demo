package com.accolite.study.graphql.customer.service;

import com.accolite.study.graphql.customer.repository.OrderRepository;
import com.accolite.study.graphql.customer.view.CustomerDTO;
import com.accolite.study.graphql.customer.view.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "orderServiceImpl")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDTO> customerOrders(CustomerDTO customer) {
        return this.orderRepository
            .customerOrders(customer)
            .stream()
            .map(OrderDTO::of)
            .collect(Collectors.toList());
    }
}
