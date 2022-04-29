package designpattern.action.command.ftp;

public class FtpService {

    public void login(String username, String password) {
        System.out.println("校验账户密码");
        System.out.println(username);
        System.out.println(password);
    }

    public void uploadFile() {
        System.out.println("上传文件");
    }

    public void logout() {
        System.out.println("退出");
    }

}
