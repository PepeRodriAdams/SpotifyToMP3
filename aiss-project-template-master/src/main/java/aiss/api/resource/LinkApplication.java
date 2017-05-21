package aiss.api.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class LinkApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public LinkApplication(){
		singletons.add(LinkResource.getInstance());
	}
	
	public Set<Class<?>> getClasses() {
		return classes;
	}
	
	public Set<Object> getSingletons() {
		return singletons;
	}
}
