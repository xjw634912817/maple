package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 extends Thread {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new CountDownLatchDemo2().start();
        }
        System.out.println("CountDown前");
        countDownLatch.countDown();
        System.out.println("CountDown后");
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始执行线程" + this.getName());
    }
}
