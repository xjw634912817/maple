package designpattern.creation.singleton.lazy;

/**
 * 优点：线程安全、节省内存、写法优雅
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {

    }

    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClassSingletonHolder.INSTANCE;
    }

    private static class StaticInnerClassSingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

}
