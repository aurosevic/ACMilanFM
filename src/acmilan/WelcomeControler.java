package acmilan;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WelcomeControler {
	
    @FXML
    private ImageView imgSheva;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblLogin;

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private CheckBox cbRememberMe;

    @FXML
    private Button btnLogin;
    
    @FXML
    private Label lblIncorrect;

    Welcome main;
    
    public void setMain(Welcome main) {
    	this.main = main;
    }
    
    Stage stage;
    Pane pane;
    
    @FXML
    public void login(ActionEvent event) {
    	if(tfUsername.getText().trim().equals("") && pfPassword.getText().trim().equals("")) { //KPB_27 i andrija
    		try {
        		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        		pane = FXMLLoader.load(getClass().getResource("Podaci.fxml"));
        		Scene scene = new Scene(pane);
        		stage.close();
        		stage.setTitle("Welcome to A.C. Milan FM");
        		stage.setScene(scene);
        		stage.setResizable(true);
        		stage.centerOnScreen();
        		stage.show();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	} else {
    		lblIncorrect.setVisible(true);
    		FadeTransition transition = new FadeTransition(Duration.millis(300), lblIncorrect);
    		transition.setFromValue(0);
    		transition.setToValue(1);
    		transition.play();
    	}
    }
    
    public Button getBtnLogin() {
		return btnLogin;
	}
    
    public Pane getPane() {
		return pane;
	}
}