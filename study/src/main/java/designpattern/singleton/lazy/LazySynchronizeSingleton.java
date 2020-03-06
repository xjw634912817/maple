package designpattern.singleton.lazy;

/**
 * 优点：线程安全、节省内存
 * 缺点：性能低
 */
public class LazySynchronizeSingleton {

    private static LazySynchronizeSingleton instance;

    private LazySynchronizeSingleton() {

    }

    public synchronized static LazySynchronizeSingleton getInstance() {
        if (instance == null) {
            instance = new LazySynchronizeSingleton();
        }
        return instance;
    }

}
