package StartUp;

import gui.QueryPanelController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartUpGuiClientApp extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new QueryPanelController());
        stage.setScene(scene);

        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown((WindowEvent t) -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(StartUpGuiClientApp.class, args);
    }
}
