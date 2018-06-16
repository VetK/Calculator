package sample;

import java.net.URL;
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
    private Button pl_mi;       //вставить плюс или минус

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

    private static double resultat_show = 0;

    private static String ch_1 = "0";

    private String indik = " ";

    private String zahl;

    private String zahl_a = "";

    private double vuvod = 0;

    @FXML
    void initialize() {

        zero.setOnAction(event -> {
            display("0");
            disp_test("0");
        });

        one.setOnAction(event -> {
            display("1");
            disp_test("1");
        });

        two.setOnAction(event -> {
            display("2");
            disp_test("2");
        });

        three.setOnAction(event -> {
            display("3");
            disp_test("3");
        });

        four.setOnAction(event -> {
            display("4");
            disp_test("4");
        });

        five.setOnAction(event -> {
            display("5");
            disp_test("5");
        });

        six.setOnAction(event -> {
            display("6");
            disp_test("6");
        });

        seven.setOnAction(event -> {
            display("7");
            disp_test("7");
        });

        eight.setOnAction(event -> {
            display("8");
            disp_test("8");
        });

        nine.setOnAction(event -> {
            display("9");
            disp_test("9");
        });

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
            resultat_show = getResultat_show(vuvod);
            conclusion_2.setText(Double.toString(resultat_show));

        });

        dpopping.setOnAction(event -> {
            Text = "";
            conclusion.setText(Text);
            resultat_show = 0;

        });

        comma.setOnAction(event -> {
            if (zahl_a.contains(".")){

            }
            else {
                display(".");
                zahl = ".";
                zahl_a = zahl_a.concat(zahl);
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
        return resultat_show;

    }

    private void display (String operation){
        if(Text.endsWith("=")){

        }
        else{
            Text = Text.concat(operation);
            conclusion.setText(Text);
        }


    }

    private void disp_test(String te){
        zahl = te;
        zahl_a = zahl_a.concat(zahl);
        vuvod = Double.valueOf(zahl_a);
    }

    private void symbol(String symb){         //перезаписывает математический знак и делает вычисления
        String a1="";
        String a2="";
        String a3="";

        {
            if (symb == "+") {
                a1 = "-";
                a2 = "/";
                a3 = "*";
            } else if (symb == "-") {
                a1 = "+";
                a2 = "/";
                a3 = "*";
            } else if (symb == "*") {
                a1 = "-";
                a2 = "/";
                a3 = "+";
            } else if (symb == "/") {
                a1 = "-";
                a2 = "+";
                a3 = "*";
            }
        }

        {
            if (Text.endsWith(a1) || Text.endsWith(a2) || Text.endsWith(a3)) {
                indik = symb;
                int a = Text.length() - 1;
                Text = Text.substring(0, a).concat(symb);
                conclusion.setText(Text);
            } else if (Text.endsWith(symb)) {
                indik = symb;
            } else {
                display(symb);
                zahl_a = "";
                resultat_show = getResultat_show(vuvod);
                indik = symb;
                conclusion_2.setText(Double.toString(resultat_show));
            }
        }


    }

}