package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationBaseUrl {

    protected RequestSpecification spec;
    @Before
    public  void sutup(){

       spec=new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();

    }

}
