package BrandAPIQueryParameter;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SearchWithBrandValueByUsingQueryParameter
{
    RequestSpecification Request;
    Response ResponseBody;
    ValidatableResponse VaidateData;

    @Description("Serach with Slug name")
    @Test
    public void SearchWithValueMethod()
    {
        String QueryKey ="q";
        String QueryValue ="Automation";
        Request = RestAssured
                .given()
                        .log()
                                .all();
                Request.baseUri("https://api.practicesoftwaretesting.com");
                Request.basePath("/brands/search");
                Request.queryParam(QueryKey,QueryValue);
                Request.contentType(ContentType.JSON);
                Request.accept("application/json");

                ResponseBody = Request
                        .when()
                        .get();
                VaidateData = ResponseBody
                        .then()
                        .log()
                        .all()
                        .statusCode(200);
                List<Object> id = ResponseBody.then().extract().body().path("id");
                assertThat(id).isNotEmpty().isNotNull();

    }
}
