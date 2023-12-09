package dri.demo;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.ToString;
import dri.demo.model.FeedType;

@ToString
@Getter
@ApplicationScoped
public class SomeOtherFeedExtractor implements FeedExtractor {

  private final FeedType feedType;

  public SomeOtherFeedExtractor() {
    this.feedType = FeedType.OTHER_DOCUMENT;
  }

  @Override
  public String extract() {
    return "OTHER extract";
  }
}
