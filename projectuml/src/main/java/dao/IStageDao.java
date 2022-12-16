package dao;

import java.util.List;

import metier.entities.Stage;

public interface IStageDao {
	public Stage save(Stage st);
	public List<Stage> StageParMC(String mc);
	public Stage getStage(int st);
	public Stage update(Stage st);
	public void deleteStage(int id);
}
