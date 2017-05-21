package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapLinkRepository implements LinkRepository{

	Map<String, String> linkMap;
	private static MapLinkRepository instance=null;
	
	public static MapLinkRepository getInstance(){
		if(instance==null){
			instance = new MapLinkRepository();
			instance.init();
		}
		return instance;
	}
	
	public void init(){
		
		linkMap = new HashMap<String, String>();
		
		//Nombre y link de los videos
		
		//Bruno Mars - That’s What I Like [Official Video]
		String n1 = "Thats what i like";
		String l1 = "https://www.youtubeinmp3.com/download/get/?i=uyrMjKib5O2I2DqJbqxpNP3TqsrkPRUI&e=73";
		
		addLink(n1, l1);
		
		//Imagine Dragons - Believer
		
		String n2 = "Believer";
		String l2 = "https://www.youtubeinmp3.com/download/get/?i=VlVwNa4F2RfZXLOzLAGnlelqamxubmSt&e=36";
		addLink(n2,l2);

		//Don Diablo - Cutting Shapes (Official Music Video)
		
		String n3 = "Cutting shapes";
		String l3 = "https://www.youtubeinmp3.com/download/get/?i=R0fKaLtwLwEaFW7p0gMvgPzaz023IthI&e=13";
		
		addLink(n3,l3);
		
		//deadmau5 & Kaskade - I Remember (HQ)
		
		String n4 = "I remember";
		String l4 = "https://www.youtubeinmp3.com/download/get/?i=Tt4jj3RNwNajoUkeOq8bUGux9uyRuGJj&e=84";
		
		addLink(n4, l4);
	}

	public void addLink(String nombre, String link) {
		linkMap.put(nombre, link);
	}

	public Collection<String> getAllLinks() {
		return linkMap.values();
	}

	public String getLink(String nombre) {
		String link = linkMap.get(nombre);
		return link;
	}

	public void updateLink(String nombre, String link) {
		linkMap.put(nombre, link);
		
	}

	public void deleteLink(String nombre) {
		linkMap.remove(nombre);
	}
}
