package project.servlet.etudiant;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import dao.IStageDao;
import dao.StageDaoImpl;
import dao.etudiantdao;
import metier.entities.Stage;
import metier.entities.etudiant;
import metier.entities.ligne_stage;
import project.classes.demande;
import web.StageModel;


@WebServlet (name="cs",urlPatterns= {"/servletetudiant","*.do"})
public class servletetudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStageDao metier;
	public etudiant e;
	
	
	
	public void init() throws ServletException {
		metier = new StageDaoImpl();
	}

    public servletetudiant() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path=request.getServletPath();
		if (path.equals("/afficher.do")){
			String motCle=request.getParameter("motCle");	
			StageModel model = new StageModel();
			model.setMotCle(motCle);
			List<Stage> stages = metier.StageParMC("%"+motCle+"%");
			model.setStages(stages);
			request.setAttribute("model", model);	
			request.setAttribute("etud", e);
			request.getRequestDispatcher("page_etudiant.jsp").forward(request, response);
		}
		else if (path.equals("/demander_stage.do"))
		{
			
			int r=Integer.parseInt(request.getParameter("id"));
			etudiantdao d= new etudiantdao();
			try {
				
				d.demander_stage(e.id_etudiant, r);
				System.out.println("we are in try");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("etud", e);
			request.getRequestDispatcher("page_etudiant.jsp").forward(request, response);
			
		}
		else if (path.equals("/delete_stage_courant.do"))
		{
			int r=Integer.parseInt(request.getParameter("id"));
			etudiantdao d= new etudiantdao();
			try {
				d.deletstage(r);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("etud", e);
			request.getRequestDispatcher("page_etudiant.jsp").forward(request, response);
		}
		else if(path.equals("/affichage_stage_courant.do"))
		{
			etudiantdao et=new etudiantdao();
			ligne_stage s=null;
			int c=Integer.parseInt(request.getParameter("id_etudiant"));
            try {
				s=et.affichage_stage_encours(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ligne_stage l=(ligne_stage) request.getAttribute("l_stage");
			request.setAttribute("d", s);
			
			request.getRequestDispatcher("Stage_courant.jsp").forward(request, response);
		}
		else if(path.equals("/accepter_stage.do"))
		{
			etudiantdao et=new etudiantdao();
			int c=Integer.parseInt(request.getParameter("id"));
			demande r=null;
			try {
				r = et.affdemande(e.id_etudiant);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				et.accepter_demande(r);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("etud", e);
			this.getServletContext().getRequestDispatcher("/page_etudiant.jsp").forward(request, response);
		}
		else if(path.equals("/refuser_stage.do"))
		{
			etudiantdao et=new etudiantdao();
			int c=Integer.parseInt(request.getParameter("id"));
			demande r=null;
			try {
				r = et.affdemande(e.id_etudiant);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				et.delete_stage(r);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("etud", e);
			this.getServletContext().getRequestDispatcher("/page_etudiant.jsp").forward(request, response);
			
		}
		else
		{
			e=new etudiant();
			try {
				e=(new etudiantdao()).getetudiant(1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("etud", e);
			System.out.println(e.id_etudiant);
			this.getServletContext().getRequestDispatcher("/page_etudiant.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
		
		doGet(request, response);
	}

}
