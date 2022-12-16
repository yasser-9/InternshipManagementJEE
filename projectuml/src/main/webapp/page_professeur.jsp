<%@ page  import="metier.entities.etudiant" 
import="dao.etudiantdao"
import="metier.entities.ligne_stage"
import="dao.ligne_stagedao"
import="metier.entities.prof" 
import="dao.professeurdao"
import="java.util.ArrayList"
import="java.util.List"
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% prof p=(prof)request.getAttribute("prof"); %>
<nav class="navbar navbar-light bg-dark" >
	        <div class="container-fluid">
	        <span class="navbar-brand mb-0 h1" style="color:white"><p><%out.println(p.getNom()+ " " +p.getPrenom()); %></p></span>
	        <button type="button" class="btn btn-danger" onclick=window.location.href=''><i class="far fa-trash-alt">Se déconnecter</i></button>
	        </div>
	    </nav>
<div class="col" align="center">
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
                    professeurdao pr=new professeurdao();
                    List<ligne_stage> s=pr.affichage_stage_parcne(p.getCNE());
                    for(int i=0;i<s.size();i++)
                    {
                    %>
                      <tr>
                        <th scope="row"><%=s.get(i).id_ligne_stage %></th>
                        <td><%=s.get(i).etud.nom+s.get(i).etud.prenom %></td>
                        <td><%=s.get(i).stage.getSujet() %></td>
                        <td>
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
                                                <h4>sujet:</h4><%=s.get(i).stage.getSujet() %>
                                                <h4>description:</h4><%=s.get(i).stage.getDescription() %>
                                                <h4>organisme:</h4><%=s.get(i).stage.getOrganisme() %>
                                                <h4>horaire:</h4><%=s.get(i).stage.getHoraire() %>
                                                <h4>date de debut:</h4><%=s.get(i).stage.getDate_debut() %>
                                                <h4>date de fin:</h4><%=s.get(i).stage.getDate_fin() %>
                                                
                                            </div>
                                            <div class="modal-footer">
                                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                      
                          </td>
                      </tr>
                    <%} %>
                       </tbody>
                  </table>
	            </div>

</body>
</html>