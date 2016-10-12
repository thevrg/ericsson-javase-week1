package hu.dpc.edu.interpreter.longexpr;

import hu.dpc.edu.interpreter.EvaluationContext;
import hu.dpc.edu.interpreter.LongExpression;

/**
 *
 * @author vrg
 */
public class Subtract extends LongExpression {

    private LongExpression operand1;
    private LongExpression operand2;

    public Subtract(LongExpression operand1, LongExpression operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    
    @Override
    public Long evaluate(EvaluationContext context) {
        Long operand1Value = operand1.evaluate(context);
        Long operand2Value = operand2.evaluate(context);
        return operand1Value - operand2Value;
    }
    
}
