package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Stage;
import project.classes.demande;
import project.classes.demandedao;

public class TestDao {

	public static void main(String[] args) throws SQLException {
		StageDaoImpl dao = new StageDaoImpl();
		//int m=Integer.parseInt("pol");
		
		try {
			int m=Integer.parseInt("pol");
			System.out.println(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("hi");
		}
		
		System.out.println("hi");
		
	}
	
}
