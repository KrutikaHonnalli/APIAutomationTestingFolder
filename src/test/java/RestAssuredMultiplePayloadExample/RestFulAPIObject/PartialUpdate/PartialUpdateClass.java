package RestAssuredMultiplePayloadExample.RestFulAPIObject.PartialUpdate;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class PartialUpdateClass
{
    RequestSpecification Req;
    Response Res;
    ValidatableResponse Validate;


    @Description("Parial Update with Valid Data")
    @Test
    public void PartialUpdateMethod()
    {
        String id="ff808181932badb60193dda4dce27e9e";

        NameUpdateClass NameObject2 = new NameUpdateClass();
        NameObject2.setName("Apple MacBook Pro 16 (Updated Name)");

        PartialDataClas PartialObject1 = new PartialDataClas();
        PartialObject1.setYear(2019);
        PartialObject1.setPrice(2049.99);
        PartialObject1.setCPUmodel("Intel Core i9");
        PartialObject1.setHarddisksize("1 TB");
        PartialObject1.setColor("Red");
        NameObject2.setData(PartialObject1);


        Req = RestAssured
                .given();
                Req.baseUri("https://api.restful-api.dev");
                Req.basePath("objects/"+id);
                Req.contentType(ContentType.JSON);
                Req.body(NameObject2);

                Res = Req
                        .when()
                        .log()
                        .all()
                        .put();
        Validate = Res.then()
                .log()
                .all()
                .statusCode(200);

                //Validate by using the AssertJ
        String PartialUpdate = Res.then().extract().body().path("name");
        String ChangedColor = Res.then().extract().body().path("data.color");

        assertThat(PartialUpdate).isNotEmpty().isNotNull().isEqualTo("Apple MacBook Pro 16 (Updated Name)");
        assertThat(ChangedColor).isEqualTo("Red");





    }
}
