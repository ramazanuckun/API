package get_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class home01 extends JsonplaceholderBaseUrl {


    @Test
    public void name() {

        //  https://jsonplaceholder.typicode.com/posts/44

        //set the url

        spec.pathParams("first","posts","second",44);

        //expected data

        //set requens and the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4-Do Assert
//1.yol
        response.then().assertThat().
                statusCode(200).contentType(ContentType.JSON)
                .body("userId",equalTo(5),"title",
                        equalTo("optio dolor molestias sit"));
       //2/yol

JsonPath jsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
softAssert.assertEquals(jsonPath.getInt("userId"),5,"userId hatali");

softAssert.assertEquals(jsonPath.getString("title"),"optio dolor molestias sit");

//3-yol

assertEquals(5,jsonPath.getInt("userId"));
assertEquals("optio dolor molestias sit",jsonPath.getString("title"));

    }
}
