package get_request;

import base_urls.AutomationBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class homeOdev_01 extends AutomationBaseUrl {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be "text/html; charset=utf-8"
    And
        Status Line should be HTTP/1.1 200 OK
    And
         There must be 12 Women, 9 Men, 13 Kids usertype in products
      */
    @Test
    public void homeodev() {

        //Set the url
        spec.pathParams("first", "productsList");
//Set the expected Data

        //Set request data and the response data

        Response response = given().spec(spec).when().get("/{first}");
//response.prettyPrint();

//Do assertion
        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        assertEquals(200, response.statusCode());
        assertEquals("text/html; charset=utf-8", response.getContentType());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        List<String> usertypeListi = jsonPath.getList("products.category.usertype.usertype"); // JSON bodysinin usertype
        System.out.println(usertypeListi);


        int Women = 0;
        int Men = 0;
        int Kids = 0;

        for (int i = 0; i < usertypeListi.size(); i++) {

            if (usertypeListi.get(i).equals("Women")) Women++;
            if (usertypeListi.get(i).equals("Men")) Men++;
            if (usertypeListi.get(i).equals("Kids")) Kids++;
        }

        System.out.println("Women = " + Women);
        System.out.println("men = " + Men);
        System.out.println("Kids = " + Kids);

        assertEquals(12, Women);
        assertEquals(9, Men);
        assertEquals(13, Kids);

    }

    @Test
    public void get2() {

        //Set the url
        spec.pathParams("first", "productsList");
//Set the expected Data

        //Set request data and the response data

        Response response = given().spec(spec).when().get("/{first}");
//response.prettyPrint();

//Do assertion
        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        assertEquals(200, response.statusCode());
        assertEquals("text/html; charset=utf-8", response.getContentType());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        List<String> women = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Women'}.usertype");
        System.out.println("women = " + women);
        softAssert.assertEquals(12, women.size(),"Women sayisi 12'ye esit degil");

        List<String> men = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Men'}.usertype");
        System.out.println("men = " + men);
        softAssert.assertEquals(9, men.size(),"Men sayisi 9'a esit degil");

        List<String> kids = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Kids'}.usertype");
        System.out.println("kids = " + kids);
        softAssert.assertEquals(13, kids.size(),"Kids saysi 13'e esit degil");

        softAssert.assertAll();


    }
}
