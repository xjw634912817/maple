package observer;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        eventBus.register(new Teacher("test1"));
        eventBus.register(new Teacher("test2"));

        eventBus.post(new Question("student", "观察者模式我不会"));
    }
}
