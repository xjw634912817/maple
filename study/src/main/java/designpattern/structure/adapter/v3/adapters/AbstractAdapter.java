package designpattern.structure.adapter.v3.adapters;


import designpattern.structure.adapter.PassportService;
import designpattern.structure.adapter.ResultMsg;

public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {

    protected ResultMsg registerAndLogin(String username, String password) {
        if (null == password) {
            password = "defaultPassword";
        }
        super.regist(username, password);
        return super.login(username, password);
    }
}
