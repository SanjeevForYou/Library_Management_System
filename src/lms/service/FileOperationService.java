package lms.service;


import com.google.gson.Gson;
import lms.domain.Address;
import lms.domain.Person;
import lms.util.Gender;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
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
        try{
            JSONObject job = new JSONObject();
            String className = object.getClass().getSimpleName().trim();
            JSONObject fileJson = readFromFile(filePath);

            Gson gson = JsonParserSingleton.getGsonInstance();
            JSONParser jsonParser = JsonParserSingleton.getJsonParserInstance();

            String json = gson.toJson(object);
            FileWriter file = new FileWriter(filePath);
            Map<String, JSONArray> jsonObjectMap = new HashMap<>();
            if(null == fileJson.get(className)){
                JSONArray jsonList = new JSONArray();
                jsonList.add(jsonParser.parse(json));
                jsonObjectMap.put(className, jsonList);
                job.putAll(jsonObjectMap);
                job.putAll(fileJson);
            }
            else {
                JSONArray jsonList = (JSONArray)fileJson.get(className);
                jsonList.add(jsonParser.parse(json));
                fileJson.put(className,jsonList);
                job.putAll(fileJson);
            }
            file.write(job.toJSONString());
            file.flush();
            file.close();

        } catch (EOFException | ParseException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

//    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {
//        Address address = new Address("1000 N","Fairfield","52557","IA");
//        Person person = new Person("first name","last name", LocalDate.now(),
//                Gender.Male,address,LocalDate.now(),"active","email@email.com");
//        FileOperationService fileOperationService = new FileOperationService();
//        Boolean status = fileOperationService.writeToFile("E://Test.txt",person);
//        System.out.println(status);
//        Person p = new Person();
//
//        System.out.println(fileOperationService.searchObjectsFromFile("E://Test.txt", person));
//
//    }

    private JSONObject readFromFile(String filePath){
        JSONObject jsonObject = new JSONObject();
        JSONParser jsonParser = new JSONParser();
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

    public List<Object> searchObjectsFromFile(String filePath, Object object) throws ClassNotFoundException {
        List<Object> objectList = new ArrayList<>();
        JSONObject fileData = readFromFile(filePath);
        Gson gson = JsonParserSingleton.getGsonInstance();
        String name = object.getClass().getSimpleName();
        JSONArray jsonArray = (JSONArray) fileData.get(name);
        for(int i=0;i<jsonArray.size();i++){
            objectList.add(gson.fromJson(jsonArray.get(i).toString(), object.getClass()));
        }
        return objectList;
    }

    public List<Object> searchByFields(String filePath,Object object,Map<String,String> searchParams) throws ClassNotFoundException, IllegalAccessException {
        List<Object> objectList = searchObjectsFromFile(filePath,object);
        List<Object> finalObjectList = new ArrayList<>();
        String name = "";
        String searchedValue = "";
        Boolean addThis = false;
        Field[] fields = object.getClass().getDeclaredFields();
        for(Object obj : objectList){
            for(Field f : fields){
                f.setAccessible(true);
                Object value = f.get(obj);
                name = f.getName();
                searchedValue = searchParams.get(name);
                if(searchedValue==null) continue;
                if(value.toString().contains(searchedValue)){
                    addThis = true;
                    break;
                }
            }
            if(addThis) finalObjectList.add(obj);
        }
        return finalObjectList;
    }
}



