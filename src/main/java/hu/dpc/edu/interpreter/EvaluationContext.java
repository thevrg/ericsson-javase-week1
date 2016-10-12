package hu.dpc.edu.interpreter;

import java.util.function.Supplier;
import java.util.logging.Level;

/**
 *
 * @author vrg
 */
public interface EvaluationContext {
    public <T> T getVariableAs(String name, Class<T> type);
    public void setVariable(String name, Object value);
    public void log(Level level, String message);
    public void log(Level level, Supplier<String> messageSupplier);
}
