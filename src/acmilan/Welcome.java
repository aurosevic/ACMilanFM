package acmilan;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Welcome extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private Stage stage;
	private Pane pane;
	
	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		/**
		 * pane = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
		 */
		FXMLLoader loader = new FXMLLoader(Welcome.class.getResource("Welcome.fxml"));
		pane = loader.load();
		 
		WelcomeControler controler = loader.getController();
		controler.setMain(this);
		controler.getBtnLogin().setDefaultButton(true);
		
		Scene sceneWelcome = new Scene(pane); 
		
		stage.setTitle("AC Milan FM");
		stage.getIcons().add(new Image("pic/milan.png"));
		stage.setScene(sceneWelcome);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}

	public Stage getStage() {
		return stage;
	}
}