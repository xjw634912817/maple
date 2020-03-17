package designpattern.command;

public class StopAction implements IAction {

    private Player player;

    public StopAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.stop();
    }
}
