package BrandAPIQueryParameter;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class RetriveAllBrand
{
    //Base Uri:https://api.practicesoftwaretesting.com
    //Base Path:/brands
    //Method: get
    RequestSpecification Request;
    Response RequestMethod;
    ValidatableResponse ValidateData;
    @Description("Retrieve all brands")
    @Test
    public void RetriveAllBrancdMethod()
    {
        /*RestAssured.given()
                .baseUri("https://api.practicesoftwaretesting.com")
                .basePath("/brands")
                .when()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);*/

        //By using some Classes
        Request = RestAssured
                    .given();
                  Request.baseUri("https://api.practicesoftwaretesting.com");
                  Request.basePath("/brands");
                  //Request.accept("application/json");
        RequestMethod = Request
                        .when().log().all().get();
        ValidateData = RequestMethod
                .then().log().all();
                ValidateData.statusCode(200);

                //Validate the AssertJ
        List<Object> names = RequestMethod.then().extract().body().jsonPath().getList("name");

       assertThat(names).contains("MightyCraft Hardware");



    }
}
