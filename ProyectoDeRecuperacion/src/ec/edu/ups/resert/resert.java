package ec.edu.ups.resert;


import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.faces.util.Json;
import javax.ws.rs.core.Response;

import ec.edu.ups.controladores.ControladorComentario;
import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.ComentarioFacade;
import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Comentario;
import ec.edu.ups.entidades.Tienda;

@Path("/Cliente")
public class resert {
	 
	@EJB
	ComentarioFacade ejbComentario;
    @EJB
    ClienteFacade ejbCliente;
    

    @POST
    @Path("/comentario/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verEstados() throws IOException {
    	try {
    		Jsonb jsonb = JsonbBuilder.create();
        	List<Comentario> comentarios = ejbComentario.findAll();
        	return Response.ok(jsonb.toJson(comentarios)).build();
    	}catch(Exception e) {
    		return Response.ok(e.getMessage()).build();
    	}
    }
    
    @POST
    @Path("/loguin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(@FormParam("user") String usuario, @FormParam("password") String clave) throws IOException {		
    	Cliente cliente = ejbCliente.inicioSesion(usuario, clave);
    	if(cliente==null) {
    		return Response.ok(false).build();
    	}else {
    		return Response.ok(true).build();
    	}    	
    }
    
    @POST
    @Path("/crearUsu")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response crearUsuario(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido,
    						@FormParam("cedula") String cedula, @FormParam("direccion") String direccion,
    						@FormParam("telefono") String telefono, @FormParam("correo") String correo,
    						@FormParam("password") String password) throws IOException {		
    	try {
    		Tienda tienda = new Tienda(1,"Tienda 1","Cuenca");
        	Cliente cliente = new Cliente(0,nombre, apellido, cedula, direccion, telefono, correo, password, tienda);
        	ejbCliente.create(cliente);
        	return Response.ok(true).build();
    	}catch(Exception e) {
    		return Response.ok(false).build();
    	}
    }
    
    @POST
    @Path("/crearComen")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response crearComentario(@FormParam("comentario") String comentario, @FormParam("idCli") int idCli) throws IOException {		
    	try {
    		Tienda tienda = new Tienda(1,"Tienda 1","Cuenca");
    		Cliente cliente= ejbCliente.find(idCli);
        	Comentario coment=  new Comentario(0, comentario, cliente, tienda);
        	ejbComentario.create(coment);
        	return Response.ok(true).build();
    	}catch(Exception e) {
    		return Response.ok(false).build();
    	
    	}}


}
