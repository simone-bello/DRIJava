package dri.demo;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.ToString;
import dri.demo.model.FeedType;

@ToString
@Getter
@ApplicationScoped
public class PnrFeedExtractor implements FeedExtractor {

  private final FeedType feedType;

  PnrFeedExtractor(){
    this.feedType = FeedType.PNR_DOCUMENT;
  }

  @Override
  public String extract() {
    return "PNR extract";
  }
}
