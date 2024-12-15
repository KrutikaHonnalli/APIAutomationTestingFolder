package RestAssuredAPIExample;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PartialUpdateUserAPI
{
    RequestSpecification Request;
    Response HttpMethod;
    ValidatableResponse ValidateData;

    @Description("Partial Update with only Job Description")
    @Test
    public void PartialUpdateData()
    {
        Request = RestAssured
                .given();
                Request.baseUri("https://reqres.in");
                Request.basePath("/api/users/306");
                Request.contentType(ContentType.JSON);
                Request.body("{\n" +
                        "   \n" +
                        "    \"job\": \"AutomationTesting\"\n" +
                        "}");
                HttpMethod = Request
                        .when()
                        .patch();
                ValidateData = HttpMethod
                        .then()
                        .log()
                        .all()
                        .statusCode(200);

    }
}

