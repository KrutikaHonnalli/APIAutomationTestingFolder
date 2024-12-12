package RestAssuredGetMethodTestCase;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class HttpGetMethodBDDStyle
{

    //URL: https://restful-booker.herokuapp.com/booking/1
    //BaseURI: https://restful-booker.herokuapp.com
    //BasePath:/booking/1
   @Description("Validating the test case with Valid BookID")
    @Test
    public void ValidStatusCodeTestCase()
    {
        String BookID = "1";
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/"+BookID)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }

    @Description("Validating TestCase with the Invalid BookID:-1")
    @Test
    public void InValidBookIDTestCase()
    {
        String BookID = "-1";
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+BookID)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Description("Validating TestCase with the Invalid BookID:abc")
    @Test
    public void InValidStringBookIDTestCase()
    {
        String BookID = "abc";
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+BookID)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    @Description("Validate Test Case with Invalid Method")
    @Test
    public void INValidHttpMethod()
    {
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/-1")
                .when()
                    .post()
                    .then()
                .log().all().statusCode(200);

    }

}
