package designpattern.visitor;

public class CEOVisitor implements IVisitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("我是CEO，我要看工程师" + engineer.getName() + "的kpi：" + engineer.getKpi());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("我是CEO，我要看经理" + manager.getName() + "的kpi：" + manager.getKpi());
    }
}
