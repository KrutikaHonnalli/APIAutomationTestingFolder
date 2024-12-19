package RestAssuredMultiplePayloadExample.MapPayload;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpdateUserByusingthePayloadUsingMap
{
    RequestSpecification ReqBody;
    Response ReqMethod;
    ValidatableResponse ValidateData;

    @Description("Update the User by using the May Paylad")
    @Test
    public void UpdateUser()
    {
        String id= "648";
        Map<String,Object> JsonBody = new LinkedHashMap<>();
        JsonBody.put("name","morpheus");
        JsonBody.put("job","zion resident");

        ReqBody = RestAssured
                .given();
                ReqBody.baseUri("https://reqres.in/api");
                ReqBody.basePath("users/"+id);
                ReqBody.contentType(ContentType.JSON);
                ReqBody.body(JsonBody);
                ReqMethod = ReqBody
                        .when()
                        .put();
                ValidateData = ReqMethod
                        .then()
                        .log()
                        .all()
                        .statusCode(200);

                //Validate by using RestAssured
        ValidateData.body("name", Matchers.equalTo("morpheus"));

            //Validate by using the TestNG
        String jobType = ReqMethod.then().extract().body().path("job");
        Assert.assertEquals(jobType,"zion resident");

        //Validate by using the AssertJ
        String date = ReqMethod.then().extract().body().path("updatedAt");
        assertThat(date).isNotEmpty();

    }
}
