package lms.controller.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Rajiv on 6/1/2016.
 */
public class AdminLibrarian extends AdministratorController {

    @FXML
    private void searchByISBNClick() {
    }

    @FXML
    private void checkoutBookClick() {
    }

    @FXML
    private void showMemberRecordClick() {
    }

    public void loadSearchByISBNView(AnchorPane anchorPane) {
        try {
            anchorPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/checkout/"
                    + "searchBookCheckoutRecordEntries.fxml"));
            AnchorPane checkoutBook = (AnchorPane) loader.load();
            anchorPane.getChildren().add(checkoutBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Utility.loadSearchMembersView(anchorPane);
    }
}
