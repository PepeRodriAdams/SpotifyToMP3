<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Spotify playlists</title>
</head>
<body>

<div class="container">
	
		<p class="message">${message}</p>
				
		<table id="userPlaylist">
			<tr>
				<h2>Playlist de usuario</h2>				
			</tr>
			<fieldset id="nombresPlaylists">
			<c:forEach items="${requestScope.names}" var="playlist">
			<c:out value="${playlist}"/><br/>
			</c:forEach>		
			</fieldset>
			<fieldset id="hrefsPlaylists">
			<c:forEach items="${requestScope.hrefs}" var="peticionJson">
			<c:out value="${peticionJson}"/><br/>
			</c:forEach>		
			</fieldset>
			
		</table>
		<p>
	</div>
</body>
</html>
	