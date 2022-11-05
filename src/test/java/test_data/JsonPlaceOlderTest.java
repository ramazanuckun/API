package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceOlderTest {



    public Map<String,Object>expectedDataMethod(int userId,String title,
                                          Boolean completed){


        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("userId",userId);
        expectedData.put("title",title);
        expectedData.put("completed",completed);

        return expectedData;

    }
}
