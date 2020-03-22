package jvm;

public class StackOverFlowTest {
    static int count = 0;

    static void method() {
        System.out.println(count++);
        method();
    }

    public static void main(String[] args) {
        method();
    }

}
