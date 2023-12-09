package dri.demo.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
//@ToString
public class Coupon {
  private final CouponStatus status;
  private final Integer number;
  private final String name;

}
