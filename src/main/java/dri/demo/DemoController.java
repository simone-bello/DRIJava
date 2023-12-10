package dri.demo;

import dri.demo.model.FeedType;
import io.quarkus.arc.All;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Path("/demo")
public class DemoController {

  @Inject
  DocumentService documentService;

  private final Map<FeedType, FeedExtractor> extractors;

  public DemoController(@All List<FeedExtractor> extractors) {
    this.extractors = extractors
        .stream()
        .collect(
            Collectors.toMap(
                FeedExtractor::getFeedType,
                Function.identity()
            ));
  }

  @GET
  @Path("extract/{type}")
  @Produces(MediaType.TEXT_PLAIN)
  public String extract(@PathParam("type") String type) {
    return
        Optional.ofNullable(extractors.get(type))
            .map(FeedExtractor::extract)
            .orElse("type not found");
  }


  @GET
  @Path("/documents")
  @Produces(MediaType.APPLICATION_JSON)
  public Response all(@QueryParam("type") String type) {

    return Response
        .ok(documentService.all_fixme(type))
        .build();
  }


  @GET
  @Path("/document")
  @Produces(MediaType.APPLICATION_JSON)
  public Response one(@QueryParam("type") String type) {
    return Response
        .ok(documentService.one_fixme(type))
        .build();
  }

  @GET
  @Path("/products")
  @Produces(MediaType.APPLICATION_JSON)
  public Response allProducts(@QueryParam("type") String type) {

    return Response
        .ok(documentService.getAllProducts_fixme(type))
        .build();
  }

  @GET
  @Path("/coupons")
  public Response countCouponByDocument(@QueryParam("type") String type) {

    return Response
        .ok(documentService.getCouponsByDocument_fixme(type))
        .build();

  }

}
