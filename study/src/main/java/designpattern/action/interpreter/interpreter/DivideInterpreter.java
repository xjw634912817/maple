package designpattern.action.interpreter.interpreter;

public class DivideInterpreter extends Interpreter {

    public DivideInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return super.left.interpreter() / super.right.interpreter();
    }
}
