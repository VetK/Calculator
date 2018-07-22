package sample;

import javafx.fxml.FXML;
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
}