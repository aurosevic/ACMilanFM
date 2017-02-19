package acmilan;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PodaciControler {
	
	@FXML
	private TableView<Igrac> tabelaGolmani;

	@FXML
	private TableColumn<Igrac, String> colGIme;// = new TableColumn<Igrac, String>("Ime");

	@FXML
	private TableColumn<Igrac, String> colGPrezime;// = new TableColumn<Igrac, String>("Prezime");

	@FXML
	private TableView<Igrac> tabelaOdbrana;

	@FXML
	private TableView<Igrac> tabelaSredina;

	@FXML
	private TableView<Igrac> tabelaNapad;

	@FXML
	private Button btnDodajIgraca;
	
	@FXML
	private Button btnBezveze;

	Stage stage;
	
	@FXML
	public void uradiTabelu() {
		
		tabelaGolmani.getColumns().clear();
		
		ObservableList<Igrac> igraci = FXCollections.observableArrayList();
		igraci.add(new Igrac("Ime", "Prezime", 23, 32, Pozicija.Golman, "Tim", new Image("pic/milan.png")));
    	igraci.add(new Igrac("Ime2", "Prezime2", 31, 265, Pozicija.Golman, "Tim2", new Image("pic/milan.png")));
    	
    	//colGIme = new TableColumn<>("Ime");
    	colGIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
    	//colGPrezime = new TableColumn<>("Prezime");
    	colGPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
    	
    	tabelaGolmani.setItems(igraci);
    	tabelaGolmani.getColumns().addAll(colGIme, colGPrezime);
	}

	@FXML
	public void dodajIgraca(ActionEvent event) {
		try {
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Pane pane = FXMLLoader.load(getClass().getResource("DodajIgraca.fxml"));
			Scene scene = new Scene(pane);
			stage.close();
			stage.setScene(scene);
			stage.setTitle("Dodaj igraca");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Welcome main;
	
	public void setMain(Welcome main) {
		this.main = main;
	}

	public TableView<Igrac> getTabelaGolmani() {
		return tabelaGolmani;
	}

	public TableColumn<Igrac, String> getColGIme() {
		return colGIme;
	}

	public TableColumn<Igrac, String> getColGPrezime() {
		return colGPrezime;
	}

	public TableView<Igrac> getTabelaOdbrana() {
		return tabelaOdbrana;
	}

	public TableView<Igrac> getTabelaSredina() {
		return tabelaSredina;
	}

	public Button getBtnBezveze() {
		return btnBezveze;
	}

	public void setBtnBezveze(Button btnBezveze) {
		this.btnBezveze = btnBezveze;
	}

	public void setBtnDodajIgraca(Button btnDodajIgraca) {
		this.btnDodajIgraca = btnDodajIgraca;
	}

	public TableView<Igrac> getTabelaNapad() {
		return tabelaNapad;
	}

	public Button getBtnDodajIgraca() {
		return btnDodajIgraca;
	}

	public void setTabelaGolmani(TableView<Igrac> tabelaGolmani) {
		this.tabelaGolmani = tabelaGolmani;
	}

	public void setColGIme(TableColumn<Igrac, String> colGIme) {
		this.colGIme = colGIme;
	}

	public void setColGPrezime(TableColumn<Igrac, String> colGPrezime) {
		this.colGPrezime = colGPrezime;
	}

	public void setTabelaOdbrana(TableView<Igrac> tabelaOdbrana) {
		this.tabelaOdbrana = tabelaOdbrana;
	}

	public void setTabelaSredina(TableView<Igrac> tabelaSredina) {
		this.tabelaSredina = tabelaSredina;
	}

	public void setTabelaNapad(TableView<Igrac> tabelaNapad) {
		this.tabelaNapad = tabelaNapad;
	}
}