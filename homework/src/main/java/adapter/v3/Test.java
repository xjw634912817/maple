package adapter.v3;

import adapter.ResultMsg;
import adapter.v3.adapters.LoginForQQAdapter;
import adapter.v3.adapters.LoginForWechatAdapter;

public class Test {
    public static void main(String[] args) {
        IPassportForThird adapt = new PassportForThirdAdapt();
        ResultMsg resultMsg1 = adapt.loginForThird(new LoginForQQAdapter("asdasdsadsad"));
        System.out.println(resultMsg1);
        ResultMsg resultMsg2 = adapt.loginForThird(new LoginForWechatAdapter("asdasdsadsad"));
        System.out.println(resultMsg2);
    }
}
