package RestAssuredMultiplePayloadExample.RestFulAPIObject.CreateObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class ResMainClass
{
    RequestSpecification Req;
    Response Res;
    ValidatableResponse Validate;
    @Test
    public void ResMainClassMethod()
    {
        NameClass NameObject = new NameClass();
        NameObject.setName("Apple MacBook Pro 16");

        Data DataObject = new Data();
        DataObject.setYear(2019);
        DataObject.setPrice(2000.00);
        DataObject.setCPUmodel("Intel Core i9");
        DataObject.setHarddisksize("1 TB");
        NameObject.setData(DataObject);
        System.out.println(NameObject);

        Req = RestAssured
                .given().log().all();
              Req.baseUri("https://api.restful-api.dev");
              Req.basePath("/objects");
              Req.contentType(ContentType.JSON);
              Req.body(NameObject);

              Res = Req.when()
                      .log()
                      .all()
                      .post();
              Validate = Res
                      .then()
                      .log()
                      .all()
                      .statusCode(200);
              //Validate by using the AssertJ

        String name = Res.then().extract().body().path("name");
        assertThat(name).isNotEmpty().isNotNull().isEqualTo("Apple MacBook Pro 16");

        int year = Res.then().extract().body().path("data.year");
        assertThat(year).isNotNull().isEqualTo(2019);





    }
}
