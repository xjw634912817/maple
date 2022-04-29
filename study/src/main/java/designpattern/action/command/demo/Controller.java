package designpattern.action.command.demo;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<IAction> actionList = new ArrayList<>();

    public void addAction(IAction action) {
        actionList.add(action);
    }

    public void execute(IAction action) {
        action.execute();
    }

    public void executes() {
        for (IAction iAction : actionList) {
            iAction.execute();
        }
        actionList.clear();
        System.out.println(actionList);
    }

}
