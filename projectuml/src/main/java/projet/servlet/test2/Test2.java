package projet.servlet.test2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStageDao;
import dao.StageDaoImpl;
import metier.entities.Stage;
import project.classes.demandedao;
import metier.entities.ligne_stage;
import dao.ligne_stagedao;
import web.StageModel;

//@WebServlet({"/page_responsable","/Test2"})
//@WebServlet({"*.do","/Test2"})
@WebServlet (name="csss",urlPatterns= {"/page_responsable","*.so"})
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStageDao metier;
	
	
	public void init() throws ServletException {
		metier = new StageDaoImpl();
	}
    public Test2() {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		int r;
		if(path.equals("/deletedemande.so"))
		{
			r=Integer.parseInt(request.getParameter("id_demande"));
			demandedao d=new demandedao();
			try {
				d.delete_demande(r);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/TestPrincip.jsp").forward(request, response);
		}
	
		else if (path.equals("/updatedemande.so"))
		{
			r=Integer.parseInt(request.getParameter("id_demande"));
			demandedao d=new demandedao();
			try {
				d.demande_approve(r);
				System.out.println("its updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/TestPrincip.jsp").forward(request, response);
			
		}
		else if (path.equals("/ajoutstage.so"))
		{
			this.getServletContext().getRequestDispatcher("/ajoutstage.jsp").forward(request, response);
		}
		else if (path.equals("/afficher.so")){
			String motCle=request.getParameter("motCle");	
			StageModel model = new StageModel();
			model.setMotCle(motCle);
			List<Stage> stages = metier.StageParMC("%"+motCle+"%");
			model.setStages(stages);
			request.setAttribute("model", model);			
			request.getRequestDispatcher("/TestPrincip.jsp").forward(request, response);
		}

		else
		{
			
			StageModel model = new StageModel();
			model.setMotCle("");
			List<Stage> stages = metier.StageParMC("%");
			model.setStages(stages);
			request.setAttribute("model", model);
			
			this.getServletContext().getRequestDispatcher("/TestPrincip.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		doGet(request,response);
		
	}

}
