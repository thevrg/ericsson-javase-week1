package hu.dpc.edu.java8;

/**
 * Created by vrg on 13/10/16.
 */
public class MyStringJoiner {
    private String separator;

    public MyStringJoiner(String separator) {
        this.separator = separator;
    }

    public String join(String s1, String s2) {
        boolean s1isEmtpy = s1 == null || s1.isEmpty();
        boolean s2isEmtpy = s2 == null || s2.isEmpty();
        if (s1isEmtpy && s2isEmtpy) {
            return "";
        } else if (s1isEmtpy) {
            return s2;
        } else if (s2isEmtpy) {
            return s1;
        } else {
            return s1 + separator + s2;
        }
    }
}
