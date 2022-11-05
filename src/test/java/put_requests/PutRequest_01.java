package put_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceOlderTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class PutRequest_01 extends JsonplaceholderBaseUrl {

    /*
    {
    "completed": true,
    "title": "ramazan rahmi uckun",
    "userId": 155,
    "id": 201
}
     */
    @Test
    public void put01(){


        //set the url

        spec.pathParams("first","todos","second",155);

        //set the expected

        JsonPlaceOlderTest obj=new JsonPlaceOlderTest();

        Map<String,Object>expected=obj.expectedDataMethod(155,"" +
                "Yakup",false);


        //Set the request data and the response data

        Response response=given().spec(spec).contentType(ContentType.JSON)
                .body(expected).when().put("/{first}/{second}");

        response.prettyPrint();

//Do assertion
        Map<String,Object>actualData=response.as(HashMap.class);

        assertEquals(expected.get("completed")
        ,actualData.get("completed"));
        assertEquals(expected.get("title"),actualData.get("title"));
        assertEquals(expected.get("userId"),actualData.get("userId"));


    }
}
