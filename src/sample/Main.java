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
        Controller controller=loader.getController();
        controller.setCalcService(new InitController());
        primaryStage.setTitle("Calculator");

        Scene scene=new Scene(group, 120, 175);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}