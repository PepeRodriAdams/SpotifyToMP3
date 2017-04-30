package aiss.model.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AlbumSearch {

	private Albums albums;
	
	public Albums getAlbums(){
		return this.albums;
	}
	public void setAlbums(Albums albums){
		this.albums = albums;
	}	
}

