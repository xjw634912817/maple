package designpattern.creation.singleton.destroysingleton;

import java.io.ObjectInputStream;
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
     * 用到了桥接模式，防止序列化，反序列化破坏单例
     * @see ObjectInputStream#readObject()
     * @see ObjectInputStream#readObject0(Class, boolean)
     * @see ObjectInputStream#readOrdinaryObject(boolean)
     * @see java.io.ObjectStreamClass#invokeReadResolve(Object)
     */
    private Object readResolve() {
        return INSTANCE;
    }

}
