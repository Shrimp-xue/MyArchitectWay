package com.shrimp.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description: Json 工具类
 * @author: shrimp
 * @date: Created in 2020-01-11 16:02
 * @version: 1.0
 */
public class JsonHelper {

    private JsonHelper(){}

    /**
     * @Description: 对象转字符串
     * @Author Shrimp
     * @date: 2020-01-11 16:06
     * @Param: [object]
     * @Return: java.lang.String
     *
     **/
    public static String object2str(Object object){
        String retStr = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            retStr = mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return retStr;
    }

    /**
     * @Description: 字符串转对象
     * @Author Shrimp
     * @date: 2020-01-11 16:21
     * @Param: [str, cls]
     * @Return: java.lang.Object
     *
     **/
    public static Object str2Object(String str, Class cls){
        Object retObj = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            retObj = mapper.readValue(str, cls);
        }catch (Exception e){
            e.printStackTrace();
        }
        return retObj;
    }
}
