package project.classes;

public class demande {
	public int id_etudiant,id_demande,id_stage;
	public int etat;
	public String nom,prenom,sujet,date_demande,filiere;
	public demande(int id_etudiant, int id_demande, int id_stage, int etat) {
		super();
		this.id_etudiant = id_etudiant;
		this.id_demande = id_demande;
		this.id_stage = id_stage;
		this.etat = etat;
	}
	public demande()
	{}
	public demande(int id_etudiant,int id_stage,int id_demande, String sujet,int etat, String nom, String prenom,String date_demande,String filiere) {
		super();
		
		this.id_demande = id_demande;
		this.etat = etat;
		this.nom = nom;
		this.prenom = prenom;
		this.sujet = sujet;
		this.date_demande=date_demande;
		this.filiere=filiere;
		this.id_etudiant=id_etudiant;
		this.id_stage=id_stage;
	}
	public demande(int id_demande, String sujet,int etat, String nom, String prenom,String date_demande,String filiere) {
		super();
		
		this.id_demande = id_demande;
		this.etat = etat;
		this.nom = nom;
		this.prenom = prenom;
		this.sujet = sujet;
		this.date_demande=date_demande;
		this.filiere=filiere;
		
	}

	

}
