package observer;

import com.google.common.eventbus.Subscribe;

public class Teacher {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Subscribe
    public void listenQuestion(Question question) {
        System.out.println("我是老师：" + name);
        System.out.println(question);
    }
}
