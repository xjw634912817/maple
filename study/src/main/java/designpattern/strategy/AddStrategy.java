package designpattern.strategy;

public class AddStrategy implements IStrategy {

    @Override
    public double doingSomething(double a, double b) {
        return a + b;
    }
}
