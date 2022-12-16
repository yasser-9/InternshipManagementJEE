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
import project.classes.demande;

public class etudiantdao {
	

	
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
		public etudiant getetudiant(int id_etudiant) throws SQLException
		{
			etudiant d=null;
			connect();
			String str="SELECT * FROM etudiant";
		    java.sql.Statement st=con.createStatement();
		    //PreparedStatement st=con.prepareStatement(str);
			//st.setInt(1, id_etudiant);
			ResultSet r=st.executeQuery(str);
			while(r.next())
			{
				if(r.getInt("id_etudiant")==id_etudiant)
				{
				d=new etudiant(r.getInt("id_etudiant"),r.getString("nom"), r.getString("prenom"), r.getString("email_academic"),r.getString("code_massar"),r.getString("filiere"));
				}
			}
			st.close();
			return d;
		}
		public ligne_stage affichage_stage_encours(int idetudiant) throws SQLException
		{
			ligne_stage d=null;
			connect();
			String str="SELECT * FROM ligne_stage l,etudiant e,stage s WHERE l.id_etudiant=e.id_etudiant and l.id_stage=s.id_stage and etat_stage=0 ";
			java.sql.Statement st=con.createStatement();
			ResultSet r=st.executeQuery(str);
			etudiant e=null;
			while(r.next())
			{
				if(r.getInt("id_etudiant")==idetudiant)
				{
				Stage stage=new Stage(r.getInt("id_stage"), r.getString("sujet"),r.getString("desc"), r.getString("horaire"),r.getInt("id_jury"),r.getString("date_debut"),
						r.getString("date_fin"), r.getBoolean("disponibilite"), r.getString("organisme"));
				e=new etudiant( r.getInt("id_etudiant"),r.getString("nom"), r.getString("prenom"),r.getString("email_academic"),r.getString("code_massar"),r.getString("filiere"));
				d=new ligne_stage(stage,e,r.getInt("id_ligne_stage"),r.getInt("id_rapport"));
				}
			}
			st.close();
			return d;
			
			
		}
		public demande affdemande(int id_etudiant) throws SQLException
		{
			int k=0;
			connect();
			String str="SELECT e.nom nom,e.id_etudiant ide,s.id_stage ids, e.prenom prenom, l.etat etat, l.id_demande iddemande,s.sujet sujet,l.date_demande datedemande,e.filiere filiere FROM liste_demande l,etudiant e,stage s WHERE l.id_etudiant=e.id_etudiant and l.id_stage=s.id_stage and l.etat=1";
		    java.sql.Statement st=con.createStatement();
			ResultSet r=st.executeQuery(str);
			demande d=null;
			while(r.next())
			{
				d=new demande(r.getInt("ide"),r.getInt("ids"),r.getInt("iddemande"), r.getString("sujet"),r.getInt("etat"), r.getString("nom"), r.getString("prenom"),r.getString("datedemande"),r.getString("filiere"));
				
				k++;
			}
			st.close();
			return d;
		}
		public List<demande> affichagerdemande(int id_etudiant) throws SQLException
		{
			int k=0;
			connect();
			String str="SELECT e.nom nom,e.id_etudiant ide,s.id_stage ids, e.prenom prenom, l.etat etat, l.id_demande iddemande,s.sujet sujet,l.date_demande datedemande,e.filiere filiere FROM liste_demande l,etudiant e,stage s WHERE l.id_etudiant=e.id_etudiant and l.id_stage=s.id_stage and l.etat=1";
		    java.sql.Statement st=con.createStatement();
			ResultSet r=st.executeQuery(str);
			//demande d=null;
			List<demande> l=new ArrayList();
			while(r.next())
			{
				demande d=new demande(r.getInt("ide"),r.getInt("ids"),r.getInt("iddemande"), r.getString("sujet"),r.getInt("etat"), r.getString("nom"), r.getString("prenom"),r.getString("datedemande"),r.getString("filiere"));
				l.add(d);
				k++;
			}
			st.close();
			return l;
		}
		public void accepter_demande(demande d) throws SQLException
		{
			ligne_stage sr=this.affichage_stage_encours(d.id_etudiant);
			if(sr==null)
			{
				connect();
				String str="INSERT INTO `ligne_stage`( `id_etudiant`, `id_stage`, `etat_stage`) VALUES (?,?,0)";
				PreparedStatement st=con.prepareStatement(str);
				st.setInt(1,d.id_etudiant);
				st.setInt(2,d.id_stage);
				st.executeUpdate();
				st.close();
				connect();
				String s="DELETE FROM `liste_demande` WHERE id_demande=?";
				PreparedStatement st1=con.prepareStatement(s);
				st1.setInt(1,d.id_demande);
				st1.executeUpdate();
				st1.close();
			}
			else
			{
				System.out.println("you can not accepte the demande you are already in a stage!!!");
				connect();
				String s="DELETE FROM `liste_demande` WHERE id_demande=?";
				PreparedStatement st1=con.prepareStatement(s);
				st1.setInt(1,d.id_demande);
				st1.executeUpdate();
				st1.close();
			}
		}
		public void delete_stage(demande d) throws SQLException
		{
			connect();
			String s="DELETE FROM `liste_demande` WHERE id_demande=?";
			PreparedStatement st1=con.prepareStatement(s);
			st1.setInt(1,d.id_demande);
			st1.executeUpdate();
			st1.close();
		}
		public void demander_stage(int idetudiant,int idstage) throws SQLException
		{
			int k=0;
			connect();
			String str="SELECT * FROM ligne_stage";
			java.sql.Statement st=con.createStatement();
			//PreparedStatement st=con.prepareStatement(str);
			//st.setInt(1,0);
			//st.setInt(1,idetudiant);
			//st.setInt(2,idstage);
			
			ResultSet r=st.executeQuery(str);
			//System.out.println("we are in"+r.getInt("s"));
			
			while(r.next())
			{
				if(r.getInt("id_etudiant")==idetudiant && r.getInt("etat_stage")==0)
				{
					System.out.println("we are in");
					//System.out.println("we are in");
					k++;
				}
				
			}
			
			st.close();
			
			if(k==0)
			{
				connect();
				String s="INSERT INTO liste_demande(id_etudiant,id_stage, etat,date_demande) VALUES (?,?,0,sysdate()) ";
				PreparedStatement st1=con.prepareStatement(s);
				st1.setInt(1,idetudiant);
				st1.setInt(2,idstage);
				st1.executeUpdate();
				st1.close();
				
			}
			else
			{
				System.out.println("demande refuser");
			}
			
			
		}
		public void update_rapport(int id_ligne_stage,String nom_rapport) throws SQLException
		{
			int k=0;
			connect();
			String s="INSERT INTO rapport(nom_rapport) VALUES (?)";
			PreparedStatement st1=con.prepareStatement(s);
			st1.setString(1,nom_rapport);
			st1.executeUpdate();
			st1.close();
			k=return_id_rapport(nom_rapport);
			connect();
			String s1="UPDATE ligne_stage SET id_rapport=? WHERE id_ligne_stage=?";
			PreparedStatement st2=con.prepareStatement(s1);
			st2.setInt(1,k);
			st2.setInt(2,id_ligne_stage);
			st2.executeUpdate();
			st2.close();
			update_table_note(k);
			
		}
		public void update_table_note(int id_rapport) throws SQLException
		{
			connect();
			String str="SELECT * FROM ligne_stage l,stage s,jury_prof j WHERE j.id_jury=s.id_jury and l.id_stage=s.id_stage and etat_stage=0 and l.id_rapport=? ";
			PreparedStatement st1=con.prepareStatement(str);
			st1.setInt(1,id_rapport);
			ResultSet r=st1.executeQuery();
			String prof1=null;
			String prof2=null;
			String prof3=null;
			while(r.next())
			{
				prof1=r.getString("cne_prof1");
				prof2=r.getString("cne_prof2");
				prof3=r.getString("cne_prof3");
			}
			st1.close();
			add_attribute_table_note(id_rapport,prof1);
			add_attribute_table_note(id_rapport,prof2);
			add_attribute_table_note(id_rapport,prof3);
			
			
		}
		public void add_attribute_table_note(int id_rapport,String cne) throws SQLException
		{
			connect();
			String str2="INSERT INTO note(id_rapport,note,etat_note,cneprof) VALUES (?,0,0,?)";
			PreparedStatement st2=con.prepareStatement(str2);
			st2.setInt(1,id_rapport);
			st2.setString(2,cne);
			st2.executeUpdate();
			st2.close();
			
		}
		public int return_id_rapport(String nom_rapport) throws SQLException
		{
			connect();
			String s="select id_rapport,nom_rapport from rapport";
			PreparedStatement st1=con.prepareStatement(s);
			//st1.setString(1,nom_rapport);
			ResultSet r=st1.executeQuery(s);
			int k=0;
			while(r.next())
			{
				if(nom_rapport.equals(r.getString("nom_rapport")))
				{
					k=r.getInt("id_rapport");
				}
			}
			st1.close();
			return k;
			
		}
		public void deletstage(int id_ligne_stage) throws SQLException 
		{
			connect();
			String s1="DELETE FROM `ligne_stage` WHERE id_ligne_stage=?";
			PreparedStatement st2=con.prepareStatement(s1);
			st2.setInt(1,id_ligne_stage);
			st2.executeUpdate();
			st2.close();
		}

}
