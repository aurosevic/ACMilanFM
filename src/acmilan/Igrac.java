package acmilan;

import javafx.scene.image.Image;

public class Igrac {

	private String ime;
	private String prezime;
	private int vrednost;
	private int level;
	private Pozicija pozicija;
	private String tim;
	private Image slika;
	
	public Igrac(String ime, String prezime, int vrednost, int level, Pozicija pozicija, String tim, Image slika) {
		this.ime = ime;
		this.prezime = prezime;
		this.vrednost = vrednost;
		this.level = level;
		this.pozicija = pozicija;
		this.tim = tim;
		this.slika = slika;
	}
	
	@Override
	public String toString() {
		return "\nIgrac: " + ime + " " + prezime + ": " + vrednost + ", lvl - " + level + ", " + pozicija + " (" + tim + ")\n";
	}
	
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public int getVrednost() {
		return vrednost;
	}
	
	public int getLevel() {
		return level;
	}
	
	public Pozicija getPozicija() {
		return pozicija;
	}
	
	public String getTim() {
		return tim;
	}
	
	public Image getSlika() {
		return slika;
	}
}