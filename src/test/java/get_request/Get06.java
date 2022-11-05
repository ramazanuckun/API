package get_request;

import base_urls.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Get06 extends RestfulBaseUrl {


        /*
        Given
            https://restful-booker.herokuapp.com/booking/2325
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
    {
    "firstname": "Carlos",
    "lastname": "Combs",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
},
    "additionalneeds": "None"
}
     */

    @Test
    public void get01(){

        //1-set the url
        spec.pathParams("first","booking","second",28);

        //2-set the expected data
        //3-set the request and the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4-Do assertioon

        //1.yol
        response.then().assertThat()
                .statusCode(200).contentType(ContentType.JSON)
                .body("firstname",equalTo("Carlos"),"lastname",equalTo("Combs")
                        ,"totalprice",equalTo(111),"depositpaid",equalTo(true)
                        ,"bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01")
                        ,"additionalneeds",equalTo("Breakfast"));

        // .body("firstname","Carlos","lastname","Combs","totalprice",111,
                  //      "depositpaid",true,"bookingdates.checkin","2018-01-01","bookingdates.checkout","2019-01-01",)


        //2.yol

        JsonPath json=response.jsonPath();

        assertEquals("Carlos",json.getString("firstname"));
        assertEquals("Combs",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
     assertEquals(true,json.getBoolean("depositpaid"));
     assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
     assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
     assertEquals("Breakfast",json.getString("additionalneeds"));
//3.yol Soft Assertion
        //1.adim
        SoftAssert softAssert=new SoftAssert();
        //2.adim
        softAssert.assertEquals(json.getString("firstname"),"Carlos","First name hatali");
        softAssert.assertEquals(json.getString("lastname"),"Combs","Lastname hatali");
        softAssert.assertEquals(json.getInt("totalprice"),111,"totalPriceHatali");
        softAssert.assertEquals(json.getBoolean("depositpaid"),true,"Depositpaid Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01","Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01","hatali");
        softAssert.assertEquals(json.getString("additionalneeds"),"Breakfast","hatali");
softAssert.assertAll();

    }
}
