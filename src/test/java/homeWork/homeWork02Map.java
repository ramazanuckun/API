package homeWork;

import base_urls.RestfulBaseUrl;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqresPojo;
import test_data.ReqresTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class homeWork02Map extends RestfulBaseUrl {
    /*
    {
    "name": "morpheus",
    "job": "leader",
    "id": "815",
    "createdAt": "2022-11-10T11:40:54.586Z"
}
     */

    @Test
    public void homeWorkMap() {
        //Set the url

        spec.pathParam("first","users");

        //Set the expected data
     //   Map<String,String>expected=new HashMap<>();
        ReqresTest expected=new ReqresTest();
Map<String,String>expectedData=expected.expectedDataMethohod("morpheus","leader");
        System.out.println("expected = " + expectedData);
//Send the request and the response


        Response response=given().spec(spec).contentType(ContentType.JSON)
                .body(expectedData).when().post("/{first}");
        response.prettyPrint();
//Do assertion

        Gson gson=new Gson();//java ile gelen objeyi json formatina donusturuyor

        Map<String,String>actual=gson.fromJson(response.asString(), HashMap.class);
        System.out.println("actual = " + actual);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("name"),actual.get("name"));
        assertEquals(expectedData.get("job"),actual.get("job"));


    }
}
