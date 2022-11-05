package get_request;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12bPojo_class extends RestfulBaseUrl {

    /*
    Given
         https://restful-booker.herokuapp.com/booking/15
     When
    I send GET Request to the URL
   Then
    Status code is 200
And
    Response body is like:
                        {
    "firstname": "Fabio",
    "lastname": "Colque",
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
    public void pojos() {
//Set the url

        spec.pathParams("first","booking","second",15);

        //Set the expected data

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");

   //     bookingDatesPojo.setCheckin("2018-01-01");
      //  bookingDatesPojo.setCheckout("2019-01-01");

        System.out.println("bookingDatesPojo = " + bookingDatesPojo);

        BookingPojo bookingPojo=new BookingPojo("Fabio","Colque","Breakfast",111,true,bookingDatesPojo);
        System.out.println("bookingPojo = " + bookingPojo);

       //Send the request and the response data

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
BookingPojo actualPojo=response.as(BookingPojo.class);
        System.out.println("actualPojo = " + actualPojo);
        assertEquals(bookingPojo.getFirstname(),actualPojo.getFirstname());
        assertEquals(bookingPojo.getLastname(),actualPojo.getLastname());
        assertEquals(bookingPojo.getTotalprice(),actualPojo.getTotalprice());
        assertEquals(bookingPojo.getDepositpaid(),actualPojo.getDepositpaid());
        assertEquals(bookingPojo.getAdditionalneeds(),actualPojo.getAdditionalneeds());

        //1.yol

        assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBookingdates().getCheckout());

        assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBookingdates().getCheckin());


//2.yol

        assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBookingdates().getCheckin());
        assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBookingdates().getCheckout());

    }
}
