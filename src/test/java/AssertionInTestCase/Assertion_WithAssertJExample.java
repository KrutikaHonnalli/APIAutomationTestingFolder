package AssertionInTestCase;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Assertion_WithAssertJExample
{

    RequestSpecification Res;
    Response Respo;
    ValidatableResponse ValidateData;
    @Description("Validating response by using TestNG Assertion")
    @Test
    public void PostMethod()
    {
        Res = RestAssured.
                given().
                log().
                all();
        Res.baseUri("https://restful-booker.herokuapp.com");
        Res.basePath("/booking");
        Res.contentType(ContentType.JSON);
        Res.body("{\n" +
                "    \"firstname\": \"Kru\",\n" +
                "    \"lastname\": \"Brown\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2013-02-23\",\n" +
                "        \"checkout\": \"2014-10-23\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}");
        Respo = Res.when().log().all()
                .post();
        ValidateData = Respo
                .then()
                .log()
                .all()
                .statusCode(200);

        //Validation by using the TestNG Assertion
        //Hard and Soft Assertion
        //Once the assertion fails rest of code is not executed in the hard Assertion
        //If assertion also fails remaining code is executing in the soft assertion by writing the softassert.assertAll();
        //If we using TestNG assertion first we have to extract the response value

        Object bookingId = Respo.then().extract().path("bookingid");
        String FName = Respo.then().extract().path("booking.firstname");
        String LName = Respo.then().extract().path("booking.lastname");

        //Validation by using the TestNG
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(FName,"Kru");
        Assert.assertEquals(LName,"Brown");

        //Validation by using the AssertJ

        assertThat(FName).isNotNull().isNotEmpty().isEqualTo("Kru");
        assertThat((LName)).isNotNull().isNotEmpty().isEqualTo("Brown");

    }
}
