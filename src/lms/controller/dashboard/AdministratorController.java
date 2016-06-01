package lms.controller.dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Created by Rajiv on 6/1/2016.
 */
public class AdministratorController implements Initializable {

    @FXML
    protected BorderPane rootLayout;
    @FXML
    protected AnchorPane anchorPane;
    @FXML
    public Label lblMsg;
    public static String holdMsg;

    @FXML
    protected void addEditMemberClick() {
        loadSearchMembersView();
    }

    // Helper Methods
    public void loadSearchMembersView() {
        try {
            anchorPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass()
                    .getResource("../view/member/searchMembers.fxml"));
            AnchorPane checkoutBook = loader.load();
            anchorPane.getChildren().add(checkoutBook);
            anchorPane.setLayoutX(0);
            anchorPane.setLayoutY(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void addBookCopyClick() {

    }

    @FXML
    protected void addBookClick() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Utility.loadSearchMembersView(anchorPane);
    }
}
