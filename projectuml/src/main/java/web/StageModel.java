package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Stage;

public class StageModel {
	
	private String motCle;
	private List<Stage> stages = new ArrayList<Stage>();
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Stage> getStages() {
		return stages;
	}
	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}
	

}
