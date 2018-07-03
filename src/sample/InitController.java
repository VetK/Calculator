package sample;

import static sample.Controller.conclusion;
import static sample.Controller.conclusion_2;

public class InitController {
    static String Text = "";

    static double resultat_show = 0;

    String indik = " ";

    String zahl_a = "";

    double vuvod = 0;

    double getResultat_show (double number){      //делает вычисление
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

    void display (String operation){
        if(!Text.endsWith("=")){
            Text = Text.concat(operation);
            conclusion.setText(Text);
        }
    }
    void disp_test(String te){
        zahl_a = zahl_a.concat(te);
        vuvod = Double.valueOf(zahl_a);
    }

    void symbol(String symb){         //перезаписывает математический знак и делает вычисления

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
