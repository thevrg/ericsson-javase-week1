package hu.dpc.edu.java8;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vrg on 14/10/16.
 */
@Component("java8logger")
public class Java8Logger {
    @Autowired
    private Logger logger;

    @Autowired
    private ApplicationContext ctx;

    public Java8Logger() {
    }

    public Java8Logger(Logger logger) {
        this.logger = logger;
    }

    public void log(Level level, Supplier<String> messageSupplier) {
        if (logger.isLoggable(level)) {
            logger.log(level, messageSupplier.get());
        }
    }

}
