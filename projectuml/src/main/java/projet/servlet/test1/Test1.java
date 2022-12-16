package projet.servlet.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.classes.connextion_db;
import project.classes.ligne_connexion;

/**
 * Servlet implementation class Test1
 */
//@WebServlet({"/connexion","/Test1"})
//@WebServlet("/connexion")
@WebServlet({"/connexion","/Test1"})
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion_page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ligne_connexion p=null;
		String s=request.getParameter("email");
		String s1=request.getParameter("passs");
		
		connextion_db c=new connextion_db();
		try {
			p=c.test_de_connection(s, s1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (p.status.equals("etud"))
		{
			System.out.println("student connected");
			this.getServletContext().getRequestDispatcher("/WEB-INF/etudiant_interface.jsp").forward(request, response);
			
		}
		if(p==null)
		{
			doGet(request, response);
		}
		else if(p.id_cnx==0)
		{
			System.out.println("responsable connected");
			this.getServletContext().getRequestDispatcher("/page_responsable").forward(request, response);
		}
		else if(p.status=="prof")
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/prof_interface.jsp").forward(request, response);
		}
		else if (p.status.equals("etud"))
		{
			System.out.println("student connected");
			this.getServletContext().getRequestDispatcher("/WEB-INF/etudiant_interface.jsp").forward(request, response);
			
		}
		
		System.out.println(s+"   "+s1);
		
	}

}
