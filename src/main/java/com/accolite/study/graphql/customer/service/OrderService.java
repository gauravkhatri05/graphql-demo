package com.accolite.study.graphql.customer.service;

import com.accolite.study.graphql.customer.view.CustomerDTO;
import com.accolite.study.graphql.customer.view.OrderDTO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {

    @Transactional(propagation = Propagation.SUPPORTS)
    List<OrderDTO> customerOrders(final CustomerDTO customer);
}
