package hu.dpc.edu.spring;

import hu.dpc.edu.java8.Java8Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * Created by vrg on 14/10/16.
 */
@ComponentScan(basePackages = "hu.dpc.edu")
public class JavaConfiguration {

    @Bean
    public Logger logger() {
        return Logger.getAnonymousLogger();
    }

//    @Bean
//    public Java8Logger java8Logger() {
//        return new Java8Logger(logger());
//    }

}
