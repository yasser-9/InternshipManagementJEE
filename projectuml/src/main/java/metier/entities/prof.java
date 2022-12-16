package metier.entities;

import java.io.Serializable;

public class prof implements Serializable{
	
	String nom;
	String prenom;
	String Email_academique;
	String CNE;
	
	public prof() {
		super();
		// TODO Auto-generated constructor stub
	}

	public prof(String nom, String prenom, String email_academique, String cne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		Email_academique = email_academique;
		this.CNE = cne;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail_academique() {
		return Email_academique;
	}

	public void setEmail_academique(String email_academique) {
		Email_academique = email_academique;
	}

	public String getCNE() {
		return CNE;
	}

	public void setCNE(String cNE) {
		CNE = cNE;
	}
	

}
