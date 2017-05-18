package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.YoutubeInMp3.YoutubeInMP3;

public class YoutubeInMP3Test {
		
	@Test
	public void getDownloadTest() throws UnsupportedEncodingException {
	
		String idVideo = "Gx6xnVQuFzw"; //video de kendrik lamar - humble
		YoutubeInMP3Resource inMP3 = new YoutubeInMP3Resource();
		String inMP3res = inMP3.getDownload(idVideo);
		
		assertNotNull("The search returned null", inMP3res);

		System.out.println("The search for KendrikLamar HUMBLE returned this link: " + inMP3res);

	}
}