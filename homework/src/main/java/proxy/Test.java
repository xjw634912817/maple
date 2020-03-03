package proxy;


import proxy.client.CustomMeiPo;
import proxy.client.IEatable;
import proxy.client.IPerson;
import proxy.client.ZhangSan;

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
