package hu.dpc.edu.interpreter.longexpr;

import hu.dpc.edu.interpreter.EvaluationContext;
import hu.dpc.edu.interpreter.LongExpression;
import java.util.logging.Level;

/**
 *
 * @author vrg
 */
public class Variable extends LongExpression{

    private String name;

    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public Long evaluate(EvaluationContext context) {
        context.log(Level.INFO, "Evaluating variable: " + name);
        return context.getVariableAs(name, Long.class);
    }
    
}
