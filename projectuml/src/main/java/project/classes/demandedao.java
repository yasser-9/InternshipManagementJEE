package project.classes;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class demandedao {
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
	public ArrayList<demande> liste_des_demande() throws SQLException
	{
		ArrayList<demande> l=new ArrayList<demande>();
		int k=0;
		connect();
		String str="SELECT e.nom nom, e.prenom prenom, l.etat etat, l.id_demande iddemande,s.sujet sujet,l.date_demande datedemande,e.filiere filiere FROM liste_demande l,etudiant e,stage s WHERE l.id_etudiant=e.id_etudiant and l.id_stage=s.id_stage and l.etat=0";
	    java.sql.Statement st=con.createStatement();
		ResultSet r=st.executeQuery(str);
		while(r.next())
		{
			demande d=new demande(r.getInt("iddemande"), r.getString("sujet"),r.getInt("etat"), r.getString("nom"), r.getString("prenom"),r.getString("datedemande"),r.getString("filiere"));
			l.add(d);
		}
		st.close();
		return l;
		
	}
	public void delete_demande(int iddemande) throws SQLException
	{
		connect();
		String str="DELETE FROM liste_demande WHERE id_demande=?";
		PreparedStatement st=con.prepareStatement(str);
		st.setInt(1, iddemande);
		st.executeUpdate();
		st.close();
		
	}
	public void demande_approve(int iddemande) throws SQLException
	{
		connect();
		String str="UPDATE liste_demande SET etat=1 WHERE id_demande=?";
		PreparedStatement st=con.prepareStatement(str);
		st.setInt(1, iddemande);
		st.executeUpdate();
		st.close();
		
		
	}
	

}
