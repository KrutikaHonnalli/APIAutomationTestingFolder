package RestAssuredAPIExample;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateUserAPI
{
    RequestSpecification RequestBody;
    Response RequestMethod;
    ValidatableResponse ValidateResponseData;

    @Description("Create with Valide User Details")
    @Test
    public void CreateUserWithValidDetails()
    {
        RequestBody = RestAssured
                        .given();
                    RequestBody.baseUri("https://reqres.in");
                    RequestBody.basePath("/api/users");
                    RequestBody.contentType(ContentType.JSON);
                    RequestBody.body("{\n" +
                            "    \"name\": \"Sachin\",\n" +
                            "    \"job\": \"leader\"\n" +
                            "}");
                    RequestMethod = RequestBody
                            .when()
                            .post();
                    ValidateResponseData = RequestMethod
                            .then()
                            .log()
                            .all()
                            .statusCode(201);
    }
}
