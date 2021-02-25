package ec.edu.ups.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.ComentarioFacade;
import ec.edu.ups.entidades.Comentario;

@Named
@RequestScoped
public class ComentariosBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ComentarioFacade ejbComentariosFacade;
	
	
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	@PostConstruct
	public void init(){
		comentarios=ejbComentariosFacade.findAll();
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	
	
	
}
