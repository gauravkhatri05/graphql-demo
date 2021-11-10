package com.accolite.study.graphql.customer.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -8209065216431609584L;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private UUID id;

    @EqualsAndHashCode.Include
    @Column(name = "EMAIL", length = 255, unique = true, nullable = false)
    private String email;

    @Column(name = "NAME", length = 50, unique = true, nullable = false)
    private String name;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CustomerEntity that = (CustomerEntity) o;

        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
