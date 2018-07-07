package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 120, 175));
        primaryStage.show();*/


        FXMLLoader loader=new FXMLLoader(getClass().getResource("../sample.fxml"));
        Group group=loader.load();
        Controller controller=loader.getController();
        controller.setCalcService(new InitController());
        primaryStage.setTitle("Calculator");

        Scene scene=new Scene(group, 600, 550);
        scene.getStylesheets().add("file:src/sample/Main.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
