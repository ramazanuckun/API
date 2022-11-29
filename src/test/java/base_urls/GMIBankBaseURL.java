package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utils.Authentication;

public class GMIBankBaseURL extends Authentication {

    protected RequestSpecification spec;

    @Before
    public  void setup(){

        spec=new RequestSpecBuilder().setBaseUri("http://www.gmibank.com/api").build();
    }
}
