package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.spotify.AlbumSearch;

public class SpotifyResource {

	private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());
	
	public AlbumSearch getAlbums(String query) throws UnsupportedEncodingException {
		
		// TODO: Perform search in Spotify
		String artista = URLEncoder.encode(query, "UTF-8");
		ClientResource cr = new ClientResource("https://api.spotify.com/v1/search?q="+artista+ "&type=album");
		AlbumSearch res = cr.get(AlbumSearch.class);
		log.log(Level.FINE,"Búsqueda de álbumes del artista "+ artista +" realizada correctamente.");
	    return res;
	}
}

