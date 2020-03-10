package adapter.v1;

import adapter.PassportService;
import adapter.ResultMsg;

public class PassportForThirdAdapt extends PassportService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String openId) {
        return registAndLogin(openId, null);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return registAndLogin(openId, null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return registAndLogin(token, null);
    }

    @Override
    public ResultMsg loginForTel(String tel) {
        return registAndLogin(tel, null);
    }

    private ResultMsg registAndLogin(String username, String password) {
        if (null == password) {
            password = "defaultPassword";
        }
        super.regist(username, password);
        return super.login(username, password);
    }
}
