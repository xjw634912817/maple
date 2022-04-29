package designpattern.action.interpreter.suffixexpression;


import designpattern.action.interpreter.OperatorEnum;
import designpattern.action.interpreter.OperatorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static designpattern.action.interpreter.OperatorEnum.LEFT_BRACKET;
import static designpattern.action.interpreter.OperatorEnum.RIGHT_BRACKET;

public class SuffixCalculate {
    // 计算后缀表达式的操作数栈
    private Stack<Integer> calculateStack = new Stack<>();

    // 中缀表达式转后缀表达式的操作数栈
    private Stack<OperatorEnum> operatorStack = new Stack<>();
    // 后缀表达式
    private List<Object> suffixExpression = new ArrayList<>();

    public SuffixCalculate(String expression) {
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
                        suffixExpression.add(operatorStack.pop());
                    }
                    operatorStack.pop();
                } else {
                    if (!operatorStack.empty() && operator.isPriorityLessThanEquals(operatorStack.peek())) {
                        suffixExpression.add(operatorStack.pop());
                    }
                    operatorStack.push(operator);
                }
            } else {
                suffixExpression.add(Integer.valueOf(element));
            }
        }

        while (!operatorStack.isEmpty()) {
            suffixExpression.add(operatorStack.pop());
        }

        for (Object o : suffixExpression) {
            if (o instanceof OperatorEnum) {
                Integer right = calculateStack.pop();
                Integer left = calculateStack.pop();
                int result = OperatorUtil.calculate(left, right, (OperatorEnum) o);
                calculateStack.push(result);
            } else {
                calculateStack.push((Integer) o);
            }
        }
    }

    public Integer calculate() {
        if (this.calculateStack.empty()) {
            return null;
        }
        return this.calculateStack.pop();
    }

}
