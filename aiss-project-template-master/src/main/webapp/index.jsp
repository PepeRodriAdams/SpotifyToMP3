<%@include file="includes/header.jsp"%>

  
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
