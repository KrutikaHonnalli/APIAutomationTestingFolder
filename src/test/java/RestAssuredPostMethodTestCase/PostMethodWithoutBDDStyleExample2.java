package RestAssuredPostMethodTestCase;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostMethodWithoutBDDStyleExample2
{
    RequestSpecification Request;
    Response Httpmethod;
    ValidatableResponse ValidateResponse;

    @Description("With Valid Payload for Post Method")
    @Test
    public void ValidUserCreation()
    {
        Request = RestAssured
                     .given()
                     .log()
                     .all();
                Request.baseUri("https://fakerestapi.azurewebsites.net");
                Request.basePath("/api/v1/Users");
                Request.contentType(ContentType.JSON);
                Request.body("{\n" +
                        "  \"id\": 21,\n" +
                        "  \"userName\": \"Abc\",\n" +
                        "  \"password\": \"abc123\"\n" +
                        "}");
        Httpmethod = Request
                .log().all()
                .post();
        ValidateResponse = Httpmethod
                .then()
                .log()
                .all()
                .statusCode(200);
    }

   /* @Description("With Invalid Payload by passing id as string format")
    @Test
    public void InvalidUserCreation()
    {
        Request = RestAssured
                    .given();
                  Request.baseUri("https://fakerestapi.azurewebsites.net");
                  Request.basePath("/api/v1/Users");
                  Request.contentType(ContentType.JSON);
                  Request.body("{\n" +
                          "  \"id\": \"rrr\",\n" +
                          "  \"userName\": \"string\",\n" +
                          "  \"password\": \"string\"\n" +
                          "}");
                  Httpmethod = Request
                          .when()
                          .log()
                          .all()
                          .post();
                  ValidateResponse = Httpmethod
                          .then()
                          .log()
                          .all()
                          .statusCode(200);
    }*/

}
