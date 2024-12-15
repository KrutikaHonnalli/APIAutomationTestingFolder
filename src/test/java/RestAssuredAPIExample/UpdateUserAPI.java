package RestAssuredAPIExample;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

public class UpdateUserAPI
{
    RequestSpecification RequestBody;
    Response RequestMethod;
    ValidatableResponse ValidateResponseData;

    @Description("Update user with valid Data")
    @Test
    public void UpdateWithValid()
    {
        RequestBody = RestAssured
                        .given();
                     RequestBody
                             .baseUri("https://reqres.in/api");
                     RequestBody
                             .basePath("/users/306");
                     RequestBody
                             .contentType(ContentType.JSON);
                     RequestBody
                             .body("{\n" +
                                     "    \"name\": \"morpheus\",\n" +
                                     "    \"job\": \"zion resident\"\n" +
                                     "}");
        RequestMethod = RequestBody
                .when()
                .put();
        ValidateResponseData = RequestMethod
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
