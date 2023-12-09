package dri.demo.model;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

public interface PssDocument {

  Set<Feed> getFeeds();

  Set<Coupon> getCoupons();

  Set<Product> getProducts();

  FeedType getType();

  String getId();

  default PssDocument empty(){
    return new PssDocument() {

      @Override
      public Set<Feed> getFeeds() {
        return Collections.emptySet();
      }

      @Override
      public Set<Coupon> getCoupons() {
        return Collections.emptySet();
      }

      @Override
      public Set<Product> getProducts() {
        return Collections.emptySet();
      }

      @Override
      public FeedType getType() {
        return FeedType.OTHER_DOCUMENT;
      }

      @Override
      public String getId() {
        return UUID.randomUUID().toString();
      }
    };
  }

}
