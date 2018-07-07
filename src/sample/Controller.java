package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class Controller {

    @FXML
    private Button percent;    //процент

    @FXML
    public Text conclusion;    //дисплей вывода

    @FXML
    public Text conclusion_2;  //дисплей вывода результата

    private Controllable calcService;
    public void setCalcService(Controllable calsService){
        this.calcService=calsService;
    }

    @FXML
    public void signs(ActionEvent event){               //для знаков "+", "-", "/", "*"
        Button button=(Button)event.getSource();
        calcService.symbol(button.getText());
    }

    @FXML
    public void numerics(ActionEvent event){            //для цифр 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        Button button=(Button)event.getSource();
        conclusion.setText(calcService.display(button.getText()));
        calcService.disp_test(button.getText());

        //display(button.getTextInput());
        //disp_test(button.getTextInput());
    }

    @FXML
    public void equals(ActionEvent event){               //для "="
        Button button=(Button)event.getSource();
        calcService.display(button.getText());
        calcService.setZahl_a("");
        calcService.setResultat_show(calcService.getRes(calcService.getVuvod());
        conclusion_2.setText(Double.toString(calcService.getResultat_show()));

        //zahl_a = "";
        //resultat_show = getRes(vuvod);
        //conclusion_2.setText(Double.toString(resultat_show));
    }

    @FXML
    public void drop(){                  //для "AC"
        calcService.setTextInput("");
        calcService.setResultat_show(0);
        calcService.setIndik(" ");
        calcService.setZahl_a("");
        calcService.setVuvod(0);

        //resultat_show = 0;
        //indik = " ";
        //zahl_a = "";
        //vuvod = 0;
        try {
            conclusion.setText(calcService.getTextInput());
            conclusion_2.setText(calcService.getTextInput());
        }
        catch (Exception e){
            e.printStackTrace();
        }


        //conclusion_2.setTextInput(textInput);
    }

    @FXML
    public void btComma(ActionEvent event){               //для "."
        Button button=(Button)event.getSource();
        if (!zahl_a.contains(button.getText())){
            calcService.display(button.getText());
            zahl_a = zahl_a.concat(button.getText());
        }
    }

    @FXML
    void initialize() {
        percent.setOnAction(event -> { // дописать метод для %
            //symbol("%");

        });


    }

}