package designpattern.structure.decorator;

import java.util.List;

public class HomeWorkDecorator extends FunctionModuleDecorator {
    public HomeWorkDecorator(FunctionModule functionModule) {
        super(functionModule);
    }

    @Override
    List<String> getFunctionModules() {
        List<String> modules = functionModule.getFunctionModules();
        modules.add("作业模块");
        return modules;
    }
}
