package com.zhongd.bootapi;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApiApplicationTests {

    @Test
    public void contextLoads() {
        String dataStr = "\"{\"srg2\":\"456\",\"arg1\":\"123\",\"xrg1\":\"223\"}\"";
        Map map = new Gson().fromJson(dataStr, Map.class);
        map = sortMapByKey(map);
        for (Object key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        sortMap.putAll(map);
        return sortMap;
    }

}
