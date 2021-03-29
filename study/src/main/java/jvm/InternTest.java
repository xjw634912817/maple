package jvm;

public class InternTest {

    public static void main(String[] args) {
        String st1 = new StringBuilder("hello").append("world").toString();
        System.out.println(st1.intern());
        System.out.println(st1 == st1.intern());
        System.out.println(System.identityHashCode(st1));
        System.out.println(System.identityHashCode(st1.intern()));
        System.out.println("=============");

        String st2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(st2.intern());
        System.out.println(st2 == st2.intern());
        System.out.println(System.identityHashCode(st2));
        System.out.println(System.identityHashCode(st2.intern()));
        System.out.println("=============");

        String st3 = new StringBuilder("hello").toString();
        System.out.println(st3.intern());
        System.out.println(st3 == st3.intern());
        System.out.println(System.identityHashCode(st3));
        System.out.println(System.identityHashCode(st3.intern()));
        System.out.println("=============");
        
        String st4 = new String("jeremy_test");
        System.out.println(st4 == st4.intern());
        System.out.println(System.identityHashCode(st4));
        System.out.println(System.identityHashCode(st4.intern()));
    }
    
}
