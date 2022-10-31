package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 extends RestfulBaseUrl {

       /*
    * Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
            */
    @Test
    public void get02(){
//1-set the url
        spec.pathParams("first","booking","second",1);
        //2-set the expevted data
        //3-set the type code

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //4-Do assertin

        assertEquals(404,response.getStatusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.getStatusLine());
    assertTrue(response.asString().contains("Not Found"));
    assertFalse(response.asString().contains("TechProEd"));
assertEquals("Cowboy",response.getHeader("server"));


    }
}
