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

/**
 * @author vrg
 */
public class AddWithJava8 extends LongExpression {

    private List<LongExpression> operands = new ArrayList<>();

    public AddWithJava8(LongExpression... operands) {
        this.operands.addAll(Arrays.asList(operands));
    }

    @Override
    public Long evaluate(EvaluationContext context) {

        Supplier<LongStream> valueStreamSupplier = () ->
                operands.stream()
                        .mapToLong((operandExpression) -> operandExpression.evaluate(context));


        context.log(Level.INFO, () ->
                valueStreamSupplier.get()
                        .mapToObj(Long::toString)
                        .collect(Collectors.joining(" + ", "Evaluating ", ""))
        );

        long result = valueStreamSupplier.get()
//                .reduce(0L, (accumulator, value) -> accumulator + value);
                .sum();

        return result;
    }

}
