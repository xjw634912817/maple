package interpreter;

import java.util.Stack;

public class Calculate {

    private Stack<IArithmeticInterpreter> stack = new Stack<>();

    public Calculate(String expression) {
        parse(expression);
    }

    private void parse(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            return;
        }
        String[] elements = expression.trim().split(" ");
        IArithmeticInterpreter left, right;
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            // 如果找到一个左括号，就找下一个右括号的位置，中间的字符串作为表达式 递归再做一次运算
            if (OperatorUtil.isLeftBracket(element)) {
                StringBuilder bracketExpression = new StringBuilder();
                element = elements[++i];
                while(!OperatorUtil.isRightBracket(element)) {
                    bracketExpression.append(element).append(" ");
                    element = elements[++i];
                }
                parse(bracketExpression.toString());
            } else if (OperatorUtil.isOperator(element)) {
                left = this.stack.pop();
                String operator = element;
                element = elements[++i];
                // 判断下一个元素是不是左括号，是就找下一个右括号的位置，中间的字符串作为表达式 优先做一次运算
                if (OperatorUtil.isLeftBracket(element)) {
                    StringBuilder bracketExpression = new StringBuilder();
                    // 从左括号后面一个字符开始判断
                    element = elements[++i];
                    while(!OperatorUtil.isRightBracket(element)) {
                        bracketExpression.append(element).append(" ");
                        element = elements[++i];
                    }
                    parse(bracketExpression.toString());
                    // 处理完后结果会在栈中 取出来做运算
                    right = this.stack.pop();
                    this.stack.push(OperatorUtil.getInterpreter(left, right, operator));
                } else {
                    // 不是括号直接计算
                    right = new NumberInterpreter(Integer.valueOf(element));
                    this.stack.push(OperatorUtil.getInterpreter(left, right, operator));
                }
            } else {
                NumberInterpreter numberInterpreter = new NumberInterpreter(Integer.valueOf(element));
                stack.push(numberInterpreter);
            }
        }
    }

    public Integer calculate() {
        return this.stack.pop().interpreter();
    }

}
