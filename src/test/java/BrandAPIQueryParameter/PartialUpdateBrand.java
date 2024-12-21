package BrandAPIQueryParameter;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PartialUpdateBrand
{
    RequestSpecification Request;
    Response RequestBody;
    ValidatableResponse ValidateData;

    @Description("Partial Update Brand")
    @Test
    public void PartialUpdateBrandMethod()
    {
        String BrandID="01jfm3rc8vqd50rkyeq2ehpwq1";
        String BodyPaload ="{\n" +
                "  \n" +
                "  \"slug\": \"RestAPIAutomationTestingClassDemo\"\n" +
                "}";

        Request = RestAssured
                .given();
                Request.baseUri("https://api.practicesoftwaretesting.com");
                Request.basePath("/brands/"+BrandID);
                Request.accept("");
                Request.contentType(ContentType.JSON);
                Request.body(BodyPaload);
                RequestBody = Request
                        .when()
                        .patch();
                ValidateData = RequestBody
                        .then()
                        .log()
                        .all()
                        .statusCode(200);

                //Extract the Updated Value


    }
}
