package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../sample.fxml"));
        AnchorPane group = loader.load();
        primaryStage.setTitle("Calculator");
        Controller controller = loader.getController();
        controller.setCalcServise(new Calculator_2());            //Calculator
        Scene scene=new Scene(group, 125, 175);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}