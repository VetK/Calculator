package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    public Text displayInput;                       //display of the output of the entered value

    @FXML
    public Text displayOutputResult;                //display of the output of the result

    private Calculable calcServise;

    public void setCalcServise (Calculable calcServise){
        this.calcServise = calcServise;
    }

    @FXML
    public void bCalcEquals(){                      //for "="
        double result = calcServise.calcEquals(displayInput.getText());
        displayOutputResult.setText(Double.toString(result));

    }

    public void digit(ActionEvent event){           //for 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 and "."
        Button button = (Button) event.getSource();
        String text = calcServise.printDisplayInput(button.getText());
        displayInput.setText(text);
    }

    public void drop(){                             //for "AC"
        displayInput.setText("");
        displayOutputResult.setText("");
        calcServise.setInputText("");
    }

    public void bDelete(){
        calcServise.deleteLastSymbol();
        displayInput.setText(calcServise.getInputText());
    }

}