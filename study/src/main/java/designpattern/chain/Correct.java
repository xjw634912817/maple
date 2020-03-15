package designpattern.chain;

public class Correct extends HandlerNode {
    @Override
    void handle() {
        System.out.println("校验密码是否正确");
        super.next.handle();
    }
}
