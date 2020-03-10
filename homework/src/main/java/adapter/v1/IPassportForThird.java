package adapter.v1;

import adapter.ResultMsg;

public interface IPassportForThird {
    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTel(String tel);
}
