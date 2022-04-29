package designpattern.action.visitor;

public class Test {
    public static void main(String[] args) {
        IVisitor ceo = new CEOVisitor();
        IVisitor cto = new CTOVisitor();

        Engineer engineer = new Engineer("程序猿");
        engineer.setCodeLines(2000L);
        engineer.setKpi("1");
        Manager manager = new Manager("产品经理");
        manager.setProduct("完美");
        manager.setKpi("2");

        BusinessReport businessReport = new BusinessReport();
        businessReport.addEmployee(engineer);
        businessReport.addEmployee(manager);

        businessReport.show(ceo);
        businessReport.show(cto);
    }
}
