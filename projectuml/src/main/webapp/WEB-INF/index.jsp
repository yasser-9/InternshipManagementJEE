<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="FileUploadHandler" method="post" enctype="multipart/form-data">
entrer file name:<input type="text" name="file_name">
                                                <input type="file" name="file2"/>
                                                <input type="submit" value="upload"/>
                                                </form>
</center>

</body>
</html>