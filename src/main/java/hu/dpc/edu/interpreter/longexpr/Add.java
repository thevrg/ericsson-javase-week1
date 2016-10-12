package hu.dpc.edu.interpreter.longexpr;

import hu.dpc.edu.interpreter.EvaluationContext;
import hu.dpc.edu.interpreter.LongExpression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author vrg
 */
public class Add extends LongExpression {

    private List<LongExpression>operands = new ArrayList<>();

    public Add(LongExpression... operands) {

        this.operands.addAll(Arrays.asList(operands));
    }
    
    @Override
    public Long evaluate(EvaluationContext context) {
        long sum = 0;
        for (LongExpression operandExpression : operands) {
            Long operandValue = operandExpression.evaluate(context);
            sum += operandValue;
        }
        context.log(Level.INFO, "Calculating sum of number...");
        return sum;
    }
    
}
