package homeWork;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class homeWork02Pojo extends ReqresBaseUrl {


    //2:  Map ve Pojo Class ile ayrı ayrı yapınız.
/*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
*/

    @Test
    public void homeWork() {

        //Set the url
        spec.pathParam("first","users");
        //Set the expected data
ReqresPojo expected=new ReqresPojo("morpheus","leader");
        System.out.println("expected = " + expected);

        //Send the request data and the response data
Response response=given().spec(spec).contentType(ContentType.JSON).body(expected).when().post("/{first}");
response.prettyPrint();
//Do Assertion
ReqresPojo actual=response.as(ReqresPojo.class);
        System.out.println("actual = " + actual);

assertEquals(201,response.getStatusCode());
assertEquals(expected.getName(),actual.getName());
assertEquals(expected.getJob(),actual.getJob());
    }
}
