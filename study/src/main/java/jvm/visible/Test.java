package jvm.visible;

public class Test {

    boolean done = false;
    int a = 0;
    int b = 0;

    void f1() {
        while (!done) {
            a++;
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("go out : " + a);
    }

    void f2() {
        done = true;
    }

    void f3() {
        // nothing
    }


    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        new Thread(test::f1).start();
        Thread.sleep(1000);
        new Thread(test::f2).start();
    }

}
