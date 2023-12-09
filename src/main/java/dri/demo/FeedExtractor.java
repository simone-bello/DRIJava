package dri.demo;

import dri.demo.model.FeedType;
import dri.demo.model.PssDocument;

public interface FeedExtractor<T extends PssDocument> {

  FeedType getFeedType();

  String extract();
}
