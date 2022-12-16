package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import metier.entities.Stage;

public class StageDaoImpl implements IStageDao{

	@Override
	public Stage save(Stage st) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `stage` ( `Sujet`, `Desc`, `horaire`, `Id_jury`, `Date_debut`, `Date_fin`, `Disponibilite`, `Organisme`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			
			ps.setString(1, st.getSujet());
			ps.setString(2, st.getDescription());
			ps.setString(3, st.getHoraire());
			ps.setInt(4, st.getId_jury());	
			ps.setDate(5, java.sql.Date.valueOf(st.getDate_debut()));
			ps.setDate(6, java.sql.Date.valueOf(st.getDate_fin()));
			//ps.setDate(5, st.getDate_debut());
			//ps.setDate(6, st.getDate_fin());
			ps.setBoolean(7, st.isDisponibilite());
			ps.setString(8, st.getOrganisme());
			
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(Id_stage) AS MAX_ID FROM STAGE");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				st.setId_stage(rs.getInt("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public List<Stage> StageParMC(String mc) {
		Connection connection = SingletonConnection.getConnection();
		List<Stage> stage = new ArrayList();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM STAGE WHERE SUJET LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Stage st = new Stage();
				st.setId_stage(rs.getInt("ID_stage"));
				st.setSujet(rs.getString("Sujet"));
				st.setDescription(rs.getString("Desc"));
				st.setHoraire(rs.getString("horaire"));
				st.setId_jury(rs.getInt("Id_jury"));
				st.setDate_debut(rs.getString("Date_debut"));
				st.setDate_fin(rs.getString("Date_fin"));
				st.setDisponibilite(rs.getBoolean("Disponibilite"));
				st.setOrganisme(rs.getString("Organisme"));
				stage.add(st);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stage;
	}

	@Override
	public Stage getStage(int id) {
		   Connection conn=SingletonConnection.getConnection();
		    Stage st = new Stage();
	       try {
			//PreparedStatement ps= conn.prepareStatement("select * from stage");
			//java.sql.Statement s=conn.createStatement("select * from stage");
			
			PreparedStatement ps2 = conn.prepareStatement("select * from stage");
			ResultSet rs = ps2.executeQuery();
			if  (rs.next()) {
				if(rs.getInt("id_stage")==id)
				{
				st.setId_stage(rs.getInt("ID_stage"));
				st.setSujet(rs.getString("Sujet"));
				st.setDescription(rs.getString("Desc"));
				st.setHoraire(rs.getString("horaire"));
				st.setId_jury(rs.getInt("Id_jury"));
				st.setDate_debut(rs.getString("Date_debut"));
				st.setDate_fin(rs.getString("Date_fin"));
				st.setDisponibilite(rs.getBoolean("Disponibilite"));
				st.setOrganisme(rs.getString("Organisme"));	
				}
			}
			ps2.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	       
			return st;
	}

	@Override
	public Stage update(Stage st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStage(int id) {
		// TODO Auto-generated method stub
		
	}

}


//public class ProduitDaoImpl implements IProduitDao