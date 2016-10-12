package hu.dpc.edu.interpreter;

/**
 *
 * @author vrg
 */
public interface Expression<T> {
    T evaluate(EvaluationContext context);
}
