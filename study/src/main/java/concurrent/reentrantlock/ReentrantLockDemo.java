package concurrent.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    // 构造方法可传参 指定公平/非公平 默认非公平
    static ReentrantLock reentrantLock = new ReentrantLock();

    static void test() {
        if(reentrantLock.tryLock()) {
            // 这行不能写代码 确保一定要释放锁
            try {
                // doSomeThing
            } finally {
                // 确保一定要释放锁
                reentrantLock.unlock();
            }
        } else {
            // 没拿到锁看要做什么处理
        }

    }

    public static void main(String[] args) {
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
