package sample;


public class InitController implements InitControllable {

    private String textInput = "";

    private double resultat_show = 0;

    private String indik = " ";

    private String zahl_a = "";

    private double vuvod = 0;

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

    public String printDisplayInput(String operation){
        //zahl_a = "";
        if(!textInput.endsWith("=")){
            textInput = textInput.concat(operation);
            return textInput;
        }else{
            return "=";
        }

    }
    public void disp_test(String te){
        zahl_a = zahl_a.concat(te);
        vuvod = Double.valueOf(zahl_a);
    }

    public String symbol(String symb){         //перезаписывает математический знак и делает вычисления

        if (textInput.endsWith("-") || textInput.endsWith("+") || textInput.endsWith("*") || textInput.endsWith("/") || textInput.endsWith("=")) {
            indik = symb;
            int a = textInput.length() - 1;
            textInput = textInput.substring(0, a).concat(symb);
            return textInput;
        }
        else {
            zahl_a = "";
            resultat_show = getRes(vuvod);
            indik = symb;
            return printDisplayInput(symb);
        }
    }

    public void printComma(String comma){
        if(!zahl_a.contains(comma)){
            printDisplayInput(comma);
            zahl_a = zahl_a.concat(comma);
        }
    }

    public void allСlear (){
        textInput = "";
        resultat_show = 0;
        indik = " ";
        zahl_a = "";
        vuvod = 0;
    }

}