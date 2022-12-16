package metier.entities;

import java.io.Serializable;
import java.sql.Date;

public class Stage implements Serializable{
	
	//-Attributes
	private int id_stage ;
	private String sujet;
	private String description;
	private String horaire;
	private int id_jury;
	private String date_debut;
	private String date_fin;
	private boolean disponibilite;
	private String organisme;
	
	//-Constructor

	public Stage(int id_stage, String sujet, String description, String horaire, int id_jury, String date_debut,
			String date_fin, boolean disponibilite, String organisme) {
		super();
		this.id_stage = id_stage;
		this.sujet = sujet;
		this.description = description;
		this.horaire = horaire;
		this.id_jury = id_jury;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.disponibilite = disponibilite;
		this.organisme = organisme;
	}


	public Stage(String sujet, String description, String horaire, int id_jury, String date_debut, String date_fin,
			boolean disponibilite, String organisme) {
		super();
		this.sujet = sujet;
		this.description = description;
		this.horaire = horaire;
		this.id_jury = id_jury;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.disponibilite = disponibilite;
		this.organisme = organisme;
	}
	
	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//---------------

	//Getters and setters
	

	

	public int getId_stage() {
		return id_stage;
	}


	public void setId_stage(int id_stage) {
		this.id_stage = id_stage;
	}


	public String getSujet() {
		return sujet;
	}


	public void setSujet(String sujet) {
		this.sujet = sujet;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getHoraire() {
		return horaire;
	}


	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}


	public int getId_jury() {
		return id_jury;
	}


	public void setId_jury(int id_jury) {
		this.id_jury = id_jury;
	}


	public String getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}


	public String getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}


	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	public String getOrganisme() {
		return organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}
	
	//To_string
	
	@Override
	public String toString() {
		return "Stage [id_stage=" + id_stage + ", sujet=" + sujet + ", description=" + description + ", horaire="
				+ horaire + ", id_jury=" + id_jury + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", disponibilite=" + disponibilite + ", organisme=" + organisme + "]";
	}

}
