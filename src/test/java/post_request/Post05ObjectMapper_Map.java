package post_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Map extends JsonplaceholderBaseUrl {
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
    public void post05ObjectMapper() throws IOException {

//Set the url

        spec.pathParam("first","todos");

        //Set the expected data


//obje mapper kulanarak yapacagim olk olarak obje mabber clasimi tanimlayacagim


        String jsonInString="{\n" +
                "                                    \"userId\": 55,\n" +
                "                                    \"title\": \"Tidy your room\",\n" +
                "                                    \"completed\": false,\n" +
                "                                    \"id\": 201\n" +
                "                                    }";

        //   JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        //     String jsonInString=   obj.expectedDataInString(55,"Tidy your room",false); methodu ile yukaridaki kalabaliktan kurtuldum

        Map<String,Object>expectedData=  new ObjectMapper().readValue(jsonInString,HashMap.class);
/*
 new ObjectMapper().readValue(jsonInString,HashMap.class);static {

    mapper=new ObjectMapper();
}
//read value icin method
//    <T>=herhangi bir data tipi dmemek
public static <T> T convertJsonToJava(String json,Class<T>cls){


    T javaResult=null;
    try {
     javaResult=   mapper.readValue(json,cls);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
return javaResult;
}
bu method ile hem throwsdan hemde method olustrmaktan kurtuldum

 */
        System.out.println("expectedData = " + expectedData);//obje mabber ile ceviri islemi tamamlandi
        //fakat daha clear bir kod olmasi adina tmizlikler yapilacak
        //biz bunu pojo class ile yapacagiz
        /*
        onemli notlar
        1-biz daha clear bir kod yazma adina acception firtlatti throws IOException bundan kurtulacagiz

        throws her seferinde atmak zorunda kalirim bunun icin bir method tanimlayacagim try cath bloguicin ve yakalayacak her hatada
        2-her seferinde yeni bir obje olusturmayacagiz  new ObjectMapper().readValue
        3-{\n" +
                "                                    \"userId\": 55,\n" +
                "                                    \"title\": \"Tidy your room\",\n" +
                "                                    \"completed\": false,\n" +
                "                                    \"id\": 201\n" +
                "                                    }";
                bunu method olarak baska clasta tanimlayacagiz ve bu kod kalabaliginda kurtulacgiz
                Temizlige balayalim bu calss uzun olani 5b dyecegim kisa ve temiz olan
         */

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

//Do assertion

     HashMap<String,Object>actualData=   new ObjectMapper().readValue(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
    }}