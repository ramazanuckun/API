package test_data;

import java.util.HashMap;
import java.util.Map;

public class GmiRestData {

    public Map<String,String>dataGmi(String firstname,
                                     String lastname,
                                     String middleInitial,
                                     String email,
                                     String mobilePhoneNumber
                                     ,String city
                                     ,String ssn
    ){

        Map<String,String>expectedData=new HashMap<>();
        expectedData.put("firstName",firstname);
        expectedData.put("lastName",lastname);
        expectedData.put("middleInitial",middleInitial);
        expectedData.put("email",email);
        expectedData.put("mobilePhoneNumber",mobilePhoneNumber);
        expectedData.put("city",city);
        expectedData.put("ssn",ssn);

        return expectedData;
    }

}
