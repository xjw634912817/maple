package interpreter;

import interpreter.interpreter.*;

public class OperatorUtil {
    public static boolean isOperator(String symbol) {
        return "+".equals(symbol) || "-".equals(symbol)
                || "*".equals(symbol) || "/".equals(symbol);
    }

    public static boolean isLeftBracket(String symbol) {
        return "(".equals(symbol);
    }

    public static boolean isRightBracket(String symbol) {
        return ")".equals(symbol);
    }

    public static Interpreter getInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right, String symbol) {
        switch (symbol) {
            case "+":
                return new AddInterpreter(left, right);
            case "-":
                return new SubtractInterpreter(left, right);
            case "*":
                return new MultiplyInterpreter(left, right);
            case "/":
                return new DivideInterpreter(left, right);
            default:
                return null;
        }
    }

}
