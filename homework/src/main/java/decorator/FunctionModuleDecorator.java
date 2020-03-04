package decorator;

public abstract class FunctionModuleDecorator extends FunctionModule {
    protected FunctionModule functionModule;

    public FunctionModuleDecorator(FunctionModule functionModule) {
        this.functionModule = functionModule;
    }
}
