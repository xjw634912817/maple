package designpattern.structure.adapter.v2;

import designpattern.structure.adapter.ResultMsg;

public class Test {
    public static void main(String[] args) {
        IPassportForThird adapt = new PassportForThirdAdapt();
        ResultMsg resultMsg1 = adapt.loginForQQ("asdasdsadsad");
        System.out.println(resultMsg1);
        ResultMsg resultMsg2 = adapt.loginForWechat("asdasdsadsad");
        System.out.println(resultMsg2);
    }
}
