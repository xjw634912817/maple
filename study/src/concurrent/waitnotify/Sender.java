package concurrent.waitnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String[] packets = {
          "First packet",
          "Second packet",
          "Third packet",
          "End"
        };

        for (String packet : packets) {
            System.out.println("Sender is sending packet");
            data.send(packet);
            System.out.println("Sender is sending packet end");

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
