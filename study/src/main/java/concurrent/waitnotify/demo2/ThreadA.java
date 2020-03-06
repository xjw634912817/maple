package concurrent.waitnotify.demo2;

public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开启线程A");
            try {
                // wait会阻塞 然后释放锁
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束线程A");
        }
    }
}
