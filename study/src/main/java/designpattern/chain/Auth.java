package designpattern.chain;

public class Auth extends HandlerNode {
    @Override
    void handle() {
        System.out.println("校验权限");
    }
}
