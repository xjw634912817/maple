package designpattern.action.observer.eventlisten.handler;

import designpattern.action.observer.eventlisten.core.Event;
import designpattern.action.observer.eventlisten.core.Listener;

public class MouseListener implements Listener {
    public void onClick(Event e) {
        System.out.println("==========触发鼠标单击回调事件========\n" + e);
    }

    public void onMove(Event e) {

        System.out.println("==========触发鼠标移动回调事件========\n" + e);
    }
}
