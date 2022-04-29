package designpattern.action.observer.guava;

import com.google.common.eventbus.Subscribe;

public class Teacher {
    @Subscribe
    public void listenQuestion(Question question) {
        System.out.println(question);
    }
}
