package hu.dpc.edu.interpreter.longexpr;

import hu.dpc.edu.interpreter.EvaluationContext;
import hu.dpc.edu.interpreter.LongExpression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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

        Supplier<LongStream>valueStreamSupplier = ()
                -> operands.stream()
                .mapToLong(longEx -> longEx.evaluate(context));


        final long result = valueStreamSupplier.get()
                .sum();


        context.log(Level.INFO, () -> {
            return valueStreamSupplier.get()
                    .mapToObj(Long::toString)
                    .collect(Collectors.joining(" + ", "Evaluating ", ""));
        });
        return result;
    }
    
}
