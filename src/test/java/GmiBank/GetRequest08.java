package GmiBank;

import base_urls.GMIBankBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GmiRestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest08 extends GMIBankBaseURL {

        /*
          http://www.gmibank.com/api/tp-customers/43703

          "firstName": "Alda",
          "lastName": "Monahan",
          "middleInitial": "Nichelle Hermann Kohler",
          "email": "com.github.javafaker.Name@7c011174@gmail.com",
          "mobilePhoneNumber": "909-162-8114",
          "city": "St Louis",
          "ssn": "108-53-6655"

          1) MATCHERS CLASS
          2) JSON PATH
          3) De-Serialization
    */
@Test
    public void get08(){
    //Set the url
    spec.pathParams("first","tp-customers","second",43703);
    //Set the expected

GmiRestData expected=new GmiRestData();

Map<String,String>expectedData=new HashMap<>(expected.dataGmi("Alda","Monahan","Nichelle Hermann Kohler",
        "com.github.javafaker.Name@7c011174@gmail.com","909-162-8114",
        "St Louis", "108-53-6655"));
    System.out.println("expectedData = " + expectedData);

//Send the request and the response

    Response response=given().spec(spec).headers("Authorization","Bearer "+generateToken())
    .when().get("/{first}/{second}");
response.prettyPrint();
//Do assertion


    //1-Matchers class ile

    response.then().statusCode(200).body("firstName",equalTo("Alda"),
            "lastName",equalTo("Monahan"),"middleInitial",equalTo("Nichelle Hermann Kohler"),
            "email",equalTo("com.github.javafaker.Name@7c011174@gmail.com"),"mobilePhoneNumber",equalTo("909-162-8114"),
            "city",equalTo("St Louis"),"ssn",equalTo("108-53-6655"));


//   2) JSON PATH
    JsonPath jsonPath=response.jsonPath();

assertEquals("Alda",jsonPath.getString("firstName"));
assertEquals("Monahan",jsonPath.getString("lastName"));
assertEquals("Nichelle Hermann Kohler",jsonPath.getString("middleInitial"));
assertEquals("com.github.javafaker.Name@7c011174@gmail.com",jsonPath.getString("email"));
assertEquals("St Louis",jsonPath.getString("city"));
assertEquals("108-53-6655",jsonPath.getString("ssn"));

//3) De-Serialization

    Map<String, String> actualData = response.as(HashMap.class);
    System.out.println("actualData = " + actualData);
  assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
    assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
    assertEquals(expectedData.get("middleInitial"),actualData.get("middleInitial"));
    assertEquals(expectedData.get("email"),actualData.get("email"));
    assertEquals(expectedData.get("mobilePhoneNumber"),actualData.get("mobilePhoneNumber"));
    assertEquals(expectedData.get("city"),actualData.get("city"));
    assertEquals(expectedData.get("ssn"),actualData.get("ssn"));


}
}
