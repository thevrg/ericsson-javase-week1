package hu.dpc.edu.spring;

import hu.dpc.edu.java8.Java8Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

/**
 * Created by vrg on 14/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-config.xml")
public class SpringTestWithJUnitSupportXMLConfig {

    @Autowired
    private Logger logger;

    @Autowired
    private Java8Logger java8Logger;

    @Test
    public void testXMLConfig() {
        assertNotNull(logger);
        assertNotNull(java8Logger);
    }

}
