package designpattern.action.strategy;

public class Test {
    public static void main(String[] args) {
        System.out.println(StrategyFactory.getKeys());
        IStrategy iStrategy = StrategyFactory.getStrategy("MULTIPLY");
        System.out.println(iStrategy.doingSomething(5, 2));
    }
}
