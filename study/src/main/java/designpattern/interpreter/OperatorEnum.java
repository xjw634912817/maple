package designpattern.interpreter;

public enum OperatorEnum {
    ADD("+", 2), SUBTRACT("-", 2), MULTIPLY("*", 3), DIVIDE("/", 3), LEFT_BRACKET("(", 1), RIGHT_BRACKET(")", 1);

    private String operator;
    private Integer priority;

    public String getOperator() {
        return operator;
    }

    public Integer getPriority() {
        return priority;
    }

    OperatorEnum(String operator, Integer priority) {
        this.operator = operator;
        this.priority = priority;
    }

    boolean isPriorityLessThanEquals(OperatorEnum dest) {
        return this.getPriority() <= dest.getPriority();
    }

}
