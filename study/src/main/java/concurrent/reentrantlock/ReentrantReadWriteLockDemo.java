package concurrent.reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    // 构造方法可传参 指定公平/非公平
    static ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReentrantReadWriteLock.ReadLock readLock = reentrantLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantLock.writeLock();
        readLock.lock();
        readLock.unlock();
        writeLock.lock();
        writeLock.unlock();
    }
}
