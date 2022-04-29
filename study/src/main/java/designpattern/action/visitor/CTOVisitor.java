package designpattern.action.visitor;

public class CTOVisitor implements IVisitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("我是CTO，我要看工程师" + engineer.getName() + "的代码：" + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("我是CTO，我要看经理" + manager.getName() + "的产品：" + manager.getProduct());
    }
}
