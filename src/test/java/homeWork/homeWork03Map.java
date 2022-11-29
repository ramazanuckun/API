package homeWork;

import base_urls.ReqresBaseUrl;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.ReqresTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class homeWork03Map extends ReqresBaseUrl {
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
    public void homeWork03Map() {
        //Set the url

        spec.pathParams("first","users","second",2);

        //Set the expectedData

        ReqresTest expected=new ReqresTest();
        Map<String,String>expectedData=expected.expectedDataMethohod("morpheus","zion president");

        System.out.println("expectedData = " + expectedData);

        //Send request data and the response data

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");
        response.prettyPrint();
//Do assertion
JsonPath jsonPath=response.jsonPath();
Gson gson=new Gson();
Map<String,String> actual=gson.fromJson(response.asString(), HashMap.class);
        System.out.println("actual = " + actual);


    }
}
