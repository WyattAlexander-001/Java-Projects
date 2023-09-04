package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
            
            

            Text txt = new Text("Hello, This is your 2nd JavaFX");
            txt.setFont(new Font("Papyrus", 15));
            TextField nameFld = new TextField();
            //root.setCenter(txt);

            Button btn = new Button();
            String name = "Wyatt";
            btn.setText("Howdy, Click here and it will output to console, also I'm: " + name);
            btn.setOnAction(evt -> System.out.printf("You clicked the button: %s%n", nameFld.getText())); //Outputs to console using lambda exp
            //root.setTop(btn);


            
            Label label = new Label("Name: ");
            GridPane grid = new GridPane();
            grid.add(label, 0, 0); //columnms, row
            grid.add(nameFld, 1, 0);
            grid.add(btn, 2, 0);
            grid.setHgap(25);
            grid.setGridLinesVisible(true); //good for debugging grids

   
            VBox box = new VBox();
            box.getChildren().addAll(txt, grid);
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
