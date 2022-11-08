package get_request;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
        {
        "id": 2508,
        "name": "Aayushmaan Tagore",
        "email": "aayushmaan_tagore@brekke.com",
        "gender": "male",
        "status": "active"
    }
          }
    */

    @Test
    public void post(){
        //Set the Url
        spec.pathParams("first","users","second",2508);

//Set the expected data

        GoRestDataPojo obj=new GoRestDataPojo(2508,"Aayushmaan Tagore",
                "aayushmaan_tagore@brekke.com","male","active");

        GoRestPojo expectedData=new GoRestPojo(null,obj);

        System.out.println("expectedData = " + expectedData);

//Send the request and the response data
        Response response=given().spec(spec).when().get("/{first}/{second}");
  response.prettyPrint();

//Do assertion

        GoRestPojo actualPojo=response.as(GoRestPojo.class);
        System.out.println("actualPojo = " + actualPojo);


        assertEquals(expectedData.getData().getEmail(),actualPojo.getData().getEmail());
        assertEquals(expectedData.getData().getId(),actualPojo.getData().getId());
        assertEquals(expectedData.getData().getGender(),actualPojo.getData().getGender());
        assertEquals(expectedData.getData().getName(),actualPojo.getData().getName());
        assertEquals(expectedData.getData().getStatus(),actualPojo.getData().getStatus());
        assertEquals(expectedData.getMeta(),actualPojo.getMeta());
    }
}