package sample;

import Parser.MathParser;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator_2 implements Calculable {
    public double calculate(String value){
        MathParser n = new MathParser();
        List<String> expression = n.parse(value);
        boolean flag = n.flag;

        if (flag) {
            class Inner{
                public Double calc(List<String> postfix) {
                    Deque<Double> stack = new ArrayDeque<Double>();
                    for (String x : postfix) {
                        if (x.equals("sqrt")) stack.push(Math.sqrt(stack.pop()));
                        else if (x.equals("cube")) {
                            Double tmp = stack.pop();
                            stack.push(tmp * tmp * tmp);
                        } else if (x.equals("pow10")) stack.push(Math.pow(10, stack.pop()));
                        else if (x.equals("+")) stack.push(stack.pop() + stack.pop());
                        else if (x.equals("-")) {
                            Double b = stack.pop(), a = stack.pop();
                            stack.push(a - b);
                        } else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
                        else if (x.equals("/")) {
                            Double b = stack.pop(), a = stack.pop();
                            stack.push(a / b);
                        } else if (x.equals("u-")) stack.push(-stack.pop());
                        else stack.push(Double.valueOf(x));
                    }
                    return stack.pop();
                }
            }
            Inner inner = new Inner();
            /*for (String x : expression) System.out.print(x + " ");
            System.out.println();
            System.out.println(inner.calc(expression));*/
            return inner.calc(expression);
        }
        else{
            return 0.0;
        }

    }
}
