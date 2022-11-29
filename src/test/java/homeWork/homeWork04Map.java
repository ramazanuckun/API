package homeWork;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.ReqresTestName;
import utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class homeWork04Map extends ReqresBaseUrl {

    //4: Map ile ve Pojo Class ile ayrı ayrı Object Mapper kullanarak yapınız.
  /*
       Given
           1) https://reqres.in/api/users/2
           2) {
                "name": "neo"
               }
       When
            I send PATCH Request to the Url
       Then
             Status code is 200
             And response body is like   {
                                                "name": "neo",
                                                "updatedAt": "2022-10-02T12:53:21.675Z"
                                         }
    */

    @Test
    public void map() {

        spec.pathParams("first","users","second",2);





        //expected
        ReqresTestName obj=new ReqresTestName();
        Map<String,String>expectedData=obj.expectedDataMethop("neo");
        System.out.println("expectedData = " + expectedData);


//Send
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");

        response.prettyPrint();

        //Do assertion

       Map actual= ObjectMapperUtils.convertJsonToJava(response.asString(), Map.class);
        System.out.println("actual = " + actual);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("name"),actual.get("name"));


    }

}
