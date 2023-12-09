package dri.demo.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Traveller {

  private final String firstName;
  private final String lastName;
  private final Date birthDay;
  private final GenderType genderType;
  private final String contact;

  public Traveller(String firstName, String lastName, Date birthDay, GenderType genderType, String contact) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDay = birthDay;
    this.genderType = genderType;
    this.contact = contact;
  }
}
