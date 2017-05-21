package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.Youtube.YoutubeSearch;;

public class YoutubeResource {

	private static final Logger log = Logger.getLogger(YoutubeInMP3Resource.class.getName());
	
	private String apiKey = "AIzaSyCPeLt1tglIP8wvQwdVt-Fyu44H3hVdTa4";
	
	public String getID(String query) throws UnsupportedEncodingException{ 

		String busqueda = URLEncoder.encode(query, "UTF-8");
		ClientResource cr = new ClientResource("https://www.googleapis.com/youtube/v3/search?key="+apiKey+"&part=id&q="+busqueda+"%20lyrics");
		YoutubeSearch res = cr.get(YoutubeSearch.class);
		log.log(Level.FINE,"Búsqueda de id del vídeo "+ query +" realizada correctamente.");
		return res.getItems().get(0).getId().getVideoId();

	}
}
