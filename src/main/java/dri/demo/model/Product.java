package dri.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Product {

  ProductStatus status;
  private String name;
  private String id;

}
