package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {

    private static AtomicInteger ai = new AtomicInteger(0);
    private static Map<KeyTest, Integer> map = new HashMap<KeyTest, Integer>(1);


    public static void main(String[] args) {
//        HashMap hashMap = new HashMap(64);
//        hashMap.put(new KeyTest(), 1);
//        hashMap.get("1");

//        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMapWithExpectedSize(96);
//        objectObjectHashMap.put(1, 1);

        for (int i = 0; i < 50; i++) {
            new HashMapThread(ai, map).start();
        }
    }

    private static class KeyTest {
        private String name;

        @Override
        public int hashCode() {
            return 1;
        }
    }

    static class HashMapThread extends Thread {
        private AtomicInteger ai;
        private Map<KeyTest, Integer> map;

        HashMapThread(AtomicInteger ai, Map<KeyTest, Integer> map) {
            this.ai = ai;
            this.map = map;
        }

        @Override
        public void run() {
            while (ai.get() < 1000) {
                map.put(new KeyTest(), ai.get());
                ai.incrementAndGet();
            }
            System.out.println(Thread.currentThread().getName() + "执行结束完");
        }
    }

}

