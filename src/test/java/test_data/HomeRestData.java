package test_data;

import java.util.HashMap;
import java.util.Map;

public class HomeRestData {

    public Map<String,String>expectedMethod(String name,String email,String gender,String statu){

        Map<String,String>expected=new HashMap<>();
        expected.put("data.name",name);
        expected.put("data.email",email);
        expected.put("data.gender",gender);
        expected.put("data.status",statu);

        return  expected;


    }
    public Map<String,Object>expectedDis(String meta,Map<String,String>data){


        Map<String,Object>expectedDisinDsi=new HashMap<>();

        expectedDisinDsi.put("meta",meta);
        expectedDisinDsi.put("data",data);

        return expectedDisinDsi;


    }

}
