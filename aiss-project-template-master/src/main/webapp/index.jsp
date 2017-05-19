<%@include file="includes/header.jsp"%>

       <div class="android-drawer mdl-layout__drawer">
        <span class="mdl-layout-title">
        </span>
        <nav class="mdl-navigation">
          <a class="mdl-navigation__link" href="index.jsp">Inicio</a>
          <div id="buscar2"></div>
          <div class="android-drawer-separator"></div>
          <a class="mdl-navigation__link" href="api.html">Nuestra API REST</a>
          <div class="android-drawer-separator"></div>
         </nav>
      </div>
    <h1>Proyecto 2017 - Spotify To Mp3</h1>
	
    <h2>Alumnos que forman parte del grupo:</h2>
    <table>
    	<tr>    
    	<p>Tomás Jiménez Ponce</p>
    	<p>José Rodríguez Adame</p>
    	<p>José María Villalón Rivero</p>
      	</tr>
    </table>
    <table>
    <tr>Llamadas a APIs:</tr><br><br>
    
	<tr><a href="InicioController">YoutubeInMP3</a></tr>  
	
	<tr> <h2>Llamada a Spotify (busqueda de álbumes por artista):</h2>
    	<div id="searchDiv">
			<form id="searchForm" action="SearchController" method="post">
				<input type="text" name="searchQuery" required/> 
				<input type="submit" name="searchBtn" title="búsqueda" value="búsqueda">
			</form>
		</div>
	</tr>    
    </table>
    
<%@include file="includes/footer.jsp"%>
