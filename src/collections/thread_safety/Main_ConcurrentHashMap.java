package collections.thread_safety;

import java.util.concurrent.ConcurrentHashMap;

public class Main_ConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1", "第一条");
    }
}
