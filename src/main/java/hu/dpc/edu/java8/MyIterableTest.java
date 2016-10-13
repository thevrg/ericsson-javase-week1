package hu.dpc.edu.java8;

/**
 * Created by vrg on 13/10/16.
 */
public class MyIterableTest {
    public static void main(String[] args) {
        MyIterable mi = new MyIterable("Egy","ketto","harom");
        for (String s : mi) {
            System.out.println("hello: " + s);
        }

    }
}
