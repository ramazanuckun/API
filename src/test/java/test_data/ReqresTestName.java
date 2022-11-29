package test_data;

import java.util.HashMap;
import java.util.Map;

public class ReqresTestName {

    public Map<String,String>expectedDataMethop(String name){

        Map<String,String>ecpectedData=new HashMap<>();
        ecpectedData.put("name",name);

        return ecpectedData;
    }
}
