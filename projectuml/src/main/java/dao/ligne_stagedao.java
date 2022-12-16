package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Stage;
import metier.entities.etudiant;
import metier.entities.ligne_stage;

public class ligne_stagedao {
	Connection con;
	Statement st;
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stage", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<ligne_stage> recuperate_liste() throws SQLException
	{

		ArrayList<ligne_stage> l=new ArrayList<ligne_stage>();
		int k=0;
		connect();
		String str="SELECT * FROM ligne_stage l,etudiant e,stage s WHERE l.id_etudiant=e.id_etudiant and l.id_stage=s.id_stage and l.etat_stage=0";
	    java.sql.Statement st=con.createStatement();
		ResultSet r=st.executeQuery(str);
		while(r.next())
		{
			Stage stage=new Stage(r.getInt("id_stage"), r.getString("sujet"),r.getString("desc"), r.getString("horaire"),r.getInt("id_jury"),r.getString("date_debut"),
					r.getString("date_fin"), r.getBoolean("disponibilite"), r.getString("organisme"));
			etudiant e=new etudiant( r.getInt("id_etudiant"),r.getString("nom"), r.getString("prenom"),r.getString("email_academic"),r.getString("code_massar"),r.getString("filiere"));
			ligne_stage d=new ligne_stage(stage,e,r.getInt("id_ligne_stage"),r.getInt("id_rapport"));
			l.add(d);
		}
		st.close();
		return l;
	}

}
