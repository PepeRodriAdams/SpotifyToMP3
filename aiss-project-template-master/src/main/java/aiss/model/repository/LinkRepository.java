package aiss.model.repository;

import java.util.Collection;

public interface LinkRepository {
	
	public void addLink(String nombre, String link);
	public Collection<String> getAllLinks();
	public String getLink(String nombre);
	public void updateLink(String nuevoLink, String nombre);
	public void deleteLink(String nombre);
}
