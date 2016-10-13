package hu.dpc.edu.java8;

import java.util.function.BinaryOperator;

/**
 * Created by vrg on 13/10/16.
 */
public class LambdaTest {
    public static void main(String[] args) {
        Converter<Long, String> c = new Converter<Long, String>() {
            @Override
            public String convert(Long aLong) {
                return aLong.toString();
            }
        };

        Converter<Long, String> c2 = l -> l.toString();

        String result = c.convert(123L);
        String result2 = c2.convert(123L);

        System.out.println(result);
        System.out.println(result2);

        Expression expression = (l1, l2) -> {
            System.out.println("evaluating " + l1 + " + " + l2);
            return l1 + l2;
        };

        Concatenator c22 = String::concat;

        final MyStringJoiner mySJ = new MyStringJoiner(" :: ");

        BinaryOperator<String>bo = mySJ :: join;



        System.out.println(bo.apply("X", "Y"));



        System.out.println(expression.evaluate(1, 2));
    }
}
