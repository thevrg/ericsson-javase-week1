package hu.dpc.edu.spring;

import hu.dpc.edu.java8.Java8Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

/**
 * Created by vrg on 14/10/16.
 */
public class SpringTest {

    @Test
    public void testXMLConfig() {
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/application-config.xml")) {
            final Logger logger = context.getBean("logger", Logger.class);
            final Java8Logger java8Logger = context.getBean(Java8Logger.class);

            assertNotNull(logger);
            assertNotNull(java8Logger);
        }
    }

    @Test
    public void testJavaConfig() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class)) {
            final Logger logger = context.getBean("logger", Logger.class);
            final Java8Logger java8Logger = context.getBean(Java8Logger.class);

            assertNotNull(logger);
            assertNotNull(java8Logger);
        }
    }
}
