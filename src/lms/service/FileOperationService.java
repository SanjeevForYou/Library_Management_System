package lms.service;


import com.sun.org.apache.xpath.internal.operations.Bool;
import lms.domain.Address;
import lms.domain.Person;
import lms.util.Gender;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 985176 on 6/1/2016.
 */
public class FileOperationService {

    private boolean writeToFile(String filePath, Object object) throws IllegalAccessException {
        Map<String, List<JSONObject>> jsonObjectMap = new HashMap<String, List<JSONObject>>();
        JSONObject jsonObject = new JSONObject();
        Class class1 = object.getClass();
        jsonObject = getJsonObjectRecursively(object,jsonObject,true);
        JSONObject fileJson = readFromFile(filePath);
        System.out.println("json map :: "+jsonObjectMap);
        if(null == fileJson.get(class1.getName())){
            List<JSONObject> jsonObjects = new ArrayList<>();
            jsonObjects.add(jsonObject);
            jsonObjectMap.put(class1.getName(),jsonObjects);
        }else
            jsonObjectMap.get(class1.getName()).add(jsonObject);
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

    public static void main(String[] args) throws IllegalAccessException {
        Address address = new Address("1000 N","Fairfield","52557","IA");
        Person person = new Person("first name","last name", LocalDate.now(),
                Gender.Male,address,LocalDate.now(),"active","email@email.com");
        FileOperationService fileOperationService = new FileOperationService();
        Boolean status = fileOperationService.writeToFile("C://Users//985176//workspace//testFile.txt",person);
        System.out.println(status);

    }

    public JSONObject getJsonObjectRecursively(Object object, JSONObject jsonObject, Boolean recurse) throws IllegalAccessException {
        if(!recurse) return jsonObject;
        jsonObject = new JSONObject();
        for(Field field : object.getClass().getDeclaredFields()) {
            if(field.getClass().getName().equals(object.getClass().getName())){
                field.setAccessible(true);
                Object value = field.get(object);
                if (value != null) {
                    jsonObject.put(field.getName(), value);
                }
                recurse = false;
                getJsonObjectRecursively(object,jsonObject,recurse);
            }else{

            }
        }
        return jsonObject;
    }

    public JSONObject readFromFile(String filePath){
        JSONObject jsonObject = null;
        JSONParser jsonParser = JsonParserSingleton.getJsonParserInstance();
        try{
            Object obj = jsonParser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) obj;
        }catch(FileNotFoundException e){
            System.out.println("File not exists !!");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public void convertJsonToObject(){

    }
}



