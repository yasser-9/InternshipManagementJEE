package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Stage;
import metier.entities.etudiant;
import metier.entities.ligne_stage;
import metier.entities.prof;
import metier.entities.rapport;
import project.classes.demande;

public class professeurdao {
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
	public List<ligne_stage> affichage_stage_parcne(String cne_prof) throws SQLException
	{
		ligne_stage d=null;
		connect();
		String str="SELECT * FROM ligne_stage l,etudiant e,stage s,rapport r,jury_prof j WHERE j.id_jury=s.id_jury and l.id_rapport=r.id_rapport and l.id_etudiant=e.id_etudiant and l.id_stage=s.id_stage and etat_stage=0 and l.id_rapport is not null ";
		java.sql.Statement st=con.createStatement();
		ResultSet r=st.executeQuery(str);
		etudiant e=null;
		List<ligne_stage> l=new ArrayList();
		while(r.next())
		{
			if(r.getString("cne_prof1").equals(cne_prof) || r.getString("cne_prof2").equals(cne_prof) || r.getString("cne_prof3").equals(cne_prof))
			{
				rapport t=new rapport(r.getString("nom_rapport"), r.getInt("id_rapport"), r.getFloat("note_final"));
				Stage stage=new Stage(r.getInt("id_stage"), r.getString("sujet"),r.getString("desc"), r.getString("horaire"),r.getInt("id_jury"),r.getString("date_debut"),
						r.getString("date_fin"), r.getBoolean("disponibilite"), r.getString("organisme"));
				e=new etudiant( r.getInt("id_etudiant"),r.getString("nom"), r.getString("prenom"),r.getString("email_academic"),r.getString("code_massar"),r.getString("filiere"));
				d=new ligne_stage(t,stage,e,r.getInt("id_ligne_stage"),r.getInt("id_rapport"));
				l.add(d);
			}
		}
		st.close();
		return l;
	}
	public void add_note(float note,int id_rapport,String cne) throws SQLException
	{
		connect();
		String s1="UPDATE `note` SET note=?,etat_note=1 WHERE id_rapport=? and cneprof=?";
		PreparedStatement st2=con.prepareStatement(s1);
		st2.setFloat(1,note);
		st2.setInt(2,id_rapport);
		st2.setString(3,cne);
		st2.executeUpdate();
		st2.close();
	}
	public void check_note_final(int id_rapport) throws SQLException
	{
		float res=0;
		connect();
		String s1="select count(*) s from note where etat_note=1 and id_rapport=?";
		PreparedStatement st2=con.prepareStatement(s1);
		st2.setInt(1,id_rapport);
		ResultSet r=st2.executeQuery();
		int count_note=r.getInt("s");
		st2.close();
		if(count_note==3)
		{
			connect();
			String s3="select note n from note where etat_note=1 and id_rapport=?";
			PreparedStatement st3=con.prepareStatement(s1);
			st2.setInt(1,id_rapport);
			ResultSet re=st2.executeQuery();
			while(re.next())
			{
				res=res+re.getInt("n");
			}
			float note_final=res/3;
			st2.close();
			connect();
			String s2="UPDATE rapport SET note_final=? WHERE id_rapport=?";
			PreparedStatement st4=con.prepareStatement(s2);
			st4.setFloat(1,note_final);
			st4.setInt(2,id_rapport);
			st4.executeUpdate();
			st4.close();
			
		}
		
		
	}
	public prof get_proffeseur_parcne(String cne) throws SQLException
	{
		prof d=null;
		connect();
		String str="SELECT * FROM professeur";
	    java.sql.Statement st=con.createStatement();
	    //PreparedStatement st=con.prepareStatement(str);
		//st.setInt(1, id_etudiant);
		ResultSet r=st.executeQuery(str);
		while(r.next())
		{
			if(r.getString("cne").equals(cne))
			{
			d=new prof(r.getString("nom"), r.getString("prenom"), r.getString("email_academic"),r.getString("cne"));
			}
		}
		st.close();
		return d;
		
	}


}
