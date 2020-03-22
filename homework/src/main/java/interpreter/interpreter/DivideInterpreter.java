package interpreter.interpreter;


import interpreter.IArithmeticInterpreter;

public class DivideInterpreter extends Interpreter {

    public DivideInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return super.left.interpreter() / super.right.interpreter();
    }
}
