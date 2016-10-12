package hu.dpc.edu.interpreter.longexpr;

import hu.dpc.edu.interpreter.EvaluationContext;
import hu.dpc.edu.interpreter.LongExpression;
import java.util.logging.Level;

/**
 *
 * @author vrg
 */
public class Constant extends LongExpression{

    private final long value;

    public Constant(long value) {

        this.value = value;
    }
    
    @Override
    public Long evaluate(EvaluationContext context) {
        context.log(Level.INFO, "Evaluating constant: " + value);
        return value;
    }
    
}
