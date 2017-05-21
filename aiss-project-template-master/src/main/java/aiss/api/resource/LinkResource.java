package aiss.api.resource;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.repository.LinkRepository;
import aiss.model.repository.MapLinkRepository;

@Path("/links")
public class LinkResource {
	
	public static LinkResource _instance = null;
	LinkRepository repository;
	
	private LinkResource(){
		repository = MapLinkRepository.getInstance();
	}
	
	public static LinkResource getInstance(){
		if(_instance == null){
			_instance = new LinkResource();
		}
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<String> getAll() {
		Collection<String> links = repository.getAllLinks();
		if(links.isEmpty()){
			throw new NotFoundException("La lista de links está vacía");
		}
		return links;
	}
	
	@GET
	@Path("/{nombre}")
	@Produces("application/json")
	public String getLink(@PathParam("nombre") String nombre){
		String link = repository.getLink(nombre);
		if(link == null){
			throw new NotFoundException("El link de descarga que usted cuyo nombre es "+nombre+", no ha sido encontrado");
		}
		return link;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addLink(@Context UriInfo uriInfo, String link, String nombre){
		if(link== null || link.equals("")){
			throw new BadRequestException("El link que usted quiso añadir no es correcto");
		}
		if(nombre == null || nombre.equals("")){
			throw new BadRequestException("El nombre que usted quiso añadir no es correcto");
		}
		repository.addLink(nombre, link);
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(link);
		ResponseBuilder resp = Response.created(uri);
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateLink(String nuevoLink, String nombre){
		String antiguoLink = repository.getLink(nombre);
		if(antiguoLink == null || antiguoLink.equals("")){
			throw new NotFoundException("El link cuyo nombre es "+nombre+", no fue encontrado");
		}
		if(nuevoLink != null || nuevoLink != ""){
			repository.updateLink(nuevoLink, nombre);
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{nombre}")
	public Response removeLink(@PathParam("nombre") String nombre){
		String linkBorrado = repository.getLink(nombre);
		if(linkBorrado == null){
			throw new NotFoundException("El link cuyo nombre es "+nombre+", no fue encontrado");
		}else{
			repository.deleteLink(nombre);
		}
		return Response.noContent().build();
	}
}
