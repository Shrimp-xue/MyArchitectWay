package com.shrimp.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @description: Json 工具类
 * @author: shrimp
 * @date: Created in 2020-01-11 18:17
 * @version: 1.0
 */
public class JacksonUtil {

    private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        // 将null值不序列化
        // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);


        /* 将null值转换为空串 */
        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException, JsonProcessingException {
                gen.writeString("");
            }
        });
    }

    /**
     * 对象转换成JSON
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        StringWriter sw = new StringWriter();
        JsonGenerator gen = null;
        try {
            gen = new JsonFactory().createGenerator(sw);
            mapper.writeValue(gen, obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gen != null) {
                try {
                    gen.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sw.toString();
    }

    public static <T> T JsonToBean(String jsonStr, Class<T> objClass)
            throws JsonParseException, JsonMappingException, IOException {
        return mapper.readValue(jsonStr, objClass);
    }

    /**
     * 将 JSON 字符串转化为 Java 对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        T object = null;
        try {
            object = mapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("JSON String Can't covert to Java Object!");
        }
        return object;
    }

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
