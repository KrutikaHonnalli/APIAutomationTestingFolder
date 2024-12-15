package RestAssuredGetMethodTestCase;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class HttpGetMethodWithoutBDDStyle {
    RequestSpecification RequestDetails;
    Response Res;
    ValidatableResponse ValidateResponse;

    @Description("With Valid Booking ID")
    @Test
  public void ValidBookingIDAPI()
  {
      String BookID="222";
      RequestDetails =
              RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/"+BookID);
      Res = RequestDetails
                .when()
                .log()
                .all()
                .get();
      ValidateResponse = Res
              .then()
              .log()
              .all()
              .statusCode(200);

  }
@Description("With InValid BookId:-1")
  @Test
    public void WithInvalidBookingID()
  {
      String BookId="-1";

      RequestDetails =
              RestAssured
                      .given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("\"/booking/"+BookId);
      Res = RequestDetails
              .when()
                .log()
                 .all()
                 .get();
      ValidateResponse = Res
                            .then()
                                 .log()
                                  .all()
                                   .statusCode(200);
  }


}