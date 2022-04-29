package designpattern.creation.singleton.serializable;

import java.io.Serializable;

/**
 * 如何解决反序列化破坏单例
 */
public class SerializableSingleton implements Serializable {

    private static final SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton() {

    }

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 用到了桥接模式
     */
    private Object readResolve() {
        return INSTANCE;
    }

}
