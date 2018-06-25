package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button zero;        //0

    @FXML
    private Button one;         //1

    @FXML
    private Button two;         //2

    @FXML
    private Button three;       //3

    @FXML
    private Button four;        //4

    @FXML
    private Button five;        //5

    @FXML
    private Button six;         //6

    @FXML
    private Button seven;       //7

    @FXML
    private Button eight;       //8

    @FXML
    private Button nine;        //9

    @FXML
    private Button dpopping;    //скинуть введенное

    @FXML
    private Button percent;     //процент

    @FXML
    private Button divide;      //разделить

    @FXML
    private Button multiply;    //умножить

    @FXML
    private Button minus;       //отнять

    @FXML
    private Button plus;        //прибавить

    @FXML
    private Button comma;       //запятая

    @FXML
    private Button equally;     //равно

    @FXML
    private Text conclusion;    //дисплей вывода

    @FXML
    private Text conclusion_2;  //дисплей вывода результат

    private static String Text = "";

    public static double resultat_show = 0;

    private String indik = " ";

    private String zahl_a = "";

    private double vuvod = 0;

    public static void knopka(){

    }

    @FXML
    void initialize() {
        ArrayList<Button> numbers = new ArrayList<Button>();
        numbers.add(zero);
        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);
        numbers.add(five);
        numbers.add(six);
        numbers.add(seven);
        numbers.add(eight);
        numbers.add(nine);

        for (int i=0; i<numbers.size(); i++){
            Button b = numbers.get(i);
            numbers.get(i).setOnAction(event -> {
                display(b.getText());
                disp_test(b.getText());
            });
        }

        divide.setOnAction(event -> {
            symbol("/");

        });

        multiply.setOnAction(event -> {
            symbol("*");

        });

        minus.setOnAction(event -> {
            symbol("-");

        });

        plus.setOnAction(event -> {
            symbol("+");

        });

        percent.setOnAction(event -> { // дописать метод для %
            //symbol("%");

        });

        equally.setOnAction(event -> {
            display("=");
            zahl_a = "";
            resultat_show = getResultat_show(vuvod);
            conclusion_2.setText(Double.toString(resultat_show));

        });

        dpopping.setOnAction(event -> {
            Text = "";
            conclusion.setText(Text);
            conclusion_2.setText(Text);

            resultat_show = 0;

            indik = " ";

            zahl_a = "";

            vuvod = 0;

        });

        comma.setOnAction(event -> {
            if (!zahl_a.contains(".")){
                display(".");
                zahl_a = zahl_a.concat(".");
            }
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