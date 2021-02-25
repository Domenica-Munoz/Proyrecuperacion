package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidades.Comentario;

@Stateless
public class ComentarioFacade extends AbstractFacade<Comentario>{
	
	 @PersistenceContext(unitName = "ProyectoDeRecuperacion")
	 private EntityManager em;
	 
	 public ComentarioFacade() {
		 super(Comentario.class);
	 }
	 
	 protected EntityManager getEntityManager() {
		 return em;
	 }
}
