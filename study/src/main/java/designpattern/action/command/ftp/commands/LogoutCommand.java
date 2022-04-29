package designpattern.action.command.ftp.commands;


import designpattern.action.command.ftp.FtpService;

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
