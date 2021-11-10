package com.accolite.study.graphql.customer.service;

import com.accolite.study.graphql.customer.repository.CustomerRepository;
import com.accolite.study.graphql.customer.view.CustomerDTO;
import com.accolite.study.graphql.customer.view.CustomerFilterCriteriaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service(value = "customerServiceImpl")
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> findAll(final CustomerFilterCriteriaDTO filter) {
        return this.customerRepository
            .findByNameContainingIgnoreCase(null == filter ? null : filter.getName())
            .stream()
            .map(CustomerDTO::of)
            .collect(toList());
    }

    @Override
    public CustomerDTO save(final CustomerDTO customer) {
        return CustomerDTO.of(
            this.customerRepository.save(customer.convertIntoEntity())
        );
    }
}
