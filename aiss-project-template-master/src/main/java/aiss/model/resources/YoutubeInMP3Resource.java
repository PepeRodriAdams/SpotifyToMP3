package aiss.model.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Logger;

import com.google.appengine.repackaged.com.google.gson.Gson;

import aiss.model.YoutubeInMp3.YoutubeInMP3;

public class YoutubeInMP3Resource {
	
	private static final Logger log = Logger.getLogger(YoutubeInMP3Resource.class.getName());

	public String getDownload(String idVideo) throws UnsupportedEncodingException{ 
		 
		String enlace = URLEncoder.encode(idVideo, "UTF-8");
		 try
	      {
	         URL url = new URL("http://www.youtubeinmp3.com/fetch/?format=JSON&video=https://www.youtube.com/watch?v="+ enlace);
	         URLConnection urlConnection = url.openConnection();
	         HttpURLConnection connection = null;
	         if(urlConnection instanceof HttpURLConnection)
	         {
	            connection = (HttpURLConnection) urlConnection;
	         }
	         else
	         {
	         }
	         BufferedReader in = new BufferedReader(
	         new InputStreamReader(connection.getInputStream()));
	         String urlString = "";
	         String current;
	         while((current = in.readLine()) != null)
	         {
	            urlString += current;
	            Gson gsonObj = new Gson();
	            YoutubeInMP3 sol = gsonObj.fromJson(urlString, YoutubeInMP3.class);
	            return sol.getLink();
	            
	         }

	    }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
		return null;
	   }
}