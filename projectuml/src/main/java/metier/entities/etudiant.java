package metier.entities;

public class etudiant extends personnne{
	public String code_massar,filiere;
	public int id_etudiant;

	public etudiant( int id_etudiant,String nom, String prenom, String email_academic, String code_massar, String filiere) {
		super(nom, prenom, email_academic);
		this.code_massar = code_massar;
		this.filiere = filiere;
		this.id_etudiant=id_etudiant;
	}

	public etudiant(String nom, String prenom, String email_academic) {
		super(nom, prenom, email_academic);
	}
	public etudiant()
	{
		super();
	}
	

	
	

	
}
