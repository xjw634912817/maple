package designpattern.structure.decorator;

public class Test {
    public static void main(String[] args) {
        FunctionModule functionModule = new BaseFunctionModule();
        System.out.println("基础模块：" + functionModule.getFunctionModules());

        functionModule = new HomeWorkDecorator(functionModule);
        System.out.println("加了作业模块：" + functionModule.getFunctionModules());

        functionModule = new ShoppingDecorator(functionModule);
        System.out.println("加了商城模块：" + functionModule.getFunctionModules());
    }
}
