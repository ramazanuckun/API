package get_request;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get04b extends RestfulBaseUrl {

      /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */

    @Test
    public void get04() {
        //Set the url

        spec.pathParam("first","booking").queryParams("firstname","Sally","lastname","Brown");

        //Set the expected Data

        //Set the request Data and the response data
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
//Do assertion

        assertEquals(200,response.statusCode());
       assertTrue(response.asString().contains("bookingid"));

    }
}
