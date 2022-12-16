<%@ page import="metier.entities.etudiant" 
import="dao.etudiantdao"
import="metier.entities.ligne_stage"
import="dao.ligne_stagedao"
import="project.classes.demande"
import="dao.StageDaoImpl"
import="metier.entities.Stage"
import="java.util.ArrayList"
import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Insert title here</title>
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="IndexResponsableStyle.css" rel="stylesheet" >
        
        <script language="javascript" src="cal2.js">
</script>
<script language="javascript" src="cal_conf2.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="responsable.css" rel="stylesheet" >
    <!--  <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="//resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
</head>
<body>
		<nav class="navbar navbar-light bg-dark" >
	        <div class="container-fluid">
	        <% etudiant e=(etudiant)request.getAttribute("etud"); %>
	        <span class="navbar-brand mb-0 h1" style="color:white"><p><%out.println(e.nom+ " " +e.prenom); %></p></span>
	        <button type="button" class="btn btn-danger" onclick=window.location.href=''><i class="far fa-trash-alt">Se déconnecter</i></button>
	        </div>
	    </nav>
	    
	    <div class="container px-4">
	
	        <div class="row gx-5 nnn">
	
	          <div class="col col1">
	                <div class="p-3 border bg-light">
	
	                        <nav class="navbar navbar-expand-lg navbar-light bg-light">
	                            <div class="collapse navbar-collapse" id="navbarNav">
	                                <ul class="navbar-nav">
	                                    <li class="nav-item active">
	                                        <a class="nav-link" href="index.do">Home</a>
	                                    </li>
	                                    <li class="nav-item">
	                                        <a class="nav-link" href="saisie.do">Saisie</a>
	                                    </li>
	                                </ul>
	                            </div>
	                        </nav>
	                        <p></p>
	
	                         <div class="container yyyy">
	                            <div class="card yyy">
	                                <div class="card-header">
	                                      Recherche des stages
	                                </div>
	                                <div class="card-body xxx">
	                                    <div class="vvv">
	                                        <center>
	                                            <form action="afficher.do" method="get">
	                                            <label>Sujet: </label>
	                                            <input type="text" name="motCle" value="${model.motCle}"/>
	                                            <button type="submit" class="btn btn-primary"> Chercher</button>
	                                            </form>
	                                        </center> 
	                                    </div>
	                                    <table class="table table-striped">
	                                        <tr>
	                                        	<th>ID</th><th>Sujet</th><th>Organisme</th><th>Date Début</th><th>demander</th>
	                                        </tr>

									       <c:forEach items="${model.stages}" var="st">
									         <tr>
									            <td>${st.id_stage}</td>
									            <td>${st.sujet}</td>
									            <td>${st.organisme}</td>
									            <td>${st.date_debut}</td>
									            <td><a onclick="return confirm('Etes-vous sûr ?')" href="demander_stage.do?id=${st.id_stage}">Demander</a></td>
									            
									         </tr>
									       </c:forEach>                                   
	                                               
	                                    </table>
	                                </div>
	                            </div>
	                        </div>
	                </div>
	          </div>
	
	          <!--<div class="col col2">-->
	          <div class="col">
	            <div class="p-3 border bg-light">
	            <h3><center>stages en cours</center></h3>
                <table class="table">   <!--TABLE 2 --------------------------------->
                    <thead>
                      <tr>
                        <th scope="col">ID stage</th>
                        <th scope="col">Etudiant</th>
                        <th scope="col">Sujet</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                    <%
                    etudiantdao et=new etudiantdao();
                    ligne_stage s=et.affichage_stage_encours(e.id_etudiant);
                    if(s!=null)
                    {
                    %>
                      <tr>
                        <th scope="row"><%=s.id_ligne_stage %></th>
                        <td><%=s.etud.nom+s.etud.prenom %></td>
                        <td><%=s.stage.getSujet() %></td>
                        <td>
                         <!--   <button type="button" class="btn btn-primary"onclick=window.location.href='file:///C:/Users/ASUS/Desktop/UML%20PROJET/UML/DetailDemand.html#exampleModalToggle'>Détail</button> -->
                           <a href="affichage_stage_courant.do?id_etudiant=<%=s.etud.id_etudiant %>"><button type="button" class="btn btn-primary">
                            Détail
                            </button></a>
                            
                          </td>
                      </tr>
                    <%} %>
                       </tbody>
                  </table>
	            </div>
	            <div class="p-3 border bg-light col2">
              <h3><center>Liste de demandes</center></h3>
                <table class="table">   <!--TABLE 3 --------------------------------->
                    <thead>
                      <tr>
                        <th scope="col">ID demande</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Prénom</th>
                        <th scope="col">Filière</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                      
                      <%
                      etudiantdao etu=new etudiantdao();
                      List<demande> de=etu.affichagerdemande(e.id_etudiant);
                      StageDaoImpl sd=new StageDaoImpl();
                      
                      for(int j=0;j<de.size();j++)
                      {
                    	Stage t=sd.getStage(de.get(j).id_stage);
                      %>
                    <tr>
                        <th scope="row"><%=de.get(j).id_demande %></th>
                        <td><%=de.get(j).nom%></td>
                        <td><%=de.get(j).prenom %></td>
                        <td><%=de.get(j).filiere %></td>
                        <td>
                            <a onclick="return confirm('Etes-vous sûr ?')" href="accepter_stage.do?id=<%=de.get(j).id_demande%>"><button type="button" class="btn btn-success dd"><i class="fas fa-edit">OK</i></button></a>
                            <a onclick="return confirm('Etes-vous sûr ?')" href="refuser_stage.do?id=<%=de.get(j).id_demande%>"><button type="button" class="btn btn-danger dd"><i class="far fa-trash-alt">Pas OK</i></button></a>
                         <!--   <button type="button" class="btn btn-primary"onclick=window.location.href='file:///C:/Users/ASUS/Desktop/UML%20PROJET/UML/DetailDemand.html#exampleModalToggle'>Détail</button> -->
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                              Détail
                            </button>
                              <!-- Modal -->
                                      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                          <div class="modal-content">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="exampleModalLabel">Détails de la demande</h5>
                                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <h4>sujet:</h4><%=de.get(j).sujet %>
                                                <h4>description:</h4><%=t.getDescription() %>
                                                <h4>organisme:</h4><%=t.getOrganisme() %>
                                                <h4>horaire:</h4><%=t.getHoraire() %>
                                                <h4>date de debut:</h4><%=t.getDate_debut() %>
                                                <h4>date de fin:</h4><%=t.getDate_fin() %>
                                                
                                            </div>
                                            <div class="modal-footer">
                                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                      
                          </td>
                          </tr>
                          <% } %>
                      </tbody>
	          </div>
	          
	
	        </div>
	</div>
	      </div>
</body>
</html>