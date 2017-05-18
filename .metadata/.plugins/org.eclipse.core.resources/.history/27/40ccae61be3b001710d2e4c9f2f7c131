package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.YoutubeInMp3.YoutubeInMP3;

public class YoutubeInMP3Resource {
	
	private static final Logger log = Logger.getLogger(YoutubeInMP3Resource.class.getName());

	public YoutubeInMP3 getDownload(String urlVideo) throws UnsupportedEncodingException{
		
		String enlace = URLEncoder.encode(urlVideo, "UTF-8");

		ClientResource cr = new ClientResource("www.youtubeinmp3.com/fetch/?format=JSON&video="+enlace);
		YoutubeInMP3 res = cr.get(YoutubeInMP3.class);
		log.log(Level.FINE, "Búsqueda del enlace de descarga del vídeo con url "+urlVideo+" realizada correctamente.");
		
		return res;
	}
}
