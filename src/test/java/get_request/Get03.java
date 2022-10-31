package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Get03 extends JsonplaceholderBaseUrl {

     /*
      Given            base Url                  1    2
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
And
    "completed" is false
And
    "userId" is 2
   */
@Test
    public void get01(){

    //1-set the url

    spec.pathParams("first","todos","second",21);

    //2-set the expected data

    //3-set the request and the response data

    Response response=given().spec(spec).when().get("/{first}/{second}");
response.prettyPrint();

//4-do assertion

   // assertEquals(200,response.getStatusCode());

    //assertEquals("application/json",response.getContentType());
/*
response.then().assertThat().statusCode(200)
        .contentType(ContentType.JSON)
        .body("title",equalTo("suscipit repellat esse quibusdam voluptatem incidunt")
        ,"completed",equalTo(false),"userId",equalTo(2));


 */

    response.then().assertThat().statusCode(200)
            .contentType(ContentType.JSON)
            .body("title",equalTo("suscipit repellat esse quibusdam voluptatem incidunt")
                    ,"completed",equalTo(false),"id",equalTo(21));












}
}
