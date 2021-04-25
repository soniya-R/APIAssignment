package org.automation.test;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * reading a json file to compare with response of GET request of single employee
 */

public class ReadingTestDataJson {

    public static Map<String,String> readJsonFile(String methodName, String jsonFileName) throws FileNotFoundException {

        String filePath=System.getProperty("user.dir")+"/resources/" + jsonFileName;
        JsonElement jsonElement = (new JsonParser()).parse(new FileReader(filePath));
        JsonObject object = jsonElement.getAsJsonObject();
        JsonElement element = object.get(methodName);
        JsonObject jsonObject = element.getAsJsonObject();
        Map<String,String> mapObject=new HashMap<String,String>();
        Iterator iterator = jsonObject.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry entry =(Map.Entry)iterator.next();
            mapObject.put(entry.getKey().toString(),entry.getValue().toString().replace("\"",""));
        }
        return mapObject;
    }
}
