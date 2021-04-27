import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        // foreach null object will cause NPE
        for (Object te : test.a) {
            if (te != null) {
                System.out.println("sadas");
            }
        }
        System.out.println("over");
    }

    static class Test {
        List<Object> a;
    }


}
