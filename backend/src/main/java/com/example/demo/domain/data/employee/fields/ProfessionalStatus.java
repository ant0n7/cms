package com.example.demo.domain.data.employee.fields;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public enum ProfessionalStatus {
  JUNIOR_ASSOCIATE,
  ASSOCIATE,
  COUNSEL,
  PARTNER,
  CEO;

  private UUID id;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  public UUID getId() {
    return id;
  }
}
