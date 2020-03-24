package designpattern.observer.guava;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        eventBus.register(new Community());
        eventBus.register(new Teacher());

        eventBus.post("aaaaaaa");
    }
}
