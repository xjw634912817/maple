package command;

import command.commands.ICommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Console {
    private List<ICommand> commands = new ArrayList<>();

    public void execute(ICommand command) {
        command.execute();
    }

    public void addCommands(ICommand... commands) {
        if (commands == null || commands.length == 0) {
            return;
        }
        this.commands.addAll(Arrays.asList(commands));
    }

    public void executes() {
        System.out.println("===============执行命令宏==============");
        for (ICommand command : this.commands) {
            command.execute();
        }
        this.commands.clear();
        System.out.println("=============执行命令宏结束==============");
    }
}
