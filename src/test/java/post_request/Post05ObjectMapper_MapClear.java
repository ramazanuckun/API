package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_MapClear extends JsonplaceholderBaseUrl {
     /*

         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
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
    public void post05ObjectMapper() throws IOException {

//Set the url

        spec.pathParam("first","todos");

        //Set the expected data


//obje mapper kulanarak yapacagim olk olarak obje mabber clasimi tanimlayacagim


        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
     String jsonInString=   obj.expectedDataInString(55,"Tidy your room",false);
        HashMap expectedData=  new ObjectMapper().readValue(jsonInString,HashMap.class);

        System.out.println("expectedData = " + expectedData);


        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

//Do assertion
        HashMap actualData=   new ObjectMapper().readValue(response.asString(), HashMap.class);

        //json seklinde gelen veriyi has mapa cevirid

        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
assertEquals(expectedData.get("title"),actualData.get("title"));
assertEquals(expectedData.get("completed"),actualData.get("completed"));



    }}