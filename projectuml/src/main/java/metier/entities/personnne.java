package metier.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class personnne {
	public String nom,prenom,cne;
	public String email_academic;
	public void personne()
	{}
	public personnne(String nom, String prenom, String email_academic) {
		this.nom = nom;
		this.prenom = prenom;
		this.email_academic = email_academic;
		
	}
	public personnne() {
		// TODO Auto-generated constructor stub
	}
	

}
