package get_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class GetObjectMapper_Pojo extends JsonplaceholderBaseUrl {

         /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
    "userId": 10,
    "id": 198,
    "title": "quis eius est sint explicabo",
    "completed": true
}
     */

    @Test
    public void get14Pojo() {

        //Set the url

        spec.pathParams("first","todos","second",198);


        //Set the expectedData

        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true)
;

        //Send Ruquest and the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
//Do Assertion

        JsonPlaceHolderPojo actualData=response.as(JsonPlaceHolderPojo.class);


        System.out.println("actualData = " + actualData);

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(200,response.getStatusCode());
        softAssert.assertEquals(actualData.getCompleted(),expectedData.getCompleted());
softAssert.assertEquals(actualData.getTitle(),expectedData.getTitle());
softAssert.assertEquals(actualData.getUserId(),expectedData.getTitle());
softAssert.assertEquals(actualData.getUserId(),expectedData.getUserId());
    }
}
