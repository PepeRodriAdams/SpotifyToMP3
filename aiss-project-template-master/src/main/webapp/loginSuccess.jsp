<%@include file="includes/header.jsp"%>
	<style>
     #paginacion {
  		border: 1px solid #CCC;
 		background-color: #E0E0E0;
 		padding: .5em;
		}
		.derecha   { float: right; }
		.izquierda { float: left;  }
	</style> 
       <div class="android-drawer mdl-layout__drawer">
        <span class="mdl-layout-title">
        </span>
        <nav class="mdl-navigation">
          <a class="mdl-navigation__link" href="LoginController"><span class="izquierda"><img src="images/logo.jpg" alt="Logo SpotifyToMP3" width="100" height="100"/></span></a>
          <div id="buscar2"></div>
          <div class="android-drawer-separator"></div>
          <a class="mdl-navigation__link" href="api.html"><span class="derecha">Nuestra API REST</span></a>
          <div class="android-drawer-separator"></div>
         </nav>
      </div>
    <h1>Spotify To Mp3</h1>
	
    <p>¿Alguna vez has intentado descargar las canciones de tus playlists creadas en Spotify 1 a 1 y has muerto de aburrimiento extremo? 
    Sabemos que puede ser algo muy tedioso y por eso hacemos este mashup.Con nuestro mashup puedes hacer log in con tu cuenta de Spotify 
    para acceder a tus listas guardadas y descargar las canciones con 1 solo botón</p>
    <table> 
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
				
		<table id="userPlaylist">
			<tr>
				<h2>Playlist de usuario</h2>				
			</tr>
			<a href="https://www.informatica.us.es/"><fieldset id="nombresPlaylists">
			<c:forEach items="${requestScope.names}" var="playlist">
			<c:out value="${playlist}"/><br/>
			</c:forEach>		
			</fieldset></a>
			
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
	