package designpattern.action.observer.eventlisten.core;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Observable {
    private Multimap<EventType, Event> multimap = ArrayListMultimap.create();

    public void addListener(EventType eventType, Listener listener, Method callback) {
        multimap.put(eventType, new Event(listener, callback));
    }

    public void addListener(EventType eventType, Listener listener) {
        Method callback = null;
        try {
            callback = listener.getClass().getMethod("on" + toUpperFirstCase(eventType.name()), Event.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        multimap.put(eventType, new Event(listener, callback));
    }

    private String toUpperFirstCase(String eventType) {
        eventType = eventType.toLowerCase();
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return new String(chars);
    }

    protected void trigger(EventType eventType) {
        if (!multimap.containsKey(eventType)) {
            return;
        }
        for (Event event : multimap.get(eventType)) {
            event.setTrigger(eventType.name());
            event.setSource(this);
            event.setTime(System.currentTimeMillis());
            trigger(event);
        }
    }

    private void trigger(Event event) {
        if (event.getCallback() == null) {
            return;
        }
        try {
            event.getCallback().invoke(event.getTarget(), event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
