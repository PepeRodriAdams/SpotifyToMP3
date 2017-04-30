<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>API testing </title>
</head>
<body>


<fieldset id="youtubeInMP3">
<legend>YoutubeInMP3 link for Humble - Kendrik Lamar </legend>

	<td><a href="${inMP3res.link}"/> }">Enlace de descarga</a></td>    

</fieldset>

  
<fieldset id="youtubeInMP32">
<legend>YoutubeInMP3 link for Humble - Kendrik Lamar (2)</legend>

<c:forEach items="${requestScope.inMP3res}" var="inMP3res">
	<c:out value="${inMP3res.link}"/><br/>
</c:forEach>
</fieldset>



</body>
</html>