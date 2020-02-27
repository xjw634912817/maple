package singleton.hungry;

/**
 * 优点：执行效率高、线程安全
 * 缺点：容易造成内存浪费
 * 类加载顺序：先静态后动态   先上后下  先属性后方法
 */
public class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

}
