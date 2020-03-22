package interpreter;


/**
 * 终结表达式
 */
public class NumberInterpreter implements IArithmeticInterpreter {
    private Integer value;

    public NumberInterpreter(Integer value) {
        this.value = value;
    }

    @Override
    public int interpreter() {
        return value;
    }
}
