package AssertionInTestCase;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers ;
import org.testng.annotations.Test;


@Test
public class Assertion_WithRestAssured
{
    RequestSpecification Res;
    Response Respo;
    ValidatableResponse ValidateData;

    public void PostMethod()
    {
        Res = RestAssured.
                given().
                log().
                all();
        Res.baseUri("https://restful-booker.herokuapp.com");
        Res.basePath("/booking");
        Res.contentType(ContentType.JSON);
        Res.body("{\n" +
                "    \"firstname\": \"Kru\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2013-02-23\",\n" +
                "        \"checkout\": \"2014-10-23\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}");
        Respo = Res.when().log().all()
                .post();
        ValidateData = Respo
                .then()
                .log()
                .all()
                .statusCode(200);

        //Assertion With RestAssured
        ValidateData.body("bookingid",Matchers.notNullValue());
       // ValidateData.body("booking.firstname",Matchers.nullValue());
        ValidateData.body("booking.firstname",Matchers.equalTo("Kru"));
        //ValidateData.body("booking.lastname",Matchers.nullValue());
        ValidateData.body("booking.lastname",Matchers.equalTo("Brown"));
        ValidateData.body("booking.bookingdates.checkin",Matchers.equalTo("2013-02-23"));






    }
}
