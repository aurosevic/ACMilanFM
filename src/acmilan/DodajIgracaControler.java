package acmilan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONException;
import org.json.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DodajIgracaControler {

    @FXML
    private TextField tfIme;

    @FXML
    private TextField tfPrezime;

    @FXML
    private TextField tfNivo;

    @FXML
    private TextField tfVrednost;

    @FXML
    private TextField tfPozicija;

    @FXML
    private TextField tfTim;

    @FXML
    private Button btnOtkazi;

    @FXML
    private Button btnDodajIgraca;
    
    @FXML
    private ChoiceBox<Pozicija> cbPozicija;
    
    public void dodajOpcije() {
    	//cbPozicija.add
    }
    
    WelcomeControler wc = new WelcomeControler();
    
    @FXML
    public void goBack(ActionEvent event) throws IOException {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	Pane pane = FXMLLoader.load(getClass().getResource("Podaci.fxml"));
    	Scene scene = new Scene(pane);
    	stage.close();
    	stage.setScene(scene);
    	stage.setTitle("Welcome to A.C. Milan FM");
    	stage.setResizable(true);
    	stage.show();
    }
    
    @FXML
    public void upisiIgraca() throws JSONException {
    	if (tfIme.getText().trim() != "" && tfPrezime.getText().trim() != "" && tfNivo.getText().trim() != "" && tfVrednost.getText().trim() != ""
    			&& tfPozicija.getText().trim() != "" && tfTim.getText().trim() != "") {
    		JSONObject obj = new JSONObject()
        			.put("ime", tfIme.getText().trim())
        			.put("prezime", tfPrezime.getText().trim())
        			.put("nivo", tfNivo.getText().trim())
        			.put("vrednost", tfVrednost.getText().trim())
        			.put("pozicija", tfPozicija.getText().trim())
        			.put("tim", tfTim.getText().trim());
        	
    		upisiUJSON(obj);
    		
    	}
    }
    
    PodaciControler podaciControler = new PodaciControler();
    
    @FXML
    public void dodajUTabelu() {
    	
    	podaciControler.getTabelaGolmani().getColumns().clear();
    	ObservableList<Igrac> igraci = FXCollections.observableArrayList();
    	igraci.add(new Igrac("Ime", "Prezime", 23, 32, Pozicija.Golman, "Tim", new Image("pic/milan.png")));
    	igraci.add(new Igrac("Ime2", "Prezime2", 31, 265, Pozicija.Golman, "Tim2", new Image("pic/milan.png")));
    	
    	podaciControler.getColGIme().setCellValueFactory(new PropertyValueFactory<>("ime"));
    	podaciControler.getColGPrezime().setCellValueFactory(new PropertyValueFactory<>("prezime"));
    	
    	podaciControler.getTabelaGolmani().setItems(igraci);
    	podaciControler.getTabelaGolmani().getColumns().addAll(podaciControler.getColGIme(), podaciControler.getColGPrezime());
    }
    
    public ObservableList<Igrac> pokupiIgrace() {
    	ObservableList<Igrac> igraciList = FXCollections.observableArrayList();
    	igraciList.add(new Igrac("Ime", "Ime", 12, 21, Pozicija.Golman, "Ime", new Image("pic/milan.png")));
    	return igraciList;
    }
    
    /***
     * Upis u JSON
     */
    JSONObject obj = new JSONObject();
    int br = 0;
    @FXML
    public void upisiUJSON(JSONObject collection) {
    	File file = new File("json/sviIgraci.json");
    	String igrac = "igrac" + br;
			try {
				obj.append(igrac, collection);
				br++;
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
    	PrintWriter pw = null;
    	try {
			pw = new PrintWriter(new FileWriter(file));
			try {
				obj.write(pw);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	pw.close();
    	//dodajUTabelu();
    }
}