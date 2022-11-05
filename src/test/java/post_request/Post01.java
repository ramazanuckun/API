package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceOlderTest;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post01 extends JsonplaceholderBaseUrl {
/*
    Given
      1)  https://jsonplaceholder.typicode.com/todos
      2{
    "userId": 155,
    "title": "ramazan rahmi uckun",
    "completed": true,
    "id": 201
}
   When
    I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/
@Test
    public void post01(){

    //Set the url

    spec.pathParam("first","todos");

    //Set the expected data

    JsonPlaceOlderTest obj=new JsonPlaceOlderTest();

    Map<String,Object>expected=obj.expectedDataMethod(155,"ramazan rahmi uckun",true);

    //Set the request data and the response data

    Response response=given().spec(spec).contentType(ContentType.JSON)
            .body(expected).when().post("/{first}");

    response.prettyPrint();



}
}
