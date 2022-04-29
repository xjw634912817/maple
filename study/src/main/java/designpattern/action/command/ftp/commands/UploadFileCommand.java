package designpattern.action.command.ftp.commands;


import designpattern.action.command.ftp.FtpService;

public class UploadFileCommand implements ICommand {

    private FtpService ftpService;

    public UploadFileCommand(FtpService ftpService) {
        this.ftpService = ftpService;
    }

    @Override
    public void execute() {
        ftpService.uploadFile();
    }
}
