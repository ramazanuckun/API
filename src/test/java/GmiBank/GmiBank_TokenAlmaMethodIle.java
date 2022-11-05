package GmiBank;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static utities.Authenticcotion.generateToken;

public class GmiBank_TokenAlmaMethodIle {

    @Test
    public void name() {


        String url="https://www.gmibank.com/api/tp-customers/114351";

        Response response=given().headers("Authorization","Bearer "+generateToken()).when().get(url);
        response.prettyPrint();
    }
}
