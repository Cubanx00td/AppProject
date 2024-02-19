import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class Scene0Controller {

    public static Stage stage1 = new Stage();

    @FXML
    private Button btnOrder;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    public static String name;
    public static String phone;

    @FXML
    void placeOrder(ActionEvent event) throws IOException {

        name = txtName.getText();
        phone = txtPhone.getText();

        if(phone.length()  != 10){
            phone = "Invalid Phone Number";
        }


        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        
        stage1.setScene(new Scene(root));
        
        stage1.setTitle("Self Ordering Kiosk");
        stage1.show();
        App.stage0.hide();
    }

}
