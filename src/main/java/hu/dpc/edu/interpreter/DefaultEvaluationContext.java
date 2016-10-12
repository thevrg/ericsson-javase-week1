/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vrg
 */
public class DefaultEvaluationContext implements EvaluationContext {
    
    private Logger logger;

    public DefaultEvaluationContext() {
        logger = Logger.getLogger(DefaultEvaluationContext.class.getName());
    }

    public DefaultEvaluationContext(Logger logger) {
        this.logger = logger;
    }
    
    private final Map<String,Object>variables = new HashMap<>();

    @Override
    public <T> T getVariableAs(String name, Class<T> type) {
        return (T) variables.get(name);
    }

    @Override
    public void setVariable(String name, Object value) {
        variables.put(name, value);
    }

    @Override
    public void log(Level level, String message) {
        logger.log(level, message);
    }

    @Override
    public void log(Level level, Supplier<String> messageSupplier) {
        if (logger.isLoggable(level)) {
            logger.log(level, messageSupplier.get());
        }
    }
    
}
