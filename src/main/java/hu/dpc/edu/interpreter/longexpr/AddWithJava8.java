package hu.dpc.edu.interpreter.longexpr;

import hu.dpc.edu.interpreter.EvaluationContext;
import hu.dpc.edu.interpreter.LongExpression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author vrg
 */
public class AddWithJava8 extends LongExpression {

    private List<LongExpression> operands = new ArrayList<>();

    public AddWithJava8(LongExpression... operands) {
        this.operands.addAll(Arrays.asList(operands));
    }

    @Override
    public Long evaluate(EvaluationContext context) {
        Stream<Long> valueStream = operands.stream()
                .map((operandExpression) -> operandExpression.evaluate(context));
        
        context.log(Level.INFO, ()
                -> valueStream.map(longValue
                        -> longValue.toString())
                        .collect(Collectors.joining(" + ", "Adding ", "."))
        );
        
        long result = valueStream
                .map((operandValue) -> operandValue)
                .reduce(0L, (accumulator, value) -> accumulator + value);
        
        return result;
    }

}
