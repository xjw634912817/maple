package designpattern.proxy.dynamicproxy.jdkproxy;


import designpattern.proxy.dynamicproxy.IPerson;

public class Test {

    public static void main(String[] args) {
        JDKMeiPo meiPo = new JDKMeiPo();
        IPerson person = (IPerson) meiPo.getInstance(new ZhangSan());
        person.findLove();
        person.speak("啊啊啊");
//        person.mySelfMethod();
    }
}
