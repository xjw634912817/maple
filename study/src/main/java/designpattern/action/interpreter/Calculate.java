package designpattern.action.interpreter;

import designpattern.action.interpreter.interpreter.IArithmeticInterpreter;
import designpattern.action.interpreter.interpreter.NumberInterpreter;

import java.util.Objects;
import java.util.Stack;

import static designpattern.action.interpreter.OperatorEnum.LEFT_BRACKET;
import static designpattern.action.interpreter.OperatorEnum.RIGHT_BRACKET;


public class Calculate {

    private Stack<IArithmeticInterpreter> numberStack = new Stack<>();
    private Stack<OperatorEnum> operatorStack = new Stack<>();

    public Calculate(String expression) {
        parse(expression);
    }

    private void parse(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            return;
        }
        String[] elements = expression.trim().split(" ");
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            if (OperatorUtil.isOperator(element)) {
                OperatorEnum operator = OperatorUtil.getOperatorEnumByOperator(element);
                if (operator == null) {
                    throw new RuntimeException("无法识别的运算符");
                }
                if (Objects.equals(operator, LEFT_BRACKET)) {
                    operatorStack.push(operator);
                } else if (Objects.equals(operator, RIGHT_BRACKET)) {
                    while (operatorStack.peek() != LEFT_BRACKET) {
                        OperatorUtil.calculate(numberStack, operatorStack);
                    }
                    operatorStack.pop();
                } else {
                    if (!operatorStack.empty() && operator.isPriorityLessThanEquals(operatorStack.peek())) {
                        OperatorUtil.calculate(numberStack, operatorStack);
                    }
                    operatorStack.push(operator);
                }
            } else {
                numberStack.push(new NumberInterpreter(Integer.valueOf(element)));
            }
        }

        while (!operatorStack.isEmpty()) {
            OperatorUtil.calculate(numberStack, operatorStack);
        }
    }

    public Integer calculate() {
        if (this.numberStack.empty()) {
            return null;
        }
        return this.numberStack.pop().interpreter();
    }

}
