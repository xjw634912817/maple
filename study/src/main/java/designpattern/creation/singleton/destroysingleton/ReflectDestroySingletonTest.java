package designpattern.creation.singleton.destroysingleton;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

public class ReflectDestroySingletonTest {

    @SneakyThrows
    public static void main(String[] args) {
        Constructor<ReflectDestroySingleton> constructor = ReflectDestroySingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ReflectDestroySingleton instance1 = constructor.newInstance();
        ReflectDestroySingleton instance2 = constructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }
}
