package sample;


import org.mariuszgromada.math.mxparser.*;

public class Calculator implements Calculable {

    public double calculate(String value){
        Expression expression=new Expression(value);
        return expression.calculate();
    }

}