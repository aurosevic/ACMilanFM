package acmilan;

import java.util.ArrayList;

public class Korisnik {

	private String username;
	private String password;
	private ArrayList<Igrac> igraci;

	public Korisnik(String username, String password) {
		igraci = new ArrayList<>();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public ArrayList<Igrac> getIgraci() {
		return igraci;
	}
}