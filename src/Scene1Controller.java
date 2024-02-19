import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Scene1Controller {

    @FXML
    private Button btnCheckout;

    @FXML
    private CheckBox chkCh1;

    @FXML
    private CheckBox chkCh2;

    @FXML
    private CheckBox chkCh3;

    @FXML
    private CheckBox chkCh4;

    @FXML
    private CheckBox chkCh5;

    @FXML
    private CheckBox chkDrink1;

    @FXML
    private CheckBox chkDrink2;

    @FXML
    private CheckBox chkDrink3;

    @FXML
    private CheckBox chkDrink4;

    @FXML
    private CheckBox chkDrink5;

    @FXML
    private CheckBox chkInd1;

    @FXML
    private CheckBox chkInd2;

    @FXML
    private CheckBox chkInd3;

    @FXML
    private CheckBox chkInd4;

    @FXML
    private CheckBox chkInd5;

    public static ArrayList<Item> arr = new ArrayList<>();
    public static Stage stage2 = new Stage();
    public static double total = 0;

    @FXML
    void checkout(ActionEvent event) throws IOException {
        if (chkInd1.isSelected()) {
            Item item = new Item();
            item.setName("Daal Makhni");
            item.setPrice(10);
            arr.add(item);
        }
        if (chkInd2.isSelected()) {
            Item item = new Item();
            item.setName("Paratha");
            item.setPrice(8);
            arr.add(item);
        }
        if (chkInd3.isSelected()) {
            Item item = new Item();
            item.setName("Shahi Paneer");
            item.setPrice(12);
            arr.add(item);
        }
        if (chkInd4.isSelected()) {
            Item item = new Item();
            item.setName("Roti");
            item.setPrice(4);
            arr.add(item);
        }
        if (chkInd5.isSelected()) {
            Item item = new Item();
            item.setName("Mixed Veg");
            item.setPrice(10);
            arr.add(item);
        }

        if (chkCh1.isSelected()) {
            Item item = new Item();
            item.setName("Noodles");
            item.setPrice(7);
            arr.add(item);
        }
        if (chkCh2.isSelected()) {
            Item item = new Item();
            item.setName("Spring Roll");
            item.setPrice(9);
            arr.add(item);
        }
        if (chkCh3.isSelected()) {
            Item item = new Item();
            item.setName("Pasta");
            item.setPrice(8);
            arr.add(item);
        }
        if (chkCh4.isSelected()) {
            Item item = new Item();
            item.setName("Soup");
            item.setPrice(5);
            arr.add(item);
        }
        if (chkCh5.isSelected()) {
            Item item = new Item();
            item.setName("Sushi");
            item.setPrice(14);
            arr.add(item);
        }

        if (chkDrink1.isSelected()) {
            Item item = new Item();
            item.setName("Tea");
            item.setPrice(3);
            arr.add(item);
        }
        if (chkDrink2.isSelected()) {
            Item item = new Item();
            item.setName("Coffee");
            item.setPrice(3);
            arr.add(item);
        }
        if (chkDrink3.isSelected()) {
            Item item = new Item();
            item.setName("Coke");
            item.setPrice(2);
            arr.add(item);
        }
        if (chkDrink4.isSelected()) {
            Item item = new Item();
            item.setName("Juice");
            item.setPrice(4);
            arr.add(item);

        }
        if (chkDrink5.isSelected()) {
            Item item = new Item();
            item.setName("Water");
            item.setPrice(2);
            arr.add(item);
        }


        
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        Parent root = loader.load();
        stage2.setScene(new Scene(root));

        Scene2Controller sc2 = loader.getController();

        
        for (Item item : arr) {
            String nameString = item.getName();
            double price = item.getPrice();
            sc2.txtAreaSummary.appendText(String.format("%-20s @ $%-3.2f\n", nameString, price));
            total+=price;
        }
        System.out.println(total);
        sc2.txtAreaSummary.appendText("-----------------------------\n");
        sc2.txtAreaSummary.appendText(String.format("Total Amount = $%-3.2f\n", Scene1Controller.total));
        
        

        stage2.setTitle("Self Ordering Kiosk");
        stage2.show();
        Scene0Controller.stage1.hide();
        
    }

}
