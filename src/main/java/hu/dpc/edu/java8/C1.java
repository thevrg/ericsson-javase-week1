package hu.dpc.edu.java8;

/**
 * Created by vrg on 14/10/16.
 */
public class C1 {
    int x  = 1;

    public C1(int x) {
        this.x = x + 1;
        hello();
    }

    public void hello() {
        this.x += 2;
    }

    public int getX() {
        return x;
    }
}
