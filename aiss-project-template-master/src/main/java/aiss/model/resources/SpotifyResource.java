package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Header;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import com.google.appengine.repackaged.com.google.gson.Gson;

import aiss.model.spotify.TrackSearch;
import aiss.model.spotify.UserPlaylist;

public class SpotifyResource {

	private String userPlaylistsUri = "https://api.spotify.com/v1/me/playlists";
	private String trackSearchUri = "https://api.spotify.com/v1/search?type=track&q=";
	private String access_Token = null;
	private static final Logger log=Logger.getLogger(SpotifyResource.class.getName());
	
	
	public SpotifyResource(String access_Token) {
		this.access_Token = access_Token;
	}

	public UserPlaylist getUserPlaylist() throws UnsupportedEncodingException {
		String json = null;
		ClientResource cr = null;
		try{
			cr = new ClientResource(userPlaylistsUri + "?access_token=" + access_Token);
			json = cr.get(String.class);
			log.log(Level.FINE,"Búsqueda de playlist del usuario realizada correctamente."+json);
			Map<String, Object> reqAttribs = cr.getRequestAttributes(); 
			Series<Header> headers = (Series<Header>)reqAttribs.get("org.restlet.http.headers"); 
			if (headers == null) { 
				headers = new Series<Header>(Header.class); 
				reqAttribs.put("org.restlet.http.headers", headers); 
			} 
				headers.add(new Header("Authorization:", "Bearer "+access_Token));
				ChallengeResponse chr = new ChallengeResponse(
							ChallengeScheme.HTTP_OAUTH_BEARER);
				chr.setRawValue(access_Token);
				cr.setChallengeResponse(chr);
				
			}catch (ResourceException re){
				System.err.println("Error cuando accedia a Spotify: " + cr.getResponse().getStatus());
		}
		 Gson gsonObj = new Gson();
         UserPlaylist sol = gsonObj.fromJson(json, UserPlaylist.class);
         log.log(Level.FINE, "Login en Spotify realizada correctamente.");
        
         return sol;

	}
	
	public TrackSearch getTrackSearch(String query) throws UnsupportedEncodingException{
		String json = null;
		ClientResource cr = null;
		try{
			cr = new ClientResource(trackSearchUri + query + "&access_token=" + access_Token);
			json = cr.get(String.class);
			log.log(Level.FINE,"Búsqueda realizada correctamente."+json);
			Map<String, Object> reqAttribs = cr.getRequestAttributes(); 
			Series<Header> headers = (Series<Header>)reqAttribs.get("org.restlet.http.headers"); 
			if (headers == null) { 
				headers = new Series<Header>(Header.class); 
				reqAttribs.put("org.restlet.http.headers", headers); 
			} 
				headers.add(new Header("Authorization:", "Bearer "+access_Token));
				ChallengeResponse chr = new ChallengeResponse(
							ChallengeScheme.HTTP_OAUTH_BEARER);
				chr.setRawValue(access_Token);
				cr.setChallengeResponse(chr);
				
			}catch (ResourceException re){
				System.err.println("Error cuando accedia a Spotify: " + cr.getResponse().getStatus());
		}
		 Gson gsonObj = new Gson();
         TrackSearch sol = gsonObj.fromJson(json, TrackSearch.class);
         log.log(Level.FINE, "Búsqueda en Spotify realizada correctamente.");
        
         return sol;

	}
}
