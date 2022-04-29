package designpattern.structure.proxy.dynamicproxy.customproxy.client;


public class ZhangSan implements IPerson, IEatable {
    @Override
    public void findLove() {
        System.out.println("张三要求");
    }

    @Override
    public void speak(String text) {
        System.out.println("张三说：" + text);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    public void mySelfMethod() {

    }

    @Override
    public String eat(String food) {
        System.out.println("eat:" + food);
        return "good";
    }
}
