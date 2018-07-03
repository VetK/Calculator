package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller extends InitController{

    @FXML
    private Button percent;     //процент

    @FXML
    static Text conclusion;    //дисплей вывода

    @FXML
    static Text conclusion_2;  //дисплей вывода результата

    @FXML
    public void signs(ActionEvent event){               //для знаков "+", "-", "/", "*"
        Button button=(Button)event.getSource();
        symbol(button.getText());
    }

    @FXML
    public void numerics(ActionEvent event){            //для цифр 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        Button button=(Button)event.getSource();
        display(button.getText());
        disp_test(button.getText());
    }

    @FXML
    public void equals(ActionEvent event){               //для "="
        Button button=(Button)event.getSource();
        display(button.getText());
        zahl_a = "";
        resultat_show = getResultat_show(vuvod);
        conclusion_2.setText(Double.toString(resultat_show));
    }

    @FXML
    public void drop(ActionEvent event){                  //для "AC"
        Text = "";
        resultat_show = 0;
        indik = " ";
        zahl_a = "";
        vuvod = 0;
        conclusion.setText(Text);
        conclusion_2.setText(Text);
    }

    @FXML
    public void btComma(ActionEvent event){               //для "AC"
        Button button=(Button)event.getSource();
        if (!zahl_a.contains(button.getText())){
            display(button.getText());
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