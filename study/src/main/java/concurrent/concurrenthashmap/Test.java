package concurrent.concurrenthashmap;

import com.google.common.collect.Maps;

import java.util.concurrent.ConcurrentHashMap;

public class Test {

    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            concurrentHashMap.put("key" + i, i);
        }
        concurrentHashMap.size();

        Maps.newHashMapWithExpectedSize(10);
    }

}
