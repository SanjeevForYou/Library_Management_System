package lms.service;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 985176 on 6/1/2016.
 */
public class FileOperationService {
    private Map<String,List<JSONObject>> jsonObjectMap;

    public boolean writeToFile(String filePath,Object object ) throws IllegalAccessException {
        jsonObjectMap = new HashMap<String, List<JSONObject>>();
        JSONObject jsonObject = new JSONObject();
        for(Field field : object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            Object value = field.get(object);
            if(value!=null){
                jsonObject.put(field.getName(),value);
            }
        }
        if(this.jsonObjectMap.get(object.getClass())==null){
            this.jsonObjectMap.put(object.getClass().toString(),(List)jsonObject);
        }else
            this.jsonObjectMap.get(object.getClass().toString()).add(jsonObject);
        try{
            FileWriter file = new FileWriter(filePath);
            file.write(new JSONObject(jsonObjectMap).toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Object> readFromFile(String filePath,Object object){
        List<Object> objects = new ArrayList<Object>();
        JSONParser jsonParser = JsonParserSingleton.getJsonParserInstance();
        try{
            Object obj = jsonParser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
        }catch(FileNotFoundException e){
            System.out.println("File not exists !!");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objects;
    }
}



