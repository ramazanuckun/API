package get_request;

import base_urls.GoRestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get12 extends GoRestBaseUrl {


      /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        Niranjan Gupta, Samir Namboothiri and Gandharva Kaul are among the users
    And
        The female users are less than or equals to male users
 */


    @Test
    public void get11() {

      //Set the url


        spec.pathParam("first","users");


        //Set expected data

        //Set request data and the response data


        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do assertion

        //1.yol


        response.then().statusCode(200).contentType(ContentType.JSON).
               body("meta.pagination.limit",equalTo(10),
                     "meta.pagination.links.current",
                       equalTo("https://gorest.co.in/public/v1/users?page=1"),
              "data",hasSize(10),"data.status",hasItem("active"),"data.name"
               ,hasItems("Devdan Shah","Anunay Nambeesan DVM","Anagh Jha Sr."));

        List<String>gender=response.jsonPath().getList("data.gender");
        System.out.println("gender = " + gender);
int male=0;
int female=0;

        for (String w:gender
             ) {
           if (w.equalsIgnoreCase("male")) {
               male++;
               System.out.println(male);
           }
        }
assertTrue(male<=gender.size()-male);

//Groovy ile bulalim

        List<String>femaleNames=response.jsonPath().getList
                ("data.findAll{it.gender=='female'}.gender");
        System.out.println(femaleNames);
List<String>malenames=response.jsonPath().getList(
        "data.findAll{it.gender=='male'}.gender"
);
        System.out.println(malenames);
assertTrue(malenames.size()<=femaleNames.size());
}}
