package BrandAPIQueryParameter;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class RetrieveSpecificBrand
{
    RequestSpecification Request;
    Response ResponseBody;
    ValidatableResponse ValidateData;
    String BrancdID="01jfm3rc8vqd50rkyeq2ehpwq1";

    @Description("Retrieve specific brand")
    @Test
    public void Retrievespecificbrand()
    {
        Request = RestAssured
                .given();
                Request.baseUri("https://api.practicesoftwaretesting.com");
                Request.basePath("/brands/"+BrancdID);
                Request.accept("application/json");
                Request.contentType(ContentType.JSON);
                ResponseBody = Request
                        .when()
                        .get();
                ValidateData = ResponseBody.then()
                        .log()
                        .all()
                        .statusCode(200);

                String ExtracBrandId = ResponseBody.then().extract().body().path("id");
                assertThat(ExtracBrandId).isEqualTo(BrancdID);
    }
}
