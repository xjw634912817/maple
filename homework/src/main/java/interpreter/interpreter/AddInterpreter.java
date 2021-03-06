package interpreter.interpreter;


import interpreter.IArithmeticInterpreter;

public class AddInterpreter extends Interpreter {

    public AddInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return super.left.interpreter() + super.right.interpreter();
    }
}
