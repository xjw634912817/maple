package designpattern.creation.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 优点：不会造成内存浪费
 * 缺点：线程不安全
 */
public class ContainerSingleton {

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    private ContainerSingleton() {

    }

    public static Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!ioc.containsKey(className)) {
            Object o = Class.forName(className).newInstance();
            ioc.put(className, o);
            return o;
        }
        return ioc.get(className);

    }

}
