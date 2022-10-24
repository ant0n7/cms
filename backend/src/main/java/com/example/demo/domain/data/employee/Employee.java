package com.example.demo.domain.data.employee;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.domain.data.employee.fields.Gender;
import com.example.demo.domain.data.employee.fields.ProfessionalStatus;

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

  // Gender (enum)
  private Gender gender;

  // List of EmployeeTitle (i.e: lic. iur.)
  @ElementCollection
  private List<String> degrees;

  // Partner Status (Partner, Associate, Junior Associate, Counsel, ...)
  private ProfessionalStatus professionalStatus;

  // Job Title (i.e: Attorney at law)
  private String jobTitle;

  // List of EmployeeTraining
  private String training;

  // List of EmployeeExperience
  @ElementCollection
  private List<String> experience;

  private String imageUrl;

  // List of EmployeeSecondaryProfesionalActivity

  // List of EmployeeAffiliation
  @ElementCollection
  private List<String> affiliations;

  // List of EmployeeSpecialization

  // List of Language
  // private List<Language> languages;
}
