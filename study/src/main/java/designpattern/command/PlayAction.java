package designpattern.command;

public class PlayAction implements IAction {

    private Player player;

    public PlayAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
