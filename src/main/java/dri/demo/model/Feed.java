package dri.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Feed {

  private final FeedType feedType;
  private final String document;
  private final String id;
}


