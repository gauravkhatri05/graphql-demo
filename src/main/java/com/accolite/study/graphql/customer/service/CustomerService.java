package com.accolite.study.graphql.customer.service;

import com.accolite.study.graphql.customer.view.CustomerDTO;
import com.accolite.study.graphql.customer.view.CustomerFilterCriteriaDTO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {

    @Transactional(propagation = Propagation.REQUIRED)
    List<CustomerDTO> findAll(final CustomerFilterCriteriaDTO filter);

    @Transactional(propagation = Propagation.REQUIRED)
    CustomerDTO save(final CustomerDTO customer);
}
