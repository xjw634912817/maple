package designpattern.action.chain;

public class Empty extends HandlerNode {
    @Override
    void handle() {
        System.out.println("空校验");
        super.next.handle();
    }
}
