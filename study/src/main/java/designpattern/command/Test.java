package designpattern.command;

public class Test {

    public static void main(String[] args) {
        // 解耦真实执行者与请求方
        Player player = new Player();
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));
        controller.execute(new StopAction(player));

        // 支持命令宏
        controller.addAction(new StopAction(player));
        controller.addAction(new PlayAction(player));
        controller.executes();
    }
}
