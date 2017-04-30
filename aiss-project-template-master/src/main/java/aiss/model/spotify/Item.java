package aiss.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Item {

	private String album_type;
	private List<String> available_markets;
	private String href;
	private String id;
	private String name;
	private String type;
	private String uri;	
	
	public Item() {
		
	}
	
	public String getAlbum_type() {
		return album_type;
	}
	public void setAlbum_type(String album_type) {
		this.album_type = album_type;
	}
	public List<String> getAvailable_markets() {
		return available_markets;
	}
	public void setAvailable_markets(List<String> available_markets) {
		this.available_markets = available_markets;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	   
}
