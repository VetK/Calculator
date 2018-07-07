package sample;

public interface Controllable {

    String getTextInput();
    void setTextInput(String textInput);

    double getResultat_show();
    void setResultat_show(double resultat_show);

    String getIndik();
    void setIndik(String indik);

    String getZahl_a();
    void setZahl_a(String zahl_a);

    double getVuvod();
    void setVuvod(double vuvod);

    double getRes(double number);

    String display (String operation);

    void disp_test(String te);

    String symbol(String symb);
}
