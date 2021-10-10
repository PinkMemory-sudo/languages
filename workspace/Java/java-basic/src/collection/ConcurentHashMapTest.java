package collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("name","tom");
        System.out.println(map);
    }
}
