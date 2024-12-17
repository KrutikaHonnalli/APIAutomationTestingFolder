package RestAssuredAPIExample;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import static org.assertj.core.api.Assertions.*;

public class CreateUserAPI
{
    RequestSpecification RequestBody;
    Response RequestMethod;
    ValidatableResponse ValidateResponseData;

    @Description("Create with Valide User Details")
    @Test
    public void CreateUserWithValidDetails()
    {
        RequestBody = RestAssured
                        .given();
                    RequestBody.baseUri("https://reqres.in");
                    RequestBody.basePath("/api/users");
                    RequestBody.contentType(ContentType.JSON);
                    RequestBody.body("{\n" +
                            "    \"name\": \"Sachin\",\n" +
                            "    \"job\": \"leader\"\n" +
                            "}");
                    RequestMethod = RequestBody
                            .when()
                            .post();
                    ValidateResponseData = RequestMethod
                            .then()
                            .log()
                            .all()
                            .statusCode(201);
                    //Validating Response by using the Rest Assured
                    ValidateResponseData.body("name",Matchers.equalTo("Sachin"));
                    ValidateResponseData.body("job",Matchers.equalTo("leader"));

                    //Validating the Response by using the TestNG
                    //First Extract the response value
                    //Validate the response
                    Object UserId = RequestMethod.then().extract().path("id");
                    String Name = RequestMethod.then().extract().path("name");
                    String Job = RequestMethod.then().extract().path("job");
                    String CreatedDate = RequestMethod.then().extract().path("createdAt");

                    //Validating the Response by using the TestNG
                    Assert.assertNotNull(UserId);
                     Assert.assertEquals(Name,"Sachin");
                     Assert.assertEquals(Job,"leader");
                     Assert.assertNotNull(CreatedDate);

                     //Validating the response by using the AssertJ
        assertThat(Name).isEqualTo("Sachin").isNotEmpty().isNotNull();
        assertThat(Job).isEqualTo("leader").isNotNull().isNotEmpty();

    }
}
