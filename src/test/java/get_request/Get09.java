package get_request;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends RestfulBaseUrl {

         /*
        Given
            https://restful-booker.herokuapp.com/booking/191
        When
            I send GET Request to the url
        Then
            Response body should be like that;
          {
    "firstname": "Javier",
    "lastname": "Dominguez",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void get09() {
//
      //  Set The Url

        spec.pathParams("first","booking","second",191);

        //Set the exxpected data

        Map<String,String>bookingDataMap=new HashMap<>();
        bookingDataMap.put("checkin","2018-01-01");
        bookingDataMap.put("checkout","2019-01-01");



//Set The expected Data
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("firstname","Javier");
        expectedData.put("lastname","Dominguez");
        expectedData.put("totalprice",111);
       expectedData.put("additionalneeds","Breakfast");
       expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingDataMap);
        System.out.println(expectedData);

        //Set the reuqush data and the response data

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion

        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
//ikilileri sitring object object seklinde oldugundan booking data value kismini casting ile map aptik
        assertEquals(bookingDataMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));

        assertEquals(bookingDataMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));

    }
}
