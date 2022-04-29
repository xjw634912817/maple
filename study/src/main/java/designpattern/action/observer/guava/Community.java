package designpattern.action.observer.guava;

import com.google.common.eventbus.Subscribe;

public class Community {


    @Subscribe
    public void listenQuestion(String s) {
        System.out.println(s);
    }

}
