package homeWork;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class homeWork03Pojo extends ReqresBaseUrl {
    /*
    //3: Map ile ve Pojo Class ile ayrı ayrı Gson kullanarak yapınız.

/*
        Given
            1) https://reqres.in/api/users/2
            2) {
                "name": "morpheus",
                "job": "zion president"
                }
        When
            I send Put Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "zion president",
                                                "updatedAt": "2022-10-02T11:35:05.693Z"
                                            }
*/

    @Test
    public void homeWorkPojo() {

        //Set the url

        spec.pathParams("first","users","second",2);

        //Set the expected data
        ReqresPojo expected=new ReqresPojo("morpheus","zion president");
        System.out.println("expected = " + expected);
    //Send the request and the response data

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expected).when().put("/{first}/{second}");
        response.prettyPrint();

        //do assertion

        ReqresPojo actual=response.as(ReqresPojo.class);
        System.out.println("actual = " + actual);

       // Gson gson=new Gson();

        assertEquals(200,response.getStatusCode());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getJob(),actual.getJob());

    }
}
