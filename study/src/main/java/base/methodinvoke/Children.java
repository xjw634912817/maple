package base.methodinvoke;

public class Children extends Parent {

    static String childrenProperty;
    String childrenProperty2;

    @Override
    void parentMethod1() {
        super.parentMethod1();
        System.out.println("override method 1");
    }
}
