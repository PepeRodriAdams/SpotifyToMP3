package aiss.api.model;

public class Enlace {

	private String link;
	private String nombre;
	
	public Enlace(){
	}
	
	public Enlace(String nombre, String link){
		this.nombre = nombre;
		this.link = link;
	}
	
	public String getLink(){
		return link;
	}
	
	public void setLink(String link){
		this.link = link;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
}
