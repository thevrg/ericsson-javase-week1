package hu.dpc.edu;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by vrg on 11/10/16.
 */
public class MyResourceTest {

    @Test
    public void test() {
        try (MyResource r1 = new MyResource("R1", new MyException("R1 ex"));
             MyResource r2 = new MyResource("R2", new MyException("R2 ex"));
             MyResource r3 = new MyResource("R3", new MyException("R3 ex"))) {
            System.out.println("Hello world");
            throw new MyException("Hűha");
        } catch (MyException ex) {
            System.out.println("Caught ex: " + ex);
            ex.addSuppressed(new NullPointerException("Hello"));
            System.out.println(Arrays.toString(ex.getSuppressed()));
        }


//        MyResource r1= null,r2 = null,r3 = null;
//        try {
//            r1 = new MyResource("R1");
//            r2 = new MyResource("R2");
//            r3 = new MyResource("R3");
//
//        } finally {
//            if (r3 != null) {
//                try {
//                    r3.close();
//                } catch (Throwable t) {
//
//                } finally {
//                    try {
//                        r2.close();
//                    } catch (Throwable t) {
//
//                    } finally {
//                        try {
//                            r1.close();
//                        } catch (Throwable t) {
//
//                        }
//                    }
//                }
//            }
//        }
    }
}