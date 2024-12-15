package RestAssuredPutMethodTestCase;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PutMethodWithoutBDDStyle
{
    RequestSpecification RequestBody;
    Response Method;
    ValidatableResponse Validate;

    @Description("Update with the Valid BookId")
    @Test
    public void validUpdateTestCase()
    {
        String Bookid = "222";
        String token1 = "838d32b298b271f";
        RequestBody = RestAssured
                .given()
                .log()
                .all();
                RequestBody.baseUri("https://restful-booker.herokuapp.com");
                RequestBody.basePath("booking/"+Bookid);
                RequestBody.contentType(ContentType.JSON);
                RequestBody.cookies("token",token1);
                RequestBody.body("{\n" +
                        "    \"firstname\" : \"Sachin\",\n" +
                        "    \"lastname\" : \"Kudte\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}");
                Method = RequestBody
                        .log()
                        .all()
                        .put();
                Validate = Method
                        .then()
                        .log()
                        .all()
                        .statusCode(200);

    }
}
