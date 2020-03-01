package singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 优点：不会造成内存浪费、线程安全
 * 疑问：ioc需不需要加volatile关键字
 */
public class ContainerDoubleCheckSingleton {

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    private ContainerDoubleCheckSingleton(){

    }

    public static Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!ioc.containsKey(className)) {
            synchronized (ContainerDoubleCheckSingleton.class) {
                if (!ioc.containsKey(className)) {
                    Object o = Class.forName(className).newInstance();
                    ioc.put(className, o);
                    return o;
                }
            }
        }
        return ioc.get(className);

    }

}
