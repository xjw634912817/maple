package designpattern.action.command.ftp.commands;


import designpattern.action.command.ftp.FtpService;

public class LoginCommand implements ICommand {

    private String username;
    private String password;
    private FtpService ftpService;

    public LoginCommand(String username, String password, FtpService ftpService) {
        this.username = username;
        this.password = password;
        this.ftpService = ftpService;
    }

    @Override
    public void execute() {
        ftpService.login(this.username, this.password);
    }
}
