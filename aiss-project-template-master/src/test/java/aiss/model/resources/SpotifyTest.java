package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.spotify.AlbumSearch;

public class SpotifyTest {

	@Test
	public void getAlbumsTest() throws UnsupportedEncodingException {
		String artist = "Julio Iglesias";
		SpotifyResource spotify = new SpotifyResource();
		AlbumSearch spotifyResults = spotify.getAlbums(artist);
		
		assertNotNull("The search returned null", spotifyResults);
		assertNotNull("The search returned null", spotifyResults.getAlbums());
		assertFalse("The number of albums of " + artist + " is zero", spotifyResults.getAlbums().getItems().size()==0);
		
		System.out.println("The search for " + artist + "'s albums returned " + spotifyResults.getAlbums().getItems().size() + " albums.");
		
		// Optional: Print albums data
	
	}

}
