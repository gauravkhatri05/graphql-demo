package com.accolite.study.graphql.customer.repository;

import com.accolite.study.graphql.customer.model.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID> {

    @Query("SELECT c FROM CustomerEntity c WHERE :name IS NULL OR UPPER(c.name) LIKE '%' || UPPER(TRIM(:name)) || '%'")
    List<CustomerEntity> findByNameContainingIgnoreCase(
        @Param("name") final String name
    );
}
