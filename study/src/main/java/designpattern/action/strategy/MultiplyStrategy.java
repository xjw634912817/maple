package designpattern.action.strategy;

public class MultiplyStrategy implements IStrategy {

    @Override
    public double doingSomething(double a, double b) {
        return a * b;
    }
}
