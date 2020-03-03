package designpattern.proxy.dynamicproxy.jdkproxy;


import designpattern.proxy.dynamicproxy.IPerson;

public class ZhangSan implements IPerson {
    @Override
    public void findLove() {
        System.out.println("张三要求");
    }

    @Override
    public void speak(String text) {
        System.out.println("张三说：" + text);
    }

    public void mySelfMethod() {

    }
}
