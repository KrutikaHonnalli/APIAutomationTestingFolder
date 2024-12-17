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

public class PartialUpdateForUserAPI
{
    RequestSpecification Request;
    Response HttpMethod;
    ValidatableResponse ValidateData;

    @Description("Partial Update with only Job Description")
    @Test
    public void PartialUpdateData()
    {
        Request = RestAssured
                .given();
                Request.baseUri("https://reqres.in");
                Request.basePath("/api/users/306");
                Request.contentType(ContentType.JSON);
                Request.body("{\n" +
                        "   \n" +
                        "    \"job\": \"AutomationTesting\"\n" +
                        "}");
                HttpMethod = Request
                        .when()
                        .patch();
                ValidateData = HttpMethod
                        .then()
                        .log()
                        .all()
                        .statusCode(200);

                //Validating Response by using the Rest Assured
                ValidateData.body("job",Matchers.equalTo("AutomationTesting"));
                // Validating API response with the TestNG

                String UpdatedJob = HttpMethod.then().extract().path("job");
                String PartialUpdatedDate = HttpMethod.then().extract().path("updatedAt");

                Assert.assertEquals(UpdatedJob,"AutomationTesting");
                Assert.assertNotNull(PartialUpdatedDate);

                assertThat(UpdatedJob).isEqualTo("AutomationTesting").isNotEmpty().isNotNull();
    }
}

