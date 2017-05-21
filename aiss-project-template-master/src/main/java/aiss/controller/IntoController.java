package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyResource;
import aiss.model.spotify.IntoPlaylist;
import aiss.model.spotify.Item;
import aiss.model.spotify.UserPlaylist;



public class IntoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(IntoController.class.getName());
	
    public IntoController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getParameter("uri");
		RequestDispatcher rd = null;	
		String accessToken=(String) request.getSession().getAttribute("Spotify-token");

		if(accessToken!=null && !"".equals(accessToken)){
				SpotifyResource userResource = new SpotifyResource(accessToken);
				IntoPlaylist tracks = userResource.getIntoPlaylist(uri);
				log.log(Level.FINE, "tracks object:" + tracks.getItems().toString());

				if (tracks!=null){
					List<String> names = listar(tracks.getItems());
//					List<String> busquedas = new ArrayList<String>();
//					request.setAttribute("tracks", tracks);
					
					request.setAttribute("nombres", names);
//					request.setAttribute("busqueda", busqueda);
					
					rd = request.getRequestDispatcher("/intoPlaylist.jsp");
				}else{
					log.log(Level.SEVERE, "playlist object:" + tracks);
					rd = request.getRequestDispatcher("/error.jsp");
				}
			}else{
				log.info("Intentando acceder a Spotify sin un token de acceso, redirigiendo al OAuth servlet");
				rd = request.getRequestDispatcher("/AuthController/Spotify");	
			}
				rd.forward(request, response);
		
	}
	
	private List<String> listar (List<Item> b){
		List<String> sol = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
		for(Item a: b){
			names.add(a.getName());
		}
		return sol;
	}
}