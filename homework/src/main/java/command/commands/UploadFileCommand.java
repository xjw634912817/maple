package command.commands;

import command.FtpService;

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
