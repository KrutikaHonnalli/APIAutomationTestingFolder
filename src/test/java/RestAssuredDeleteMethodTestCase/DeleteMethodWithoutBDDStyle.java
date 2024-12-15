package RestAssuredDeleteMethodTestCase;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteMethodWithoutBDDStyle
{
    RequestSpecification Request;
    Response Res;
    ValidatableResponse ValidateData;

    @Description("With Valid Delete Method")
    @Test
    public void DeleteRequestMethod()
    {
        String BookID="222";
        String TokenValue = "838d32b298b271f";
        Request = RestAssured
                .given()
                .log().all();
            Request.baseUri("https://restful-booker.herokuapp.com");
            Request.basePath("booking/"+BookID);
            Request.contentType(ContentType.JSON);
            Request.cookies("token",TokenValue);

            Res = Request
                    .when()
                    .delete();
        ValidateData = Res.then()
                .log().all().statusCode(200);

    }
}
