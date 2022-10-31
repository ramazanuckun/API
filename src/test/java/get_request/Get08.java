package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonplaceholderBaseUrl {

    //De-Serialization: Json datayı Java objesine çevirme
    //Serialization: Java objesini Json formatına çevirme.
    //De-Serialization: Iki türlü yapacağız.
    //Gson: Google tarafından üretilmiştir.
    //Object Mapper: Daha popüler...

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get08() {
//set the url
        spec.pathParams("first", "todos", "second", 3);
        //set the expected data

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("id", 3);
        expectedData.put("title", "fugiat veniam minus");
        expectedData.put("completed", false);

//set the request data and the response data
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
//do assertion

        assertEquals(200, response.statusCode());
        assertEquals("1.1 vegur", response.header("Via"));
        assertEquals("cloudflare", response.header("server"));

        Map<String, Object> actualData = response.as(HashMap.class);//
        System.out.println("ActualData==>" + actualData);
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("title"), actualData.get("title"));

        assertEquals(expectedData.get("completed"), actualData.get("completed"));





    }
}
