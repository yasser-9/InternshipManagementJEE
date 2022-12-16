package metier.entities;

public class rapport {
	public String nom_rapport;
	public int id_rapport;
	public float note_final;
	public rapport()
	{}
	public rapport(String nom_rapport, int id_rapport, float note_final) {
		super();
		this.nom_rapport = nom_rapport;
		this.id_rapport = id_rapport;
		this.note_final = note_final;
	}
	

}
