<%@include file="includes/header.jsp"%>


       <div class="android-drawer mdl-layout__drawer">
        <span class="mdl-layout-title">
        </span>
        <nav class="mdl-navigation">
          <a class="mdl-navigation__link" href="LoginController">Inicio</a>
          <div id="buscar2"></div>
          <div class="android-drawer-separator"></div>
          <a class="mdl-navigation__link" href="api.html">Nuestra API REST</a>
          <div class="android-drawer-separator"></div>
         </nav>
      </div>
    <h1>Spotify To Mp3</h1>
	
    <p>¿Alguna vez has intentado descargar las canciones de tus playlists creadas en Spotify 1 a 1 y has muerto de aburrimiento extremo? 
    Sabemos que puede ser algo muy tedioso y por eso hacemos este mashup.Con nuestro mashup puedes hacer log in con tu cuenta de Spotify 
    para acceder a tus listas guardadas y descargar las canciones con 1 solo botón</p>
    <table>
    <tr></tr><br><br>
    	
	<tr> <h2>Búsqueda en spotify</h2>
    	<div id="searchDiv">
			<form id="searchForm" action="SearchController" method="post">
				<input type="text" name="searchQuery" required/> 
				<input type="submit" name="searchBtn" title="busqueda" value="búsqueda">
			</form>
		</div>
	</tr>    
	<div class="container">
	
		<p class="message">${message}</p>
				
		<table id="userSong">
			<tr>
				<h2>Canciones de playlist de usuario</h2>				
			</tr>
			<fieldset id="TitulosCanciones">
			<c:forEach items="${requestScope.names}" var="nombre">
			<c:out value="${nombre}"/><br/>
			<a href = '/DescargaController?query=<c:out value="${nombre}"/>/tracks'> Enlace de descarga de canción correspondiente</a><br>
			</c:forEach>		
			</fieldset>
	<%-- 		<fieldset id="BusquedaCanciones">
			<c:forEach items="${requestScope.busqueda}" var="busqueda">
			<a href = '/DescargaController?query=<c:out value="${busqueda}"/>/tracks'> Enlace de descarga de canción correspondiente</a><br>
			</c:forEach>		
			</fieldset>
 --%>			
		</table>
		<p>
	</div>
	

<%@include file="includes/header.jsp"%>
