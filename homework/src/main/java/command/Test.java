package command;

import command.commands.LoginCommand;
import command.commands.LogoutCommand;
import command.commands.UploadFileCommand;

public class Test {
    public static void main(String[] args) {
        FtpService ftpService = new FtpService();
        Console console = new Console();
        console.execute(new LoginCommand("test", "123", ftpService));
        console.execute(new UploadFileCommand(ftpService));
        console.execute(new LogoutCommand(ftpService));

        console.addCommands(new LoginCommand("test", "123", ftpService),
                new UploadFileCommand(ftpService),
                new LogoutCommand(ftpService));
        console.executes();
    }
}
