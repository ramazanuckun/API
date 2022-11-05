package homeOdevler;

import base_urls.GoRestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.HomeRestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class home01 extends GoRestBaseUrl {

            /*
   Given
       https://gorest.co.in/public/v1/users/2986
   When
       User send GET Request to the URL
   Th
       Status Code should be 200en
   And
       Response body should be like
{
    "meta": null,
    "data": {
        "id": 2986,
        "name": "Bhaumik Jha",
        "email": "jha_bhaumik@schinner-moore.info",
        "gender": "male",
        "status": "inactive"
    }
}
*/

    @Test
    public void getEqualToileCozum() {
//Set the url

        spec.pathParams("first","users","second",2986);
//

        //Set the expected data

        //Set request data and the response data

        Response response=given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

//Do assertion

//1. yol body ile macharts ile yani equalTo ile cozum

response.then().statusCode(200).contentType(ContentType.JSON);
response.then().body("meta", equalTo(null)
,"data.name",equalTo("Bhaumik Jha"),
        "data.email",equalTo("jha_bhaumik@schinner-moore.info"),
        "data.gender",equalTo("male"),"data.status",equalTo("inactive"));



    }

    @Test
    public void jsonileSoftAssert() {

        //Set the url

        spec.pathParams("first","users","second",2986);
//

        //Set the expected data

        //Set request data and the response data

        Response response=given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

//Do assertion


        SoftAssert softAssert=new SoftAssert();
        JsonPath jsonPath=response.jsonPath();

        response.then().statusCode(200).contentType(ContentType.JSON);

softAssert.assertEquals(jsonPath.getString("meta"),null);
softAssert.assertEquals(jsonPath.getString("data.name"),"Bhaumik Jha");
softAssert.assertEquals(jsonPath.getString("data.email"),"jha_bhaumik@schinner-moore.info");
softAssert.assertEquals(jsonPath.getString("data.gender"),"male");
softAssert.assertEquals(jsonPath.getString("data.status"),"inactive");

softAssert.assertAll();



    }

    @Test
    public void mapileCozum() {

        //Set the url

        spec.pathParams("first", "users", "second", 2986);
//

        //Set the expected data

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("data.name", "Bhaumik Jha");
        dataMap.put("data.email", "jha_bhaumik@schinner-moore.info");
        dataMap.put("data.gender", "male");
        dataMap.put("data.status", "inactive");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("meta", null);
        expectedData.put("data", expectedData);

        //Set request data and the response data

        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

//Do assertion

        response.then().statusCode(200).contentType(ContentType.JSON);

        Map<String,Object>actualData=response.as(HashMap.class);

        //karsilastiralim

        assertEquals(expectedData.get("meta"),actualData.get("meta"));
        assertEquals(expectedData.get("data.name"),actualData.get("data.name"));
assertEquals(expectedData.get("data.email"),actualData.get("data.email"));
assertEquals(expectedData.get("data.gender"),actualData.get("data.gender"));
assertEquals(expectedData.get("data.status"),actualData.get("data.status"));


    }

    @Test
    public void mapdinamikMethod() {
        //Set the url

        spec.pathParams("first", "users", "second", 2986);
//

        //Set the expected data
        HomeRestData home=new HomeRestData();
        Map<String,String>dataic=home.expectedMethod("Bhaumik Jha","jha_bhaumik@schinner-moore.info","male","inactive");
        Map<String,Object>datadis=home.expectedDis(null,dataic);






        //Set request data and the response data

        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

//Do assertion

        response.then().statusCode(200).contentType(ContentType.JSON);

        Map<String,Object>actualMap=response.as(HashMap.class);

        assertEquals(datadis.get("meta"),actualMap.get("meta"));
        assertEquals(datadis.get("data.name"),actualMap.get("data.name"));
        assertEquals(datadis.get("data.email"),actualMap.get("data.email"));
        assertEquals(datadis.get("data.gender"),actualMap.get("data.gender"));
        assertEquals(datadis.get("data.status"),actualMap.get("data.status"));


    }
}
