package dri.demo;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.ToString;
import dri.demo.model.FeedType;

@Getter
@ToString
@ApplicationScoped
public class AirTravelDocumentFeedExtactor implements FeedExtractor {

  private final FeedType feedType;

  public AirTravelDocumentFeedExtactor() {
    this.feedType = FeedType.AIR_TRAVEL_DOCUMENT;
  }

  @Override
  public String extract() {
    return "AIR extract";
  }
}
