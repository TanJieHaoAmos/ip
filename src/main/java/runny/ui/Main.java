package runny.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import runny.Runny;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Runny runny = new Runny("data/duke.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setRunny(runny); // inject the Runny instance
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
