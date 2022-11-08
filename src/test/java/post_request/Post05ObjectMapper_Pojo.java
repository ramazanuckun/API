package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;



import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
         /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post05ObjeMapper() {

//Set the url

        spec.pathParam("first","todos");

        //Set the expected data

JsonPlaceHolderPojo expected=new JsonPlaceHolderPojo(55,"Tidy your room",false);



//obje mapper kulanarak yapacagim olk olarak obje mabber clasimi tanimlayacagim

       Response response=given().spec(spec).contentType(ContentType.JSON).body(expected).post("/{first}");
       response.prettyPrint();

       //Do Assertion

     JsonPlaceHolderPojo actual=   ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);

        //kodu daha temiz hale getirdik ObjectMapperutils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);kullanarak
       System.out.println("actual = " + actual);

assertEquals(201,response.getStatusCode());
assertEquals(expected.getTitle(),actual.getTitle());
assertEquals(expected.getCompleted(),actual.getCompleted());
assertEquals(expected.getUserId(),actual.getCompleted());



    }}