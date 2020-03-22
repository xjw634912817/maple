package designpattern.interpreter.interpreter;

import designpattern.interpreter.IArithmeticInterpreter;

public class MultiplyInterpreter extends Interpreter {

    public MultiplyInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return super.left.interpreter() * super.right.interpreter();
    }
}