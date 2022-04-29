package designpattern.action.visitor;

public class Manager extends Employee {
    private String product;

    public Manager(String name) {
        super(name);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
