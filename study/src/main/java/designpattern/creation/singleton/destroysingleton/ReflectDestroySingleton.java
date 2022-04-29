package designpattern.creation.singleton.destroysingleton;

public class ReflectDestroySingleton {

    private static ReflectDestroySingleton reflectDestroySingleton = new ReflectDestroySingleton();

    private ReflectDestroySingleton() {
        // protect singleton
        if (reflectDestroySingleton != null) {
            throw new RuntimeException("Class A is a singleton class");
        }
    }

    public static ReflectDestroySingleton getInstance() {
        return reflectDestroySingleton;
    }
}
