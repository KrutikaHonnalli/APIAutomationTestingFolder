package RestAssuredMultiplePayloadExample.RestFulAPIObject.UpdateObject;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class UpdateMainClass
{
    RequestSpecification Req;
    Response Res;
    ValidatableResponse Validate;


  @Description("Updating the Object with valid Data")
  @Test
    public void ExecuteMainClass()
    {
        String ObjectId= "ff808181932badb60193dda4dce27e9e";
        UpdateNameClass NameObject1 = new UpdateNameClass();
        NameObject1.setName("Apple MacBook Pro 16");

        UpdateDataClas DataObject1 = new UpdateDataClas();
        DataObject1.setYear(2019);
        DataObject1.setPrice(2049.99);
        DataObject1.setCPUmodel("Intel Core i9");
        DataObject1.setHarddisksize("1 TB");
        DataObject1.setColor("silver");
        NameObject1.setData(DataObject1);

        Req = RestAssured
                .given();
               Req.baseUri("https://api.restful-api.dev");
               Req.basePath("objects/"+ObjectId);
               Req.contentType(ContentType.JSON);
               Req.body(NameObject1);

               Res = Req
                       .when()
                       .log()
                       .all()
                       .put();

               Validate = Res
                       .then()
                       .log()
                       .all();

               //Validate by using the assertJ
        String Color = Res.then().extract().body().path("data.color");
        assertThat(Color).isNotNull().isNotEmpty().isEqualTo("silver");


    }
}