package designpattern.structure.adapter.v2;

import designpattern.structure.adapter.ResultMsg;

public interface IPassportForThird {
    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTel(String tel);

}
