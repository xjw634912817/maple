package designpattern.observer.eventlisten.handler;

import designpattern.observer.eventlisten.core.EventType;
import designpattern.observer.eventlisten.core.Observable;

public class Mouse extends Observable {
    public void click() {
        System.out.println("鼠标被单击");
        this.trigger(EventType.CLICK);
    }

    public void move() {
        System.out.println("鼠标移动");
        this.trigger(EventType.MOVE);
    }
}
