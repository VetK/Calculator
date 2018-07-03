package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Button percent;     //процент

    @FXML
    private Text conclusion;    //дисплей вывода

    @FXML
    private Text conclusion_2;  //дисплей вывода результат

    private static String Text = "";

    public static double resultat_show = 0;

    private String indik = " ";

    private String zahl_a = "";

    private double vuvod = 0;

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

    private double getResultat_show (double number){      //делает вычисление
        switch (indik){
            case "-":
                resultat_show = resultat_show - number;
                return resultat_show;
            case "+":
                resultat_show = resultat_show + number;
                return resultat_show;
            case "/":
                resultat_show = resultat_show / number;
                return resultat_show;
            case "*":
                resultat_show = resultat_show * number;
                return resultat_show;
            case " ":
                resultat_show = number;
                return resultat_show;
        }
        return 0;
    }

    private void display (String operation){
        if(!Text.endsWith("=")){
            Text = Text.concat(operation);
            conclusion.setText(Text);
        }
    }

    private void disp_test(String te){
        zahl_a = zahl_a.concat(te);
        vuvod = Double.valueOf(zahl_a);
    }

    private void symbol(String symb){         //перезаписывает математический знак и делает вычисления

        if (Text.endsWith(symb)) {

        }
        else if (Text.endsWith("-") || Text.endsWith("+") || Text.endsWith("*") || Text.endsWith("/") || Text.endsWith("=")) {
            indik = symb;
            int a = Text.length() - 1;
            Text = Text.substring(0, a).concat(symb);
            conclusion.setText(Text);
        }
        else {
            display(symb);
            zahl_a = "";
            resultat_show = getResultat_show(vuvod);
            indik = symb;
            conclusion_2.setText(Double.toString(resultat_show));
        }
    }

}