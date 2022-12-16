package metier.entities;

public class ligne_stage {
	public Stage stage;
	public etudiant etud;
	public int id_ligne_stage;
	public int id_rapport;
	public rapport rapport_etud;
	public ligne_stage(Stage stage, etudiant etud, int id_ligne_stage, int id_rapport) {
		super();
		this.stage = stage;
		this.etud = etud;
		this.id_ligne_stage = id_ligne_stage;
		this.id_rapport = id_rapport;
	}
	public ligne_stage(rapport rapport_etud, Stage stage, etudiant etud, int id_ligne_stage, int id_rapport) {
		super();
		this.stage = stage;
		this.etud = etud;
		this.id_ligne_stage = id_ligne_stage;
		this.id_rapport = id_rapport;
		this.rapport_etud=rapport_etud;
	}
	
}
