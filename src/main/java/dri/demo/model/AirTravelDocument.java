package dri.demo.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;
import java.util.StringJoiner;

@Getter
@Builder
public class AirTravelDocument implements PssDocument {

  private final Set<Coupon> coupons;

  private final Set<Feed> feeds;

  private final Set<Product> products;

  private final String id;

  private final FeedType type = FeedType.AIR_TRAVEL_DOCUMENT;

  @Override
  public String toString() {
    return new StringJoiner(", ", PnrDocument.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .toString();
  }
}
