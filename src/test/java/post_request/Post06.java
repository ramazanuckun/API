package post_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post06 extends DummyRestApiBaseUrl {

         /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
                     {
                        "employee_name": " Uckun",
                        "employee_salary": 6200,
                        "employee_age": 42,
                        "profile_image": "Perfect image",
                        "id": 4891
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                          "employee_name": " Uckun",
                        "employee_salary": 6200,
                        "employee_age": 42,
                        "profile_image": "Perfect image",
                        "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */


    /*
    Given
        https://dummy.restapiexample.com/api/v1/create
    And    {
            "employee_name": "Tom Hanks",
            "employee_salary": 111111,
            "employee_age": 23,
            "profile_image": "Perfect image",
            "id": 4891
          }
     When
        User sends POST request
     Then
        Status code is 200
     And
        Response body should be like the following
        {
            "status": "success",
            "data": {
                "employee_name": "Tom Hanks",
                "employee_salary": 111111,
                "employee_age": 23,
                "profile_image": "Perfect image",
                "id": 4891
            },
            "message": "Successfully! Record has been added."
        }
     */

    @Test
    public void post() {


//Set the url

        spec.pathParam("first", "create");

        //Set the expectedData


        DummyDataPojo expectedData = new DummyDataPojo("ramazan uckun", 6200, 42, "Perfect image");

        System.out.println("expectedData = " + expectedData);


        //Send request and the response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
        response.prettyPrint();

//Do Assertion

        DummyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getEmployee_age(), actualData.getData().getEmployee_age());
        assertEquals(expectedData.getEmployee_name(), actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getProfile_image(), actualData.getData().getProfile_image());


    }
    }

