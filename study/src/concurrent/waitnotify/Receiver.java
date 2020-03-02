package concurrent.waitnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {

    private Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for (String receiveMessage = load.receive(); !"End".equals(receiveMessage); receiveMessage = load.receive()) {
            System.out.println(receiveMessage);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
