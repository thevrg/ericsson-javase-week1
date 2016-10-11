package hu.dpc.edu;

/**
 * Created by vrg on 11/10/16.
 */
public class MyResource implements AutoCloseable {

    private String name;
    private MyException exception;

    public MyResource(String name) {
        this.name = name;
        System.out.println("Creating " + name);
    }

    public MyResource(String name, MyException exception) {
        this.name = name;
        this.exception = exception;
        System.out.println("Creating " + name);
    }

    @Override
    public void close() throws MyException {
        System.out.println("Closing " + name);
        if (exception != null) {
            System.out.println("Throwing " + exception);
            throw exception;
        }
    }
}
