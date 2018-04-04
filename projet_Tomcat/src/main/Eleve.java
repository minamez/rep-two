package main;

public class Eleve {
	String prenom;
	String nom;
	int note;

	public Eleve(String prenom, String nom, int note) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.note = note;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
