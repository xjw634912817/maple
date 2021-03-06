package interpreter.interpreter;


import interpreter.IArithmeticInterpreter;

public class SubtractInterpreter extends Interpreter {

    public SubtractInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return super.left.interpreter() - super.right.interpreter();
    }
}
