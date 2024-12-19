package RestAssuredMultiplePayloadExample.MapPayload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateUserByusingthePayload
{
    RequestSpecification Res;
    Response ReqMethod;
    ValidatableResponse ValidateData;
@Test
    public void CreateUser()
    {
        Map<String,Object> JsonObject = new LinkedHashMap<>();
        JsonObject.put("name","Sachin");
        JsonObject.put("job", "leader");

        Res = RestAssured
                .given();
            Res.baseUri("https://reqres.in/api");
            Res.basePath("/users");
            Res.contentType(ContentType.JSON);
            Res.body(JsonObject);
            ReqMethod = Res.when()
                    .post();
            ValidateData = ReqMethod
                    .then()
                    .log()
                    .all()
                    .statusCode(201);

            //Validate by using the AssertJ
        String id = ReqMethod.then().extract().body().path("id");
        //System.out.println(id);
        assertThat(id).isNotNull().isNotEmpty();


    }
}
