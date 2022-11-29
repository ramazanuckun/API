package get_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get16 extends DummyRestApiBaseUrl {


 //  Given
 //  URL: https://dummy.restapiexample.com/api/v1/employees
 //  When
 //  HTTP Request Method: GET Request
 //  Test Case: Type by using Gherkin Language Then
 //  Then
 //  i) Status code is 200
 //  And
 //  ii) There are 24 employees
 //  And
 //  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
 //  And
 //  iv) The greatest age is 66
 //  And
 //  v) The name of the lowest age is "Tatyana Fitzpatrick"
 //  And
 //  vi) Total salary of all employees is 6,644,770

    @Test
    public void get17(){

        spec.pathParam("first","employees");
        Response response=given().spec(spec).when().get("/{first}");
    //    response.prettyPrint();
response.then().statusCode(200).body("data.id",hasSize(24),
        "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));
        //  iv) The greatest age is 66
        List<Integer>ages=response.jsonPath().getList("data.employee_age");
       // System.out.println("ages = " + ages);
        Collections.sort(ages);
        System.out.println("ages = " + ages.get(ages.size()-1));
        assertEquals(66,(int)ages.get(ages.size()-1));
        //  v) The name of the lowest age is "Tatyana Fitzpatrick"


       // String names=response.jsonPath().getString("data.findAll{it.employee_age==19}.employee_age");
         String names=response.jsonPath().getString("data.findAll{it.employee_age=="+ages.get(0)+"}.employee_name");
        System.out.println("names = " + names);
        assertTrue(names.contains("Tatyana Fitzpatrick"));
        //  vi) Total salary of all employees is 6,644,770
List<Integer>salary=response.jsonPath().getList("data.employee_salary");
        System.out.println("salary = " + salary);
      int sum=0;
    //1.yol foreach ile
        for (Integer w:salary
             ) {
sum+=w;
        }
        System.out.println("sum = " + sum);
        //2.yol


     int sum1=   salary.stream().reduce(0,Integer::sum);
        System.out.println("sum1 = " + sum1);

        //3.yol

        int sum2=salary.stream().reduce(0,Math::addExact);
        System.out.println("sum2 = " + sum2);
          assertEquals(sum,6644770);


    }


}
