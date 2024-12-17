package RestAssuredAPIExample;

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


public class UpdateUserAPI
{
    RequestSpecification RequestBody;
    Response RequestMethod;
    ValidatableResponse ValidateResponseData;

    @Description("Update user with valid Data")
    @Test
    public void UpdateWithValid()
    {
        RequestBody = RestAssured
                        .given();
                     RequestBody
                             .baseUri("https://reqres.in/api");
                     RequestBody
                             .basePath("/users/306");
                     RequestBody
                             .contentType(ContentType.JSON);
                     RequestBody
                             .body("{\n" +
                                     "    \"name\": \"morpheus\",\n" +
                                     "    \"job\": \"zion resident\"\n" +
                                     "}");
        RequestMethod = RequestBody
                .when()
                .put();
        ValidateResponseData = RequestMethod
                .then()
                .log()
                .all()
                .statusCode(200);
        //Assertion with Rest Assured
        ValidateResponseData.body("name", Matchers.equalTo("morpheus"));
        ValidateResponseData.body("job",Matchers.equalTo("zion resident"));

        //TestNG Assertion
        String UpdatedName = RequestMethod.then().extract().path("name");
        String UpdatedJob = RequestMethod.then().extract().path("job");
        String UpdatedDate = RequestMethod.then().extract().path("updatedAt");

        Assert.assertEquals(UpdatedName,"morpheus");
        Assert.assertEquals(UpdatedJob,"zion resident");
        Assert.assertNotNull(UpdatedDate);

        //Validation by using AssertJ
        assertThat(UpdatedName).isNotEmpty().isNotNull().isEqualTo("morpheus");
        assertThat(UpdatedJob).isNotNull().isNotEmpty().isEqualTo("zion resident");


    }
}
