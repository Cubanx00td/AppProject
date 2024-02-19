import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public static Stage stage0 = new Stage();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene0.fxml"));
        
        stage0.setScene(new Scene(root));
        
        stage0.setTitle("Self Ordering Kiosk");
        stage0.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
