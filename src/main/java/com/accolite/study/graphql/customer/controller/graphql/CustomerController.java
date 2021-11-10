package com.accolite.study.graphql.customer.controller.graphql;

import com.accolite.study.graphql.customer.service.CustomerService;
import com.accolite.study.graphql.customer.service.OrderService;
import com.accolite.study.graphql.customer.view.CustomerDTO;
import com.accolite.study.graphql.customer.view.CustomerFilterCriteriaDTO;
import com.accolite.study.graphql.customer.view.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    @SchemaMapping(typeName = "Mutation", field = "addCustomer")
    public CustomerDTO addCustomer(
        @Argument(name = "customerReq") final CustomerDTO customerReq
    ) {
        return this.customerService.save(customerReq);
    }

    @SchemaMapping(typeName = "Query", field = "customers")
    public List<CustomerDTO> customers(
        @Argument(name = "filter") final CustomerFilterCriteriaDTO filter
    ) {
        return this.customerService.findAll(filter);
    }

    @SchemaMapping(typeName = "Customer", field = "orders")
    public List<OrderDTO> orders(
       final CustomerDTO customer
    ) {

        log.info("START: CustomerController.orders with customer {}...", customer.getEmail());

        return this.orderService.customerOrders(customer);
    }
}
