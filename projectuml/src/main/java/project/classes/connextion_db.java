package project.classes;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connextion_db {
	Connection con;
	Statement st;
	public connextion_db()
	{}
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_uml", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ligne_connexion  test_de_connection(String email,String motdepass) throws SQLException
	{
		int k=0;
		ligne_connexion li=null;
		
		
		connect();
		String str="SELECT id_cnx,email_academic,mot_de_pass,status FROM connexion WHERE email_academic=? and mot_de_pass=?";
		PreparedStatement st=con.prepareStatement(str);
		st.setString(1, email);
		st.setString(2, motdepass);
		ResultSet r=st.executeQuery();
		while(r.next())
		{
			li=new ligne_connexion(r.getInt("id_cnx"),r.getString("email_academic"),r.getString("mot_de_pass"),r.getString("status"));
			System.out.println(r.getInt("id_cnx")+r.getString("email_academic")+r.getString("mot_de_pass")+r.getString("status"));
			k++;
		}
		if (k==0) 
		{
			con.close();
			return null;
		}
		else
		{
			con.close();
			return li;
			
		}
		
	}
	
}
