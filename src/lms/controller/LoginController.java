package lms.controller;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lms.util.Auth;
import lms.util.DataAccess;

/**
 * Created by 985176 on 5/31/2016.
 */
public class LoginController {
    @FXML
	TextField thisUserName;

    @FXML
    PasswordField thisPassword;
    
    @FXML
    Text loginMessage;

	@FXML
	GridPane rootLayout;
    
    @FXML
	private void btnLoginClick() throws Exception {

		System.out.print("Reached to click handler");
//		try {
			if (thisUserName.getText().length() > 0
					&& thisPassword.getText().length() > 0) {

				Auth auth = DataAccess.login(
						thisUserName.getText(), thisPassword.getText());

				String menuUrl ="";
				if (auth != null) {

					switch (auth.getRole()) {
					case ROLE_ADMIN_LIBRARIAN:
						menuUrl = "../view/dashboard/adminLibrarian.fxml";
						break;
					case ROLE_ADMINISTRATOR:
						menuUrl = "../view/dashboard/administrator.fxml";
						break;

					case ROLE_LIBRARIAN:
						menuUrl = "../view/dashboard/librarian.fxml";
						break;
					default:
						menuUrl = "member.fxml";
					}
                  Stage st = (Stage) rootLayout.getScene().getWindow();    // Load root layout from fxml file.
					Parent root = FXMLLoader.load(getClass().getResource(menuUrl));
					Scene scene = new Scene(root, 1000.0, 575.0);
					st.setScene(scene);
					st.setX(150);
					st.setY(50);
					st.show();
				} else {
					loginMessage
							.setText("Login Failed. Invalid UserName/Password");
				}

			} else {
				loginMessage.setText("Please enter Username/Password");
			}

//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}
