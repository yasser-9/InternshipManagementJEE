<%@page import="project.classes.demandedao"
import= "java.util.ArrayList"
import="project.classes.demande" 
import="metier.ligne_stage"
import="dao.ligne_stagedao"
import="java.util.List"
import="dao.StageDaoImpl"
import="metier.entities.ligne_stage"
import="metier.entities.Stage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
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
    <nav class="navbar navbar-light bg-dark" >
        <div class="container-fluid">
          <span class="navbar-brand mb-0 h1" style="color:white">RESPONSABLE DES STAGES</span>
          <button type="button" class="btn btn-danger" onclick=window.location.href='file:///C:/Users/ASUS/Desktop/UML%20PROJET/UML/login.html'><i class="far fa-trash-alt">Se déconnecter</i></button>
        </div>
      </nav>
      <form name="sampleform" >
														<input type="text" name="firstinput" value="" size=20> <small><a href="javascript:showCal('Calendar1')"><input  type="button" name="reserve-direct" value="select date"></a></small>

														</form>
     
    <div class="container px-4">
        <div class="row gx-5">
          <div class="col ">
           <div class="p-3 border bg-light  col1">
               <h3><center>Liste des stages</center></h3>
            <table class="table">   <!--TABLE 1 --------------------------------->
                <thead>
                  <tr>
                    <th scope="col">ID stage</th>
                    <th scope="col">Sujet</th>
                    <th scope="col">Organisme</th>
                    <th scope="col">Date Début</th>
                    <th scope="col">Date Fin</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${model.stages}" var="st">
		              <tr>
				     <th scope="row">${st.id_stage}</th>
				     <td>${st.sujet}</td>
				     <td>${st.organisme}</td>
				     <td>${st.date_debut}</td>
				     <td>${st.date_fin}</td>
				     <td>
				     
                            
                            <a href="ajoutstage.jsp?id_stage=${st.id_stage}" ><button type="button" class="btn btn-danger dd"><i class="far fa-trash-alt">test update</i></button></a>
                            <a href="deletedemande.do? %>" ><button type="button" class="btn btn-danger dd"><i class="far fa-trash-alt">test</i></button></a>
                            
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
                                                <form name="Forme3" action="" method="post" enctype="multipart/form-data">
														<p><strong>sujet:</strong></p>
														<input type="text" name="sujet" value="${st.sujet}" class="textfield-design"/>
														<p><strong>description:</strong></p>
														<input type="text" name="description" value="${st.description}" class="textfield-design"/>
														<p><strong>horaire de stage:</strong></p>
														<input type="text" name="horaire" value="${st.horaire}" class="textfield-design"/>
														<p><strong>date de debut de stage:</strong></p>
														<input type="date" name="champdate" value="" id="datepicker">
														
														<p><strong>Organisme :</strong></p>
														<input type="text" name="organisme" value="" class="textfield-design"/>
														<br/>
														<p>*quand vous confirmer vous recevez un mail qui contient un code en cas de pert de mot de pass.</p>
														<input type="submit" name="add-stage" value="valider" class="bouton-connexion" align="center"/>
														</form>
</div>
</div>

                                            </div>
                                            <div class="modal-footer">
                                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                	 
                	 </td>
		             </tr>
		          </c:forEach>
                </tbody>
              </table>
              <div class="but">
				<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                              AJOUTER
                            </button>            </div>
            </div>
          </div>
          <div class="col">
            <div class="p-3 border bg-light col2">
              <h3><center>Liste des stages en cours</center></h3>
                <table class="table">   <!--TABLE 2 --------------------------------->
                    <thead>
                      <tr>
                        <th scope="col">ID stage</th>
                        <th scope="col">Etudiant</th>
                        <th scope="col">Organisme</th>
                        <th scope="col">Jury</th>
                      </tr>
                    </thead>
                    <tbody>
                     <%
                     ligne_stagedao s= new ligne_stagedao();
					List<ligne_stage> p = s.recuperate_liste();
					for (int i=0;i<p.size();i++)
					{
					%>
		              <tr>
				     <th scope="row"><%=p.get(i).id_ligne_stage %></th>
				     <td><%=p.get(i).etud.nom + p.get(i).etud.prenom %></td>
				     <td><%=p.get(i).stage.getOrganisme() %></td>
				     <td><%=p.get(i).stage.getId_jury() %></td>
		             </tr>
		             <%} %>
		          
                      <tr>
                        <th scope="row">2</th>
                        <td>Jacob Michel</td>
                        <td>Thornton</td>
                        <td>ANOUARI-JAMALI-GHERRABI</td>
                      </tr>
                      <tr>
                        <th scope="row">1</th>
                        <td>Mark Zuckerberg</td>
                        <td>Otto</td>
                        <td>OBADDOU-SOKRI-ELGHALMI</td>
                      </tr>

                    </tbody>
                  </table>
            </div>
            
            <div class="p-3 border bg-light  col2">
              <h3><center>Liste des demandes</center></h3>
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
					demandedao d=new demandedao();
					ArrayList<demande> ld=d.liste_des_demande();
					for (int i=0;i<ld.size();i++)
					{
						System.out.println("la longeur:"+ld.size());
					%>
                      <tr>
                        <th scope="row"><%=ld.get(i).id_demande %></th>
                        <td><%=ld.get(i).nom%></td>
                        <td><%=ld.get(i).prenom%></td>
                        <td><%=ld.get(i).sujet%></td>
                        <td>
                            <a href="updatedemande.do?id_demande=<%=ld.get(i).id_demande %>" ><button type="button" class="btn btn-success dd"><i class="fas fa-edit">OK</i></button></a>
                            <a href="deletedemande.do?id_demande=<%=ld.get(i).id_demande %>" ><button type="button" class="btn btn-danger dd"><i class="far fa-trash-alt">Pas OK</i></button></a>
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
                                                <h4>Nom:</h4> <%=ld.get(i).nom%>
                                                <h4>Prénom:</h4> <%=ld.get(i).prenom%>
                                                <h4>Niveau:</h4><%=ld.get(i).filiere %>
                                                <h4>Date demande de stage:</h4><%=ld.get(i).date_demande %>
                                                <h4>sujet de stage :</h4> <%=ld.get(i).sujet%>
                                            </div>
                                            <div class="modal-footer">
                                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                          </td>
                      </tr>
                      <% }%>
                      
                   
                    </tbody>
                  </table>
            </div>
          </div>
        </div>
      </div>
</html>
    