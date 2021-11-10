package com.accolite.study.graphql.customer.view;

import com.accolite.study.graphql.customer.model.CustomerEntity;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class CustomerDTO {

    private String id;
    @EqualsAndHashCode.Include
    private String email;
    private String name;
    private String fullName;

    public static CustomerDTO of(final CustomerEntity customerEntity) {

        return new CustomerDTO(
            customerEntity.getId().toString(),
            customerEntity.getEmail(),
            customerEntity.getName(),
            customerEntity.getName()
        );
    }

    public CustomerEntity convertIntoEntity() {

        return new CustomerEntity(
            null == this.getId() ? null : UUID.fromString(this.getId()),
            this.getEmail(),
            this.name
        );
    }
}
