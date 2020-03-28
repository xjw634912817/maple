package designpattern.visitor;

public class Engineer extends Employee {
    private Long codeLines;

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public Long getCodeLines() {
        return codeLines;
    }

    public void setCodeLines(Long codeLines) {
        this.codeLines = codeLines;
    }
}
