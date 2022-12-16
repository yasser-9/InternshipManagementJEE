package project.classes;

public class ligne_connexion {
	public int id_cnx;
	public String email_academic,mot_de_pass;
	public String status;
	public ligne_connexion(int id_cnx, String email_academic, String mot_de_pass, String status) {
		super();
		this.id_cnx = id_cnx;
		this.email_academic = email_academic;
		this.mot_de_pass = mot_de_pass;
		this.status = status;
	}
	public ligne_connexion()
	{}
	

}
