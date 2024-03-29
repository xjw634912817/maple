package designpattern.structure.adapter.v2.adapters;

import designpattern.structure.adapter.PassportService;
import designpattern.structure.adapter.ResultMsg;

public class AbstractAdapter extends PassportService implements ILoginAdapter {
    @Override
    public boolean support(Object object) {
        return false;
    }

    @Override
    public ResultMsg processLogin(String id, Object adapter) {
        return null;
    }

    protected ResultMsg registerAndLogin(String username, String password) {
        if (null == password) {
            password = "defaultPassword";
        }
        super.regist(username, password);
        return super.login(username, password);
    }
}
