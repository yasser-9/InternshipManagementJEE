<%@ page import="metier.entities.ligne_stage" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

.formulaire-dinscription
{
	position:relative;
	text-align:center;
	background-color:white;
	margin:90px;
	padding:20px;
	box-shadow: 6px 6px 6px black;
	width:75%;
}
body{
background-color:white;
}
.style_photo{
width:10%;
heigth:10%;
}
.pos{
position:absolute;
float:right;
}
</style>
</head>
<body>
<div class="formulaire-dinscription">
<% ligne_stage s=(ligne_stage)request.getAttribute("d"); 
if(s!=null)
{%>
<div align="center">
 <div class="pos">
                                                <p><strong>Prénom : </strong>  <i><%=s.etud.prenom %></i></p>
                                                <p><strong>Niveau:   </strong>  <i> <%=s.etud.filiere %></i></p>
                                                <p><strong>CNE:    </strong>  <i><%=s.etud.cne %></i></p>
                                                <p><strong>Email académique:    </strong>  <i><%=s.etud.email_academic %></i></p>
                                                
                                                <%if(s.id_rapport==0){ %>
                                                <form action="FileUploadHandler?id=<%=s.id_ligne_stage %>" method="post" enctype="multipart/form-data">
													entrer file name:<input type="text" name="file_name"><br/>
                                                <input type="file" name="file2"/>
                                                <input type="submit" value="upload" class="btn btn-success dd"/>
                                                </form>
                                                
                                                <!--  <span><a onclick="return confirm('Etes-vous sûr ?')" href="demander_stage.do?id=${st.id_stage}"><button type="button" class="btn btn-success dd"><i class="fas fa-edit">Signaler fin de stage</i></button></a>-->
                            					<a onclick="return confirm('Etes-vous sûr ?')" href="delete_stage_courant.do?id=<%=s.id_ligne_stage%>"><button type="button" class="btn btn-danger dd"><i class="far fa-trash-alt">quitter le stage</i></button></a>
                            					
                            					<%}
                            					else{%>
                            					<div class="style_photo">
                            					<img  src="Téléchargements/1200px-PDF_file_icon.svg"/>
                            					</div>
                            					<a href="">telecharger</a>
                            					<%} %>
                            					</div>
                                                <h4>detail de stage:</h4>
                                                <p><strong>sujet:  </strong>  <i><%=s.stage.getSujet() %></i></p>
                                                <p><strong>description:   </strong>  <i><%=s.stage.getDescription() %></i></p>
                                                <p><strong>organisme:  </strong>  <i><%=s.stage.getOrganisme() %></i></p>
                                                <p><strong>horaire:   </strong>  <i><%=s.stage.getHoraire() %></i></p>
                                                <p><strong>date de debut:  </strong>  <i><%=s.stage.getDate_debut() %></i></p>
                                                <p><strong>date de fin:   </strong>  <i><%=s.stage.getDate_fin() %></i></p>
                                               
                            					
<%} %>
</div>
</div>

</body>
</html>