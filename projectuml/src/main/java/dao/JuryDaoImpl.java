package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.entities.jury;

public class JuryDaoImpl implements IJuryDao {

	@Override
	public jury save(jury jr) {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `jury_prof` (`cne_prof1`, `cne_prof2`, `cne_prof3`) VALUES ('?', '?', '?');");
			
			ps.setString(1, jr.getCne_prof1());
			ps.setString(2, jr.getCne_prof2());
			ps.setString(3, jr.getCne_prof3());

			ps.executeUpdate();
			/*PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(Id_jury) AS MAX_ID FROM jury_prof");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				jr.setId_jury(rs.getInt("MAX_ID"));
			}*/
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jr;
	}

}
