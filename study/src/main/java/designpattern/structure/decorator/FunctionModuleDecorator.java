package designpattern.structure.decorator;

import java.util.List;

public class FunctionModuleDecorator extends FunctionModule {
    protected FunctionModule functionModule;

    public FunctionModuleDecorator(FunctionModule functionModule) {
        this.functionModule = functionModule;
    }

    @Override
    List<String> getFunctionModules() {
        return functionModule.getFunctionModules();
    }
}
