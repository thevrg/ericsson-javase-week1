package hu.dpc.edu.java8;

/**
 * Created by vrg on 13/10/16.
 */
@FunctionalInterface
public interface Converter<MIT,MIRE> {

    public MIRE convert(MIT mit);
}
