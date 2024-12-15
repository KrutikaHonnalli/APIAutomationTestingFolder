package RestAssuredPatchMethodsTestCase;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PatchMethodWithoutBDDStyle
{
    RequestSpecification RequestDetails;
    Response MetodDetails;
    ValidatableResponse ValidateResponse;

    @Description("Valid Patch Method")
    @Test
    public void ValidPatchTesCase()
    {
        String tokenValue = "838d32b298b271f";
        String BookId = "222";

        RequestDetails = RestAssured
                        .given();
                            RequestDetails.baseUri("https://restful-booker.herokuapp.com");
                            RequestDetails.basePath("/booking/"+BookId);
                            RequestDetails.contentType(ContentType.JSON);
                            RequestDetails.cookies("token",tokenValue);
                            RequestDetails.body("{\n" +
                                    "    \"firstname\" : \"JamesName\",\n" +
                                    "    \"lastname\" : \"Brown\"\n" +
                                    "}");
        MetodDetails = RequestDetails
                        .when()
                        .patch();
        ValidateResponse = MetodDetails
                            .then()
                            .log()
                            .all()
                            .statusCode(200);
    }
}
