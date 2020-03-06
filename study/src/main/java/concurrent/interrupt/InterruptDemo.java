package concurrent.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    private static int i;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            // 默认是false
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("出循环了：" + i);
        });

        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

}
