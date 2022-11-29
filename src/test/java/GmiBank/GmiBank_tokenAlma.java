package GmiBank;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class GmiBank_tokenAlma {

    public static String genereteToken(){


        String username="Batch81";
        String pasword="Batch81+";

        Map<String,Object>postBody=new HashMap<>();
        postBody.put("username",username);
        postBody.put("pasword",pasword);
        postBody.put("renemberMe",true);

        String endPoint = "https://www.gmibank.com/api/authenticate";
Response response=given().contentType(ContentType.JSON).body(postBody).when().post(endPoint);
        JsonPath token=response.jsonPath();
        return token.getString("id_token");


    }

    }


