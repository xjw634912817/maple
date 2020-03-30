package designpattern.interpreter;

import designpattern.interpreter.interpreter.*;

import java.util.Objects;
import java.util.Stack;

public class OperatorUtil {
    public static boolean isOperator(String operator) {
        OperatorEnum[] values = OperatorEnum.values();
        for (OperatorEnum value : values) {
            if (Objects.equals(operator, value.getOperator())) {
                return true;
            }
        }
        return false;
    }

    public static OperatorEnum getOperatorEnumByOperator(String operator) {
        OperatorEnum[] values = OperatorEnum.values();
        for (OperatorEnum value : values) {
            if (Objects.equals(operator, value.getOperator())) {
                return value;
            }
        }
        return null;
    }

    public static void calculate(Stack<IArithmeticInterpreter> numberStack, Stack<OperatorEnum> operatorStack) {
        IArithmeticInterpreter right = numberStack.pop();
        IArithmeticInterpreter left = numberStack.pop();
        OperatorEnum operatorEnum = operatorStack.pop();
        switch (operatorEnum) {
            case ADD:
                numberStack.push(new AddInterpreter(left, right));
                return;
            case SUBTRACT:
                numberStack.push(new SubtractInterpreter(left, right));
                return;
            case MULTIPLY:
                numberStack.push(new MultiplyInterpreter(left, right));
                return;
            case DIVIDE:
                numberStack.push(new DivideInterpreter(left, right));
                return;
            default:
        }
    }

    public static int calculate(Integer left, Integer right, OperatorEnum operatorEnum) {
        switch (operatorEnum) {
            case ADD:
                return left + right;
            case SUBTRACT:
                return left - right;
            case MULTIPLY:
                return left * right;
            case DIVIDE:
                return left / right;
            default:
        }
        return 0;
    }

}
