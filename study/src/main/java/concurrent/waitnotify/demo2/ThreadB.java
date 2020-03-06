package concurrent.waitnotify.demo2;

public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开启线程B");
            lock.notify();  // 唤醒被阻塞的线程
            System.out.println("结束线程B");
        }
    }
}
