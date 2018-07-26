package sample;

import Parser.MathParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    public Text displayInput;                       //display of the output of the entered values

    @FXML
    public Text displayOutputResult;                //display of the output of the result

    private Calculable calcServise;

    private String inputText = "";

    public void setCalcServise (Calculable calcServise){
        this.calcServise = calcServise;
    }

    public void equals(){                           //button for "="
        double result = calcServise.calculate(displayInput.getText());
        if(MathParser.flag){
            displayOutputResult.setText(Double.toString(result));
        }
        else{
            displayOutputResult.setText("Incorrect expression!");
        }


    }

    public void digit(ActionEvent event){           //button for 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 and ".", "%"
        Button button = (Button) event.getSource();
        this.inputText = inputText.concat(button.getText());
        displayInput.setText(inputText);
    }

    public void drop(){                             //button for "AC"
        displayInput.setText("");
        displayOutputResult.setText("");
        this.inputText = "";
    }

    public void delete(){                           //button delete the last symbol in display of the output of the entered values
        deleteLastSymbol();
        displayInput.setText(inputText);
    }

    public void deleteLastSymbol(){
        if (inputText.length() != 0){
            inputText = inputText.substring(0, inputText.length()-1);
        }

    }

}