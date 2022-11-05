package get_request;

import base_urls.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get11 extends DummyBaseUrl {


    /*
    http://dummy.restapiexample.com/api/v1/employees  url’ine
    GET request’i yolladigimda gelen response’un
    status kodunun 200 ve content type’inin “application/json”
    ve employees sayisinin 24
    ve employee’lerden birinin “Ashton Cox”
    ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.



 */

    @Test
    public void get11() {
        //Set the url

        spec.pathParam("first","employees");

        //Set the expected Data

        //Set the requrest data andthe response data


        Response response=given().spec(spec).when().get("/{first}");

        response.prettyPrint();


//Do assertion

        response.then().statusCode(200).contentType(ContentType.JSON);
    response.then()    .body("data.employees",hasSize(24),"data.employee_name",
            hasItem("Ashton Cox"),"data.employee_age",hasItems(21,61,23));
;





    }
}
