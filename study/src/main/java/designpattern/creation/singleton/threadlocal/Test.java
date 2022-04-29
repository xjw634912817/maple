package designpattern.creation.singleton.threadlocal;

public class Test {
    public static void main(String[] args) {
        ThreadLocalSingleton threadLocalSingleton = ThreadLocalSingleton.getInstance();
        ThreadLocalSingleton threadLocalSingleton2 = ThreadLocalSingleton.getInstance();
        System.out.println(threadLocalSingleton == threadLocalSingleton2);
    }
}
