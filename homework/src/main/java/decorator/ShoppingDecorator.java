package decorator;

import java.util.List;

public class ShoppingDecorator extends FunctionModuleDecorator {

    public ShoppingDecorator(FunctionModule functionModule) {
        super(functionModule);
    }

    @Override
    List<String> getFunctionModules() {
        List<String> modules = functionModule.getFunctionModules();
        modules.add("商城模块");
        return modules;
    }

}
