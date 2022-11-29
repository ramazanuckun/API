package homeWork;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.RegresNamePojo;
import pojos.ReqresPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class homeWork04Pojo extends ReqresBaseUrl {

    @Test
    public void pojo() {
        spec.pathParams("first","users","second",2);

        RegresNamePojo expected=new RegresNamePojo("neo");

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expected).when().patch("/{first}/{second}");
response.prettyPrint();
        RegresNamePojo actual= ObjectMapperUtils.convertJsonToJava(response.asString(),RegresNamePojo.class);
        System.out.println("actual = " + actual);

        assertEquals(200,response.getStatusCode());
        assertEquals(expected.getName(),actual.getName());
    }
}
