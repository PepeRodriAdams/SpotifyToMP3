package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.Item;
import aiss.model.spotify.UserPlaylist;

public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginController.class.getName());
	
	public LoginController() {
        super();
    }
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {	
		//String name =  req.getParameter("name");
		//if(name!=null && !"".equals(name)){
		RequestDispatcher rd = null;	
		String accessToken=(String) req.getSession().getAttribute("Spotify-token");
			if(accessToken!=null && !"".equals(accessToken)){
				SpotifyResource userResource = new SpotifyResource(accessToken);
				UserPlaylist playlist = userResource.getUserPlaylist();
				List<String> names = new ArrayList<String>();
				List<String> hrefs = new ArrayList<String>();
				
				if(playlist !=null){
					for(Item a:playlist.getItems() ){
						names.add(a.getName());
						hrefs.add(a.getHref());
					}
					req.setAttribute("names", names);
					req.setAttribute("hrefs", hrefs);
					rd = req.getRequestDispatcher("/loginSuccess.jsp");
				}else{
					log.log(Level.SEVERE, "playlist object:" + playlist);
					rd = req.getRequestDispatcher("/error.jsp");
				}
		}else{
			log.info("Intentando acceder a Spotify sin un token de acceso, redirigiendo al OAuth servlet");
			rd = req.getRequestDispatcher("/AuthController/Spotify");	
		}
			rd.forward(req, resp);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}