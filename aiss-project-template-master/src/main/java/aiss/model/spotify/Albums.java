package aiss.model.spotify;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Albums {

	private String href;
	private List<Item> items;		
	
	public Albums() {
		
	}

	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	   
}
