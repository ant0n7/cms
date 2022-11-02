package com.example.demo.domain.data.employee.fields;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author anton
 * @since 11/1/2022, Tue
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeImage {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

}
