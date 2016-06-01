package lms.service;

import org.json.simple.parser.JSONParser;

/**
 * Created by 985176 on 6/1/2016.
 */
public final class JsonParserSingleton {
    private static JSONParser jsonParser = new JSONParser();
    public static JSONParser getJsonParserInstance(){
        return jsonParser;
    }
}
