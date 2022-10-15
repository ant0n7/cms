package com.example.demo.domain.data.employee;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_data_employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Size(min = 2, max = 25)
  @NotNull
  private String firstname;

  @Size(min = 2, max = 25)
  @NotNull
  private String lastname;

  @Email
  @NotNull
  @Column(unique = true)
  private String email;

  
}
