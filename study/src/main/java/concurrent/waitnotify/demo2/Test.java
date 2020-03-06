package concurrent.waitnotify.demo2;

public class Test {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);
        threadA.start();
        threadB.start();
    }

}
