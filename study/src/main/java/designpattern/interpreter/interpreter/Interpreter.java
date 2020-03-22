package designpattern.interpreter.interpreter;

import designpattern.interpreter.IArithmeticInterpreter;

/**
 * 非终结表达式
 */
public abstract class Interpreter implements IArithmeticInterpreter {
    protected IArithmeticInterpreter left;
    protected IArithmeticInterpreter right;

    public Interpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        this.left = left;
        this.right = right;
    }
}
