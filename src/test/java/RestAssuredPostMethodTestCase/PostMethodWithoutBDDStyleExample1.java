package RestAssuredPostMethodTestCase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.qameta.allure.Description;
import org.apache.http.entity.mime.content.ContentBody;
import org.testng.annotations.Test;

public class PostMethodWithoutBDDStyleExample1
{
    //For Post Method
    //Payload and Header is Required
    RequestSpecification RequestSpec;
    Response Res;
    ValidatableResponse Validate;

    @Description("Performing Post HTTP method Request with Valid Payload")
    @Test
    public void ValidPostRequest()
    {
        RequestSpec = RestAssured.
                        given().
                         log().
                         all();
                         RequestSpec.baseUri("https://restful-booker.herokuapp.com");
                         RequestSpec.basePath("/booking");
                         RequestSpec.contentType(ContentType.JSON);
                         RequestSpec.body("{\n" +
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
                         Res = RequestSpec.when().log().all()
                                 .post();
        Validate = Res
                  .then()
                .log()
                .all()
                .statusCode(200);


    }

    @Description("Invalid Payload by passing firstname without double quote the status should be 400 Bad Request ")
    @Test
    public void InvalidPostRequest()
    {
        RequestSpec = RestAssured
                .given().log().all();
                RequestSpec.baseUri("");
                RequestSpec.basePath("");
                RequestSpec.contentType(ContentType.JSON);
                RequestSpec.body("{\n" +
                        "    \"firstname\": tttt,\n" +
                        "    \"lastname\": \"Brown\",\n" +
                        "    \"totalprice\": 111,\n" +
                        "    \"depositpaid\": true,\n" +
                        "    \"bookingdates\": {\n" +
                        "        \"checkin\": \"2013-02-23\",\n" +
                        "        \"checkout\": \"2014-10-23\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\": \"Breakfast\"\n" +
                        "}");
                Res = RequestSpec
                        .when()
                        .log()
                        .all()
                        .post();
                Validate = Res
                        .then()
                        .log()
                        .all()
                        .statusCode(200);
    }
}
