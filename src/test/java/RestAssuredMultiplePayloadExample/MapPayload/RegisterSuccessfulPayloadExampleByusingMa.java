package RestAssuredMultiplePayloadExample.MapPayload;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class RegisterSuccessfulPayloadExampleByusingMa
{
    RequestSpecification Res;
    Response ReqMethod;
    ValidatableResponse ValidateResponse;

    @Description("Payload passing by using Map")
    @Test
    public void RegisterSuccessfully()
    {
        Map<String,Object> JsonObject = new LinkedHashMap<>();
        JsonObject.put("email","eve.holt@reqres.in");
        JsonObject.put("password","pistol");

       //System.out.println(JsonObject);

        Res = RestAssured
                .given();
              Res.baseUri("https://reqres.in/api");
              Res.basePath("/register");
              Res.contentType(ContentType.JSON);
              Res.body(JsonObject);
              ReqMethod = Res
                      .when()
                      .post();
              ValidateResponse = ReqMethod
                      .then()
                      .log()
                      .all()
                      .statusCode(200);

              //Validate by using the AssertJ
        Object id = ReqMethod.then().extract().body().path("id");
        assertThat(id).isNotNull();

        String token = ReqMethod.then().extract().body().path("token");
        assertThat(token).isNotEmpty().isNotNull();
    }
}
