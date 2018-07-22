package sample;


import org.mariuszgromada.math.mxparser.*;

public class Calculate implements Calculable {

    public double calcEquals (String value){
        Expression expression=new Expression(value);
        return expression.calculate();
    }

}