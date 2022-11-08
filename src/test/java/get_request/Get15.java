package get_request;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {

   /* {
        "firstname": "James",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
        "checkin": "2022-01-01",
                "checkout": "2023-01-01"
    },
        "additionalneeds": "Breakfast"
    }

    */

    @Test
    public void get15() {

        spec.pathParams("first","booking","second",865);

        //Set the expectedData

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2022-01-01","2023-01-01");

        BookingPojo expectedData=new BookingPojo("James","Brown",111,true,bookingDatesPojo,"Breakfast");

        System.out.println("expectedData = " + expectedData);

        Response response=given().spec(spec).when().get("/{first}/{second}");
response.prettyPrint();

//Do assertion

     BookingPojo actualData=   ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);
        System.out.println("actualData = " + actualData);

assertEquals(200,response.getStatusCode());
assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
assertEquals(expectedData.getFirstname(),actualData.getFirstname());
assertEquals(expectedData.getLastname(),actualData.getLastname());
assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());







    }
}
