package hu.dpc.edu;

import com.sun.org.apache.xerces.internal.util.MessageFormatter;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vrg on 14/10/16.
 */
public class ResourceBundleDemo {
    public static void main(String[] args) {
        final ResourceBundle rb = ResourceBundle.getBundle("akarmi", new Locale("en"));
        final String firstName = rb.getString("firstName");
        System.out.println(String.format("hello, kedves %s, ma mi van %s", "Peter","Valaki"));
        System.out.println(firstName);

    }
}
