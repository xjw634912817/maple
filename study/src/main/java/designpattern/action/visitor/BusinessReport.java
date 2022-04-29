package designpattern.action.visitor;

import java.util.ArrayList;
import java.util.List;

public class BusinessReport {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void show(IVisitor iVisitor) {
        for (Employee employee : employees) {
            employee.accept(iVisitor);
        }
    }
}
