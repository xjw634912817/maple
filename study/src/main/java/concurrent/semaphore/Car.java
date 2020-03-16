package concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class Car extends Thread {
    private int index;
    private Semaphore semaphore;

    public Car(int index, Semaphore semaphore) {
        this.index = index;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // 获取令牌，没有令牌就阻塞
            System.out.printf("第{%d}个车获得车位\n", index);
            Thread.sleep(2000);
            System.out.printf("第{%d}个车开走了\n", index);
            semaphore.release(); // 释放令牌

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Car(i, semaphore).start();
        }
    }

}
