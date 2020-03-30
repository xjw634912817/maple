package designpattern.singleton.lazy;

/**
 * 优点：线程安全、节省内存
 * 缺点：不够优雅
 */
public class DoubleCheckSingleton {

    // 存在指令重排序的问题 用volatile修饰的变量，相关操作不会进行指令重排序，所修改的值也会马上写入主存
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    // 存在指令重排序的问题
                    // new一个对象在指令层面非原子性操作
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
