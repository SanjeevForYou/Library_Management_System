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
    private void loadSearchMembersView() {

        System.out.println("Reached to loadSearchMembersView");
        try {
            anchorPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../../../lms/view/member/searchMember.fxml"));
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
        loadAddBookCopyView();
    }

    private void loadAddBookCopyView() {
        System.out.println("Reached to loadAddBookCopyView");
        try {
            anchorPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../../../lms/view/book/addBookCopies.fxml"));
            AnchorPane checkoutBook = (AnchorPane) loader.load();
            anchorPane.getChildren().add(checkoutBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void addBookClick() {
        loadAddBookView();
    }

    private void loadAddBookView() {
        System.out.println("Reached to loadAddBookView");
       // System.out.println(System.getProperty("user.dir")+"/src/lms/view/book/addBook.fxml");
        System.out.print(anchorPane.toString());
        try {
            anchorPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../../../lms/view/book/addBook.fxml"));

            AnchorPane checkoutBook = (AnchorPane) loader.load();
            anchorPane.getChildren().add(checkoutBook);
            anchorPane.setLayoutX(0);
            anchorPane.setLayoutY(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  loadSearchMembersView();
    }
}
