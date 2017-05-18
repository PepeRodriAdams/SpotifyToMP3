package aiss.model.resources;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class YoutubeTest {

	@Test
	public void getIDTest() throws UnsupportedEncodingException {
	
		String query = "humble kendrik lamar lyrics"; //video de kendrik lamar - humble
		YoutubeResource youtube = new YoutubeResource();
		String id = youtube.getID(query);
		
		assertNotNull("The search returned null", id);

		System.out.println("The search for  'humble kendrik lamar lyrics' returned this youtube video id: " + id);

	}

}
