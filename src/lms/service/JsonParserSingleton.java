package lms.service;

import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;

/**
 * Created by 985176 on 6/1/2016.
 */
public final class JsonParserSingleton {
    private static JSONParser jsonParser = new JSONParser();
    private static Gson gson = new Gson();
    public static JSONParser getJsonParserInstance(){
        return jsonParser;
    }
    public static Gson getGsonInstance() {return gson; }
}
