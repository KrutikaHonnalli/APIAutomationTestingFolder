package RestAssuredAPIExample;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RegisterSuccessfulAndUnsuccessful
{
    RequestSpecification RequestDetails;
    Response Method;
    ValidatableResponse ValidateData;

    @Description("With Valid Delete Method")
    @Test
    public void RegisterWithValidData()
    {
        RequestDetails = RestAssured
                            .given();
                        RequestDetails.baseUri("https://reqres.in");
                        RequestDetails.basePath("/api/register");
                        RequestDetails.contentType(ContentType.JSON);
                        RequestDetails.body("{\n" +
                                "    \"email\": \"eve.holt@reqres.in\",\n" +
                                "    \"password\": \"pistol\"\n" +
                                "}");
                        Method = RequestDetails
                                .when()
                                .post();
                        ValidateData = Method
                                .then()
                                .log()
                                .all()
                                .statusCode(200);

    }

    @Description("Register Only With Password")
    @Test
    public void RegisterWithOnlyPassword()
    {
        RequestDetails = RestAssured
                        .given();
                        RequestDetails.baseUri("https://reqres.in" );
                        RequestDetails.basePath("/api/register");
                        RequestDetails.contentType(ContentType.JSON);
                        RequestDetails.body("{\n" +
                                "    \"email\": \"sydney@fife\"\n" +
                                "}");
                        Method = RequestDetails
                                .when()
                                .post();
                        ValidateData = Method
                                .then()
                                .log()
                                .all()
                                .statusCode(400);
    }
    /*public static void main(String[] args) {
        RestAssured.
                given()
                .baseUri("https://reqres.in")
                .basePath("/api/register")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .when()
                .post()
                .then()
                .log()
                .all()
                .statusCode(200);

    }*/
}
