package dri.demo.model;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum FeedType {
  AIR_TRAVEL_DOCUMENT("This is an air travel document"),
  PNR_DOCUMENT("This is a pnr document"),
  INSURANCE_DOCUMENT("This is an insurance document"),
  OTHER_DOCUMENT("This is another type of document");

  private final String description;

  FeedType(String description) {
    this.description = description;
  }

  public static Optional<FeedType> nullableValueOf(String name) {
    try {
      return Optional.of(FeedType.valueOf(name));
    } catch (IllegalArgumentException ex) {
      return Optional.empty();
    }
  }
}
