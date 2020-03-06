package concurrent.waitnotify.demo1;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));
        sender.start();
        receiver.start();
    }
}
