package adapter;

public class PassportService {
    public ResultMsg regist(String username, String password){
        return new ResultMsg(200, "注册成功", null);
    }

    public ResultMsg login(String username, String password){
        return new ResultMsg(200, "登录成功", null);
    }
}
