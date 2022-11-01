package com.example.demo.domain.data.employee.fields;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author anton
 * @since 11/1/2022, Tue
 **/

@Entity
public enum Degree {
    DR,
    PROF,
    ;

    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    @Id
    public UUID getId() {
        return id;
    }
}
