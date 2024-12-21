package BrandAPIQueryParameter;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class StoreNewBrand
{
    RequestSpecification Request;
    Response ResponseMethod;
    ValidatableResponse ValidateData;
    @Description("Store new brand")
    @Test
    public void StoreNewBrandMethod()
    {
        String BodyPayload = "{\n" +
                "  \"name\": \"RestAssuredAPI\",\n" +
                "  \"slug\": \"RestAssuredAPIClass\"\n" +
                "}";
        Request = RestAssured
                .given();
                Request.baseUri("https://api.practicesoftwaretesting.com");
                Request.basePath("/brands");
                Request.accept("application/json");
                Request.contentType(ContentType.JSON);
                Request.body(BodyPayload);

                ResponseMethod = Request
                        .when().post();
                ValidateData = ResponseMethod
                        .then()
                        .log()
                        .all()
                        .statusCode(201);

                //Extract the Value from the Response
        String name = ResponseMethod.then().extract().body().path("name");
        String slugname = ResponseMethod.then().extract().body().path("slug");
        String BrandId = ResponseMethod.then().extract().body().path("id");
        /*System.out.println(name);
        System.out.println(slugname);
        System.out.println(BrandId);*/

        //By using AssertJ
        assertThat(BrandId).isNotNull().isNotEmpty();
        assertThat(name).isNotEmpty().isNotEmpty().isEqualTo("RestAssuredAPI");
        assertThat(slugname).isNotEmpty().isNotNull().isEqualTo("RestAssuredAPIClass");


    }
}
