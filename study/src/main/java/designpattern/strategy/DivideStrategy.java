package designpattern.strategy;

public class DivideStrategy implements IStrategy {

    @Override
    public double doingSomething(double a, double b) {
        return a / b;
    }
}
