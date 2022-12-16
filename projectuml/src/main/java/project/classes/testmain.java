package project.classes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public abstract class testmain {

	public static void main(String[] args) throws SQLException {
		demandedao d=new demandedao();
		
		d.delete_demande(2);
		
		
	}

}
