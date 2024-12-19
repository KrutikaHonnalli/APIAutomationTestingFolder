package RestAssuredMultiplePayloadExample.MapPayload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadByUsingMap
{
    RequestSpecification Res;
    Response ResMethods;
    ValidatableResponse ValidateResponse;
    @Test
    public void Payloadmethodbyusingmap()
    {
        Map<String,Object> JsonObject = new LinkedHashMap<>();
        JsonObject.put("firstname","Jam");
        JsonObject.put("lastname","Brown");
        JsonObject.put("totalprice",111);
        JsonObject.put("depositpaid","true");

        Map<String,Object> bookingdetails = new LinkedHashMap<>();
        bookingdetails.put("checkin","2013-02-23");
        bookingdetails.put("checkout","2014-10-23");

        JsonObject.put("bookingdates",bookingdetails);
        JsonObject.put("additionalneeds","Breakfast");

       Res = RestAssured
               .given();
                Res.baseUri("https://restful-booker.herokuapp.com");
                Res.basePath("/booking");
                Res.contentType(ContentType.JSON);
                Res.body(JsonObject);
                ResMethods = Res
                        .when()
                        .post();
        ValidateResponse = ResMethods
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
