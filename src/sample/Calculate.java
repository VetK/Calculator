package sample;


import org.mariuszgromada.math.mxparser.*;

public class Calculate implements Calculable {

    private String inputText = "";

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public double calcEquals (String value){
        Expression expression=new Expression(value);
        return expression.calculate();
    }

    public String printDisplayInput (String text){
            this.inputText = this.inputText.concat(text);
            return this.inputText;

    }

    public void deleteLastSymbol(){
        if (inputText.length() != 0){
            inputText = inputText.substring(0, inputText.length()-1);
        }

    }

}