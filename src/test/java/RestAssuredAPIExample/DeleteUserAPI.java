package RestAssuredAPIExample;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteUserAPI
{
    RequestSpecification RequestData;
    Response Methods;
    ValidatableResponse ValidateData;

    @Description("Delete the Valid User by passing the User ID")
    @Test
    public void DeleteUserWithValid()
    {
        RequestData = RestAssured
                .given();
            RequestData.baseUri("https://reqres.in");
            RequestData.basePath("/api/users/306");
            RequestData.contentType(ContentType.JSON);
            Methods = RequestData
                    .when()
                    .delete();
            ValidateData = Methods
                    .then()
                    .log()
                    .all()
                    .statusCode(204);
    }
}
