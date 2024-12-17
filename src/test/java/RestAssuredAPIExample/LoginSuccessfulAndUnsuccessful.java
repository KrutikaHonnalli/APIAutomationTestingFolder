package RestAssuredAPIExample;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import  org.hamcrest.Matchers;

public class LoginSuccessfulAndUnsuccessful
{
    RequestSpecification RequestBody;
    Response ResponseBody;
    ValidatableResponse ValidateResponseData;

    @Description("Login with valid email and Password")
    @Test
    public void LoginWithValidDetails()
    {
        RequestBody =  RestAssured
                            .given();
                        RequestBody.baseUri("https://reqres.in");
                        RequestBody.basePath("/api/login");
                        RequestBody.contentType(ContentType.JSON);
                        RequestBody.body("{\n" +
                                "    \"email\": \"eve.holt@reqres.in\",\n" +
                                "    \"password\": \"cityslicka\"\n" +
                                "}");
                        ResponseBody = RequestBody
                                .when()
                                .post();
                        ValidateResponseData = ResponseBody
                                .then()
                                .log()
                                .all()
                                .statusCode(200);

                        //Assertion with Rest Assured


    }
    @Description("Login with only EmailId")
    @Test
    public void LoginWithOnlyEmail()
    {
        RequestBody = RestAssured
                        .given();
                        RequestBody.baseUri("https://reqres.in");
                        RequestBody.basePath("/api/login");
                        RequestBody.contentType(ContentType.JSON);
                        RequestBody.body("{\n" +
                                "    \"email\": \"peter@klaven\"\n" +
                                "}");
                        ResponseBody =RequestBody
                                .when()
                                .post();
                        ValidateResponseData = ResponseBody
                                .then()
                                .log()
                                .all()
                                .statusCode(400);
    }
}
