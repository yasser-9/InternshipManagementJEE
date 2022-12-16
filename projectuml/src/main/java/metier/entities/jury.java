package metier.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class jury implements Serializable{
	
	private int id_jury;
	private String cne_prof1;
	private String cne_prof2;
	private String cne_prof3;
	public int getId_jury() {
		return id_jury;
	}
	public void setId_jury(int id_jury) {
		this.id_jury = id_jury;
	}
	public String getCne_prof1() {
		return cne_prof1;
	}
	public void setCne_prof1(String cne_prof1) {
		this.cne_prof1 = cne_prof1;
	}
	public String getCne_prof2() {
		return cne_prof2;
	}
	public void setCne_prof2(String cne_prof2) {
		this.cne_prof2 = cne_prof2;
	}
	public String getCne_prof3() {
		return cne_prof3;
	}
	public void setCne_prof3(String cne_prof3) {
		this.cne_prof3 = cne_prof3;
	}
	@Override
	public String toString() {
		return "jury [id_jury=" + id_jury + ", cne_prof1=" + cne_prof1 + ", cne_prof2=" + cne_prof2 + ", cne_prof3="
				+ cne_prof3 + "]";
	}
	public jury(int id_jury, String cne_prof1, String cne_prof2, String cne_prof3) {
		super();
		this.id_jury = id_jury;
		this.cne_prof1 = cne_prof1;
		this.cne_prof2 = cne_prof2;
		this.cne_prof3 = cne_prof3;
	}
	public jury() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
