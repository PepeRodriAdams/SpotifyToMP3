package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.spotify.AlbumSearch;
import aiss.model.resources.SpotifyResource;


/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for albums in Spotify
		log.log(Level.FINE, "Searching for Spotify albums of " + query);
		SpotifyResource spotify = new SpotifyResource();
		AlbumSearch spotifyResults = spotify.getAlbums(query);
		
		if (spotifyResults!=null){
			rd = request.getRequestDispatcher("/success2.jsp");
			request.setAttribute("albums", spotifyResults.getAlbums().getItems());
		} else {
			log.log(Level.SEVERE, "Spotify object: " + spotifyResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
