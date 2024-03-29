package designpattern.structure.proxy.dynamicproxy.jdkproxy;


import designpattern.structure.proxy.dynamicproxy.IPerson;

public class LiSi implements IPerson {
    @Override
    public void findLove() {
        System.out.println("李四要求");
    }

    @Override
    public void speak(String text) {
        System.out.println("李四说：" + text);
    }
}
