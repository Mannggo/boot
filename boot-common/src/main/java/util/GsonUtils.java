package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author 谢仲东
 * @date 2019/3/20 15:05
 */
public class GsonUtils {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * POJO 转 json
     * @param object
     * @param clazz
     * @return
     */
    public static String toJSON(Object object, Class clazz) {
        return gson.toJson(object, clazz);
    }

    /**
     * json 转 POJO
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJSON(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
