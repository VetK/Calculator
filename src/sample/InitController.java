package sample;


public class InitController implements Controllable {

    String textInput = "";

    double resultat_show = 0;

    String indik = " ";

    public String zahl_a = "";

    double vuvod = 0;

    public String getTextInput() {
        return textInput;
    }
    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }

    public double getResultat_show() {
        return resultat_show;
    }
    public void setResultat_show(double resultat_show) {
        this.resultat_show = resultat_show;
    }

    public String getIndik() {
        return indik;
    }
    public void setIndik(String indik) {
        this.indik = indik;
    }

    public String getZahl_a() {
        return zahl_a;
    }
    public void setZahl_a(String zahl_a) {
        this.zahl_a = zahl_a;
    }

    public double getVuvod() {
        return vuvod;
    }
    public void setVuvod(double vuvod) {
        this.vuvod = vuvod;
    }

    public double getRes(double number){      //делает вычисление
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

    public String display(String operation){
        if(!textInput.endsWith("=")){
            textInput = textInput.concat(operation);
            return textInput;
        }else{
            return "";
        }

    }
    public void disp_test(String te){
        zahl_a = zahl_a.concat(te);
        vuvod = Double.valueOf(zahl_a);
    }

    public String symbol(String symb){         //перезаписывает математический знак и делает вычисления

        if (textInput.endsWith(symb)) {
            return "ть";
        }
        else if (textInput.endsWith("-") || textInput.endsWith("+") || textInput.endsWith("*") || textInput.endsWith("/") || textInput.endsWith("=")) {
            indik = symb;
            int a = textInput.length() - 1;
            textInput = textInput.substring(0, a).concat(symb);
            return textInput;

        }
        else {
            display(symb);    //посмотреть реализацию этого метода
            zahl_a = "";
            resultat_show = getRes(vuvod);
            indik = symb;
            return Double.toString(resultat_show);

            //conclusion_2.setTextInput(Double.toString(resultat_show));
        }
    }
}