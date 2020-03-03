package designpattern.proxy.dynamicproxy.customproxy;

import designpattern.proxy.dynamicproxy.customproxy.client.CustomMeiPo;
import designpattern.proxy.dynamicproxy.customproxy.client.IEatable;
import designpattern.proxy.dynamicproxy.customproxy.client.IPerson;
import designpattern.proxy.dynamicproxy.customproxy.client.ZhangSan;

public class Test {

    public static void main(String[] args) throws Exception {
        CustomMeiPo meiPo = new CustomMeiPo();
        IPerson person = (IPerson) meiPo.getInstance(new ZhangSan());
        person.findLove();
        person.speak("啊啊啊");
        int result = person.add(1, 2);
        System.out.println(result);

        IEatable eatable = (IEatable) meiPo.getInstance(new ZhangSan());
        String evaluation = eatable.eat("菜");
        System.out.println(evaluation);
    }
}
