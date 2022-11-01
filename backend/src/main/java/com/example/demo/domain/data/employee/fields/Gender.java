package com.example.demo.domain.data.employee.fields;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public enum Gender {
  MALE,
  FEMALE,
  OTHER;

  private UUID id;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  public UUID getId() {
    return id;
  }
}
