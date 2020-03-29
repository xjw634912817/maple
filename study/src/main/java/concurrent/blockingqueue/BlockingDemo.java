package concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 插入元素：add() 非阻塞，队列满抛异常
 *           offer() 非阻塞，返回true/falsae
 *           put() 阻塞，队列满阻塞
 * 删除元素：remove() 删除队列中对应的Object
 * 获取元素：poll() 非阻塞，队列为空返回null
 *           take() 阻塞，队列为空阻塞
 */
public class BlockingDemo {
    ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

    {
        init();
    }

    void init () {
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("take前");
                    // 阻塞式获取
                    String take = arrayBlockingQueue.take();
                    System.out.println("receive：" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    void add(String data) {
        arrayBlockingQueue.add(data);
        System.out.println("send data:" + data);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingDemo blockingDemo = new BlockingDemo();
        for (int i = 0; i < 20; i++) {
            blockingDemo.add("i" + i);
        }
    }
    
    
}
