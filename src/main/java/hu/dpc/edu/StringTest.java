package hu.dpc.edu;

/**
 * Created by vrg on 14/10/16.
 */
public class StringTest {

    public static void main(String[] args) {
        String abc = "ABC";
        String abc2 = new String("AB" + "C");
        System.out.println(abc == abc2.intern());
    }
}
