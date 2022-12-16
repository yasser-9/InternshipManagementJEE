<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="responsable.css" rel="stylesheet" >
<head>
<script language="javascript" src="cal2.js">
</script>
<script language="javascript" src="cal_conf2.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<div class="formulaire-dinscription">
<form name="Forme3" action="/controleur" method="post" enctype="multipart/form-data">
														<p><strong>sujet:</strong></p>
														<input type="text" name="sujet" value="${stage.sujet}" class="textfield-design"/>
														<p><strong>description:</strong></p>
														<input type="text" name="description" value="${stage.description}" class="textfield-design"/>
														<p><strong>horaire de stage:</strong></p>
														<input type="text" name="horaire" value="${stage.horaire}" class="textfield-design"/>
														<p><strong>jury(entrez le cne de professeur):</strong><p>
														<p><strong>CNE de professeur 1:</strong></p><input type="text" name="prof1" value="${stage.prof1 }" class="textfield-design"/><br/>
														<p><strong>CNE de professeur 2:</strong></p><input type="text" name="prof2" value="${stage.prof2 }" class="textfield-design"/><br/>
														<p><strong>CNE de professeur 3:</strong></p><input type="text" name="prof3" value="${stage.prof3 }" class="textfield-design"/><br/>
														<br/>
														<p><strong>date de debut de stage:</strong></p>
														<form name="sampleform">
														<input type="text" name="firstinput" value="" size=20> <small><a href="javascript:showCal('Calendar1')"><input  type="button" name="reserve-direct" value="select date"></a></small>

														</form>
														<p><strong>date de fin de stage:</strong></p>
														
														
														<p><strong>Organisme :</strong></p>
														<input type="text" name="organisme" value="${stage.organisme}" class="textfield-design"/>
														<br/>
														<p>*quand vous confirmer vous recevez un mail qui contient un code en cas de pert de mot de pass.</p>
														<input type="submit" name="add-stage" value="valider" class="bouton-connexion" align="center"/>
														</form>
</div>
</div>

</body>
</html>