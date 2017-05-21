package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.YoutubeInMp3.YoutubeInMP3;
import aiss.model.resources.YoutubeInMP3Resource;
import aiss.model.resources.YoutubeResource;

public class DescargaController extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(DescargaController.class.getName());
	
    public DescargaController() {
        super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Sample log
		RequestDispatcher rd = null;
		String query = request.getParameter("youtubeSearch"); 
		
		//Youtube
		log.log(Level.FINE, "Processing Youtube GET request " + query);
		YoutubeResource youtubeSearch = new YoutubeResource();
		String idVideo = youtubeSearch.getID(query);
		// Youtube In MP3
		log.log(Level.FINE, "Processing YoutubeInMP3 GET request " + query);
		YoutubeInMP3Resource inMP3 = new YoutubeInMP3Resource();
		String inMP3res = inMP3.getDownload(idVideo);
		 
		if(inMP3res !=null){
			request.setAttribute("inMP3res", inMP3res);
			rd = request.getRequestDispatcher("/success.jsp");
		}
		else{
			if(inMP3res==null ){
				log.log(Level.SEVERE, "YoutubeInMP3 object: " + inMP3res);
				rd = request.getRequestDispatcher("/error.jsp");
				}
		}
		rd.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}