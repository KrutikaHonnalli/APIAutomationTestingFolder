package BrandAPIQueryParameter;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class UpdateSpecificBrand
{
    RequestSpecification Request;
    Response ResponseMethod;
    ValidatableResponse ValidateData;

   @Description("Update SpecificBrand")
    @Test
    public void UpdateSpecificBrandMethod()
    {
        String BrandId="01jfm3rc8vqd50rkyeq2ehpwq1";
        String BodyPayload="{\n" +
                "  \"name\": \"RestAssuredAPIAutomation\",\n" +
                "  \"slug\": \"RestAssuredAPIAutomationClass\"\n" +
                "}";
        Request = RestAssured
                .given();
                Request.baseUri("https://api.practicesoftwaretesting.com");
                Request.basePath("/brands/"+BrandId);
                Request.contentType(ContentType.JSON);
                Request.accept("application/json");
                Request.body(BodyPayload);
        ResponseMethod = Request
                        .when()
                        .put();
        ValidateData = ResponseMethod
                .then()
                .log()
                .all()
                .statusCode(200);

    }
}
