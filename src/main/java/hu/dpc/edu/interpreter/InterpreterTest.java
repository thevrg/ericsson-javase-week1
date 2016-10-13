/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.interpreter;

import hu.dpc.edu.interpreter.longexpr.*;

/**
 *
 * @author vrg
 */
public class InterpreterTest {
    public static void main(String[] args) {
        DefaultEvaluationContext ctx = new DefaultEvaluationContext();
        ctx.setVariable("x", 18L);
        LongExpression expression = new Multiply(new Add(new Constant(12), new Variable("x")), new Constant(100));
        Long result = expression.evaluate(ctx);
        System.out.println("result: "+ result);
    }
}
