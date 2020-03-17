package command.commands;

import command.FtpService;

public class LogoutCommand implements ICommand {

    private FtpService ftpService;

    public LogoutCommand(FtpService ftpService) {
        this.ftpService = ftpService;
    }

    @Override
    public void execute() {
        ftpService.logout();
    }
}
