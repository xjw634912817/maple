package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println("线程1");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("线程2");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("线程3");
            countDownLatch.countDown();
        }).start();
        System.out.println("准备await");
        countDownLatch.await();
        System.out.println("await结束");

    }

}
