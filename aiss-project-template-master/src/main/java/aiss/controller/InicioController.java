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

public class InicioController extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(InicioController.class.getName());
	
    public InicioController() {
        super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Sample log
		RequestDispatcher rd = null;
		String urlVideo = "https://www.youtube.com/watch?v=Gx6xnVQuFzw"; //video de kendrik lamar humble
		
		// Youtube In MP3
		log.log(Level.FINE, "Processing YoutubeInMP3 GET request");
		YoutubeInMP3Resource inMP3 = new YoutubeInMP3Resource();
		String inMP3res = inMP3.getDownload(urlVideo);
		 
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