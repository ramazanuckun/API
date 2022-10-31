package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get05 extends RestfulBaseUrl {
        /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Alex" and lastname is "Combs"
     */
@Test
    public void get01(){
//https://restful-booker.herokuapp.com/booking?firstname=Alex&lastname=Combs
    //1-set the url
    spec.pathParam("first","booking")
            .queryParams("firstname","Dane","lastname","Colque");
    //2-expected data
    //3-request data and the response data

    Response response=given().spec(spec).when().get("/{first}");
    response.prettyPrint();


    //4-Do assertion

assertEquals(200,response.getStatusCode());
assertTrue(response.asString().contains("bookingid"));

}

}
