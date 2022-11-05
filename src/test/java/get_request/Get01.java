package get_request;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get01 extends RestfulBaseUrl {

        /*
Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */

@Test
    public void get01(){

    //1-set the url

    spec.pathParams("first","booking","second",101);

    //2-set the exppected data
    //3-type  code ro send request
    Response response=given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    //Do assertion
    assertEquals(200,response.getStatusCode());
    assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
 //   assertEquals("application/json",response.getContentType());


}
}
