package homeWork;

import base_urls.AutomationBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class homeWork01 extends AutomationBaseUrl {
     /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
*/

    @Test
    public void homeWork01() {

        //Set the url
        spec.pathParam("first","brandsList");

        //Set the expected data

        //Send the request and the respons data
        Response response=given().spec(spec).when().get("/{first}");

        response.prettyPrint();

        //Do assertion

        response.then().statusCode(200).contentType("text/html; charset=utf-8").statusLine("HTTP/1.1 200 OK");
        List<String> brandlist = response.htmlPath().getList("brands.brand");
        System.out.println("brandlist = " + brandlist);
        int numOfHM = 0;
        int numOfPolo = 0;
        for (String w : brandlist) {
            if (w.equals("H&M")) {
                numOfHM++;
            }
            if (w.equals("Polo")) {
                numOfPolo++;
            }

        }
        assertEquals(numOfHM, numOfPolo);
    }
}
