package dri.demo.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;
import java.util.StringJoiner;

@Builder
//@ToString
@Getter
public class PnrDocument implements PssDocument {

  private final Set<Coupon> coupons;

  private final Set<Feed> feeds;

  private final Set<Product> products;

  private final String id;

  private final FeedType type = FeedType.PNR_DOCUMENT;

  @Override
  public String toString() {
    return new StringJoiner(", ", PnrDocument.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .toString();
  }
}
