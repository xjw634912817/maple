package designpattern.action.visitor;

public abstract class Employee {
    protected String name;
    protected String kpi;

    public Employee(String name) {
        this.name = name;
    }

    public String getKpi() {
        return kpi;
    }

    public void setKpi(String kpi) {
        this.kpi = kpi;
    }

    public String getName() {
        return name;
    }

    // 接收访问者的访问
    public abstract void accept(IVisitor visitor);
}
