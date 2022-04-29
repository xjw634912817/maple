package concurrent.waitnotify.demo1;

/**
 * 5.1 为什么在while循环中包含wait（）？
 * 由于notify（）和notifyAll（）随机唤醒正在此对象监视器上等待的线程，因此满足条件并不总是很重要。
 * 有时可能会发生线程被唤醒，但实际上并没有满足条件。
 * <p>
 * 我们还可以定义一个检查来避免虚假的唤醒 - 一个线程可以在没有收到通知的情况下从等待中醒来。
 */
public class Data {

    private String packet;

    // true if receiver should wait
    // false if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            System.out.println("send wait begin");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("send wait end");
        }

        System.out.println("send get ouf of the loop");
        transfer = false;
        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            System.out.println("receive wait begin");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("receive wait end");
        }
        System.out.println("receive get ouf of the loop");
        transfer = true;

        notifyAll();
        return packet;
    }

}
