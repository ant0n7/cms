package com.example.demo.domain.data.employee;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.domain.data.employee.fields.*;
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
  @Column(unique = true)
  private String email;

  // Gender (enum)
  @ManyToOne
  private Gender gender;

  @ManyToMany
  private List<ProfessionalDegree> degrees;

  // Partner Status (Partner, Associate, Junior Associate, Counsel, ...)
  @ManyToOne
  private ProfessionalStatus professionalStatus;

  // Job Title (i.e: Attorney at law)
  private String jobTitle;

  private String description;

  // List of EmployeeTraining
  @OneToMany
  private List<EmployeeTraining> training;

  // List of EmployeeExperience
  @OneToMany
  private List<EmployeeExperience> experience;

  @OneToOne(cascade=CascadeType.ALL)
  private EmployeeImage image;

  // List of EmployeeSecondaryProfesionalActivity

  // List of EmployeeAffiliation
  @ElementCollection
  private List<String> affiliations;

  // List of EmployeeSpecialization

  // List of Language
  // private List<Language> languages;
}
