package hu.dpc.edu.interpreter.longexpr;

import hu.dpc.edu.interpreter.EvaluationContext;
import hu.dpc.edu.interpreter.LongExpression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vrg
 */
public class Multiply extends LongExpression {

    private List<LongExpression>operands = new ArrayList<>();

    public Multiply(LongExpression... operands) {
        this.operands.addAll(Arrays.asList(operands));
    }
    
    @Override
    public Long evaluate(EvaluationContext context) {
        long sum = 1;
        for (LongExpression operandExpression : operands) {
            Long operandValue = operandExpression.evaluate(context);
            sum *= operandValue;
        }
        return sum;
    }
    
}
