package RestAssuredMultiplePayloadExample.StringPayload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

@Test
public class StringPayload
{

    RequestSpecification Res;
    Response ReqMethod;
    ValidatableResponse Validate;
    String Payload="{\n" +
            "    \"firstname\": \"Jam\",\n" +
            "    \"lastname\": \"Brown\",\n" +
            "    \"totalprice\": 111,\n" +
            "    \"depositpaid\": true,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2013-02-23\",\n" +
            "        \"checkout\": \"2014-10-23\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";

    public void StringPayloadMethod()
    {
        Res = RestAssured
                .given();
              Res.baseUri("https://restful-booker.herokuapp.com");
              Res.basePath("/booking");
              Res.contentType(ContentType.JSON);
              Res.body(Payload);
              ReqMethod = Res
                      .when()
                      .post();
              Validate = ReqMethod
                      .then()
                      .log()
                      .all()
                      .statusCode(200);

              //Validating by using RestAssured
        Validate.body("booking.firstname",Matchers.equalTo("Jam"));
        Validate.body("booking.lastname",Matchers.equalTo("Brown"));

            //Validating by using the TestNG
        String FirstName = ReqMethod.then().extract().body().path("booking.firstname");
        Assert.assertEquals(FirstName,"Jam");

            //Validating by using AssertJ
        assertThat(FirstName).isNotNull().isNotEmpty().isEqualTo("Jam");


    }
}
