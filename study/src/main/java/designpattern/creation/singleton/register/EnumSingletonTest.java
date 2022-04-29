package designpattern.creation.singleton.register;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;

public class EnumSingletonTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        EnumSingleton.getInstance().setCustomField("123123");
        Object customField = EnumSingleton.INSTANCE.getCustomField();
        System.out.println(customField);
        // valueOf method: java.lang.Enum.java:230
        System.out.println(EnumSingleton.valueOf("INSTANCE").getCustomField());
        System.out.println(EnumSingleton.valueOf("INSTANCE").getCustomField());

        // EnumSingleton can declare own custom method
        EnumSingleton.INSTANCE.test();

        verifyEnumCanNotBeCreatedByReflect();
    }

    private static void verifyEnumCanNotBeCreatedByReflect() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // Enum Constructor Code: java.lang.Enum.java:117
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        // java.lang.reflect.Constructor.java:417
        // Throw an exception: Cannot reflectively create enum objects
        EnumSingleton newInstance = declaredConstructor.newInstance();
        System.out.println(newInstance);
    }
}
