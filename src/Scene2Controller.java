import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class Scene2Controller implements Initializable{

    @FXML
    private ToggleGroup PayMethod;

    @FXML
    private ToggleGroup Tip;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnPay;

    @FXML
    private RadioButton radNo;

    @FXML
    private RadioButton radYes;

    @FXML
    public TextArea txtAreaSummary;

    @FXML
    private RadioButton radCash;

    @FXML
    private RadioButton radCredit;

    @FXML
    private RadioButton radDebit;

    @FXML
    private RadioButton radGPay;

    @FXML
    private Label txtPayment;

    @FXML
    public ComboBox<Double> cbAmount = new ComboBox<>();

    Double [] tips = {2.0, 5.0, 8.0, 10.0};

    File myFile = new File("bill.txt");

    @FXML
    void confirm(ActionEvent event) {
        double tip = 0;
        try {
            double tax = Scene1Controller.total * 0.13;
            Scene1Controller.total += tax;
            if(cbAmount.getSelectionModel().getSelectedItem() != null){
                tip = cbAmount.getSelectionModel().getSelectedItem();
                Scene1Controller.total+=tip;
            }
            txtAreaSummary.appendText(String.format("Tax = $%-3.2f\n", tax));
            txtAreaSummary.appendText(String.format("Tip = $%-3.2f\n", tip));
            txtAreaSummary.appendText(String.format("Final Amount = $%-3.2f", Scene1Controller.total));

            PrintWriter pw = new PrintWriter(myFile);
            Random rand = new Random();
            int random = rand.nextInt(1000);
            pw.println(String.format("Bill No. %d", random));
            pw.println(String.format("Name: %s", Scene0Controller.name));
            pw.println(String.format("Phone Number: %s\n", Scene0Controller.phone));

            for (int j = 0; j < Scene1Controller.arr.size(); j++) {
                pw.println(String.format("%s\t\t$%.2f\n", Scene1Controller.arr.get(j).getName(), Scene1Controller.arr.get(j).getPrice()));
            }
            pw.println(String.format("Tip Amount = $%-3.2f", tip));
            pw.println(String.format("Tax = $%-3.2f\n", tax));
            pw.println("-------------------------");
            
            pw.println(String.format("Total Amount = $%-3.2f\n", Scene1Controller.total));
            pw.println("Thank You for Visiting");
            pw.close();


            radCash.setDisable(false);

            radCredit.setDisable(false);

            radDebit.setDisable(false);

            radGPay.setDisable(false);

            txtPayment.setDisable(false);

            btnPay.setDisable(false);

            btnConfirm.setDisable(true);

            cbAmount.setDisable(true);

            radYes.setDisable(true);

            radNo.setDisable(true);

            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        txtAreaSummary.clear();
        Scene1Controller.arr.clear();
        Scene1Controller.total = 0;
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        
        Scene0Controller.stage1.setScene(new Scene(root));
        
        Scene0Controller.stage1.setTitle("Self Ordering Kiosk");
        Scene0Controller.stage1.show();
        Scene1Controller.stage2.hide();
    }

    @FXML
    void pay(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.getButtonTypes().remove(ButtonType.CANCEL);
        ButtonType btnr = new ButtonType("NEW ORDER");
        alert.getButtonTypes().addAll(btnr);
        alert.setTitle("Thank You!");
        alert.setContentText("Your order will be processed soon\nPress OK to print the bill.\nPress NEW ORDER to start a new order");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                alert.close();
                Alert al2 = new Alert(AlertType.INFORMATION);
                al2.setContentText("Bill Printed Successfully!");
                al2.showAndWait().ifPresent(response2 -> {
                    if (response == ButtonType.OK){
                        System.exit(0);
                    }
                });

            } else if (response == btnr) {
                try {
                    txtAreaSummary.clear();
                    Scene1Controller.arr.clear();
                    Scene1Controller.total = 0;
                    Parent root = FXMLLoader.load(getClass().getResource("Scene0.fxml"));
        
                    Scene0Controller.stage1.setScene(new Scene(root));
                    
                    Scene0Controller.stage1.setTitle("Self Ordering Kiosk");
                    Scene0Controller.stage1.show();
                    Scene1Controller.stage2.hide();
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
        });
    }

    @FXML
    void tipNo(ActionEvent event) {
        if(radNo.isSelected()){
            cbAmount.getSelectionModel().clearSelection();
            cbAmount.setDisable(true);
            btnConfirm.setDisable(false);
        }
    }

    @FXML
    void tipYes(ActionEvent event) {
        if(radYes.isSelected()){
            cbAmount.setDisable(false);
            btnConfirm.setDisable(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbAmount.getItems().addAll(tips);
    }
    

}
