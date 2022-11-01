package com.example.demo.domain.data.employee.fields;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author anton
 * @since 11/1/2022, Tue
 **/

@Entity
@Getter
@Setter
public class EmployeeExperience {
    @Id
    UUID id;

    @NotNull
    String description;
}
