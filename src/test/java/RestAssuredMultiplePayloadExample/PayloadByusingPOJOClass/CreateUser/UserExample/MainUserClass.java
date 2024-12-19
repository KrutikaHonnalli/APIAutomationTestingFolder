package RestAssuredMultiplePayloadExample.PayloadByusingPOJOClass.CreateUser.UserExample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class MainUserClass {
    RequestSpecification Req;
    Response Res;
    ValidatableResponse Validate;
    @Test
    public void CreateUserMethod()
    {
        UserDetails UserObject = new UserDetails();
        UserObject.setName("Krutika");
        UserObject.setJob("Automation Testing");

        Req = RestAssured
                .given();
                Req.baseUri("https://reqres.in/api");
                Req.basePath("/users");
                Req.contentType(ContentType.JSON);
                Req.body(UserObject);

                Res = Req
                        .when()
                        .post();
                Validate = Res
                        .then()
                        .log()
                        .all()
                        .statusCode(201);


    }
}
