package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 640, 480);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);

            Text txt = new Text("SUP? This is your first JavaFX");
            TextField nameFld = new TextField();
            //root.setCenter(txt);

            Button btn = new Button();
            String name = "Wyatt";
            btn.setText("Howdy, Click here and it will output to console: " + name);
            btn.setOnAction(evt -> System.out.printf("You clicked the button: %s%n", nameFld.getText())); //Outputs to console using lambda exp
            //root.setTop(btn);

            VBox box = new VBox();
            box.getChildren().addAll(txt,  nameFld,btn);
            root.setCenter(box);
   
            
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
