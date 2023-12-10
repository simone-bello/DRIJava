package dri.demo;

import dri.demo.model.AirTravelDocument;
import dri.demo.model.Coupon;
import dri.demo.model.CouponStatus;
import dri.demo.model.Feed;
import dri.demo.model.FeedType;
import dri.demo.model.PnrDocument;
import dri.demo.model.Product;
import dri.demo.model.ProductStatus;
import dri.demo.model.PssDocument;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ApplicationScoped
public class DocumentService {

  private List<PssDocument> allDocuments;
  static Random random = new Random(109);

  @PostConstruct
  void init() {
    List<PssDocument> pssDocuments = IntStream.range(0, random.nextInt(100))
        .mapToObj(Generator::generatePnrDocument)
        .toList();

    List<PssDocument> airTravelDocuments = IntStream.range(0, random.nextInt(100))
        .mapToObj(Generator::generateAirTraveldocument)
        .toList();

    allDocuments = Stream.of(pssDocuments, airTravelDocuments)
        .flatMap(List::stream)
        .toList();
  }

  // FIXME: NPE on filtering
  //  example : /document?type=PNR
  public List<PssDocument> all_fixme(String type) {

    return allDocuments.stream()
        .filter(d -> d.getType().equals(FeedType.valueOf(type)))
        .toList();
  }

  public List<PssDocument> all(String type) {
    Optional<FeedType> fromParam = FeedType.nullableValueOf(type);

    return allDocuments.stream()
        .filter(d -> fromParam.isEmpty() || d.getType().equals(fromParam.get()))
        .toList();
  }

  // FIXME: NPE on get()
  //  example 1:  /document?type=INSURANCE
  //  example 2:  /document
  public PssDocument one_fixme(String type) {
    return allDocuments.stream()
        .filter(d -> d.getType().equals(FeedType.valueOf(type)))
        .findFirst()
        .get();
  }

  public Optional<PssDocument> one(String type) {
    Optional<FeedType> fromParam = FeedType.nullableValueOf(type);
    return allDocuments.stream()
        .filter(d -> fromParam.isEmpty() || d.getType().equals(fromParam.get()))
        .findAny();
  }

  // FIXME: wrong result
  //  example : /products
  public Collection<Product> getAllProducts_fixme(String type) {
    return allDocuments.stream()
        .filter(d -> d.getType().equals(FeedType.valueOf(type)))
        .findFirst()
        .get()
        .getProducts();
  }

  public Collection<Product> getAllProducts(String type) {

    Optional<FeedType> fromParam = FeedType.nullableValueOf(type);

    return allDocuments.stream()
        .filter(d -> fromParam.isEmpty() || d.getType().equals(fromParam.get()))
        .map(PssDocument::getProducts)
        .flatMap(Collection::stream)
        .collect(Collectors.toSet());
  }

  // FIXME: not implemented
  public Map<PssDocument, Integer> getCouponsByDocument_fixme(String type) {

    throw new NotImplementedException();
  }

  public Map<PssDocument, Integer> getCouponsByDocument(String type) {
    Optional<FeedType> fromParam = FeedType.nullableValueOf(type);

    return allDocuments.stream()
        .filter(d -> fromParam.isEmpty() || d.getType().equals(fromParam.get()))
        .collect(Collectors.toMap(
            Function.identity(),
            x -> x.getCoupons().size()
        ));
  }

  class Generator {

    static String generateRandomString(Random random, int size) {

      final int LETTER_A = 97; // letter 'a'
      final int LETTER_Z = 122; // letter 'z'
      return random.ints(LETTER_A, LETTER_Z + 1)
          .limit(size)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    }

    static Set<Product> generateProducts() {
      return IntStream.range(0, random.nextInt(30))
          .mapToObj(index ->
              Product.builder()
                  .status(ProductStatus.values()[random.nextInt(ProductStatus.values().length)])
                  .id(UUID.randomUUID().toString())
                  .name(generateRandomString(random, 10))
                  .build()
          )
          .collect(Collectors.toSet());
    }

    static Set<Feed> generateFeeds(FeedType feedType) {
      return IntStream.range(1, random.nextInt(3))
          .mapToObj(index ->
              Feed.builder()
                  .feedType(feedType)
                  .id(UUID.randomUUID().toString())
                  .document(generateRandomString(random, 100))
                  .build()
          )
          .collect(Collectors.toSet());
    }

    static Set<Coupon> generateCoupons() {
      return IntStream.range(1, random.nextInt(10))
          .mapToObj(index ->
              Coupon.builder()
                  .status(CouponStatus.values()[random.nextInt(ProductStatus.values().length)])
                  .number(index)
                  .name(generateRandomString(random, 10))
                  .build()
          )
          .collect(Collectors.toSet());
    }

    static PssDocument generateAirTraveldocument(int index) {
      return AirTravelDocument
          .builder()
          .id(UUID.randomUUID().toString())
          .products(generateProducts())
          .feeds(generateFeeds(FeedType.AIR_TRAVEL_DOCUMENT))
          .coupons(generateCoupons())
          .build();
    }

    static PssDocument generatePnrDocument(int index) {
      return PnrDocument
          .builder()
          .id(UUID.randomUUID().toString())
          .products(generateProducts())
          .feeds(generateFeeds(FeedType.AIR_TRAVEL_DOCUMENT))
          .coupons(generateCoupons())
          .build();
    }
  }
}
