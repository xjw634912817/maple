package designpattern.observer.eventlisten;

import designpattern.observer.eventlisten.core.EventType;
import designpattern.observer.eventlisten.handler.Mouse;
import designpattern.observer.eventlisten.handler.MouseListener;

public class Test {

    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        MouseListener mouseListener = new MouseListener();

        mouse.addListener(EventType.CLICK, mouseListener);
        mouse.addListener(EventType.MOVE, mouseListener);

        mouse.click();
        mouse.move();
    }

}
