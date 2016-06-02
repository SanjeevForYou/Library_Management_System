package lms.controller.member;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lms.domain.Member;
import lms.util.DataAccess;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by 985205 on 6/1/2016.
 */
public class SearchMemberController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane anchorPaneAddEdit;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnAddNew;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtMemberId;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtStreet;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtZip;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtState;
    @FXML
    private Label hdnText;
    @FXML
    private TableView<Member> tblMember;
    @FXML
    private TableColumn<Member, String> colIdNumber;
    @FXML
    private TableColumn<Member, String> colName;
    @FXML
    private TableColumn<Member, String> colAddress;
    @FXML
    private TableColumn<Member, String> colPhoneNo;
    @FXML
    private TableColumn<Member, String> colEdit;
    @FXML
    private Label lblMessage;
    @FXML
    private Label lblMessageAddEdit;

    private DataAccess dataAccess;

  //  private static LibraryMember member;
    private static String memberId;

    public SearchMemberController() {
       // dataAccess = Utility.getDataAcessFacadeInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void searchMembers() {
        lblMessage.setText("");
//        if (!validateSearchFields()) {
//            return;
//        }
    }
}
