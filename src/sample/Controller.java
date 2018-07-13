package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class Controller {

    //@FXML
    //private Button percent;    //процент

    @FXML
    public Text displayInput;    //дисплей вывода введеных значений

    @FXML
    public Text displayOutputResult;  //дисплей вывода результата

    private InitControllable calcService;
    public void setCalcService(InitControllable calsService){
        this.calcService=calsService;
    }

    @FXML
    public void signs(ActionEvent event){               //для знаков "+", "-", "/", "*"
        Button button=(Button)event.getSource();
        displayInput.setText(calcService.symbol(button.getText()));
        displayOutputResult.setText(Double.toString(calcService.getResultat_show()));

    }

    @FXML
    public void numerics(ActionEvent event){            //для цифр 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        Button button=(Button)event.getSource();
        displayInput.setText(calcService.printDisplayInput(button.getText()));
        calcService.disp_test(button.getText());

    }

    @FXML
    public void equals(ActionEvent event){               //для "="
        Button button=(Button)event.getSource();
        calcService.printDisplayInput(button.getText());
        //calcService.setZahl_a("");
        calcService.setResultat_show(calcService.getRes(calcService.getVuvod()));
        displayOutputResult.setText(Double.toString(calcService.getResultat_show()));

    }

    @FXML
    public void drop(){                  //для "AC"
        calcService.allСlear();
        displayInput.setText(calcService.getTextInput());
        displayOutputResult.setText(calcService.getTextInput());
    }

    @FXML
    public void btComma(ActionEvent event){               //для "."
        Button button=(Button)event.getSource();
        calcService.printComma(button.getText());
        //displayInput.setText(calcService.printComma(button.getText()));
    }

    @FXML
    void initialize() {
        /*percent.setOnAction(event -> { // дописать метод для %
            //symbol("%");
        });*/
    }

}