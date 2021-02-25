package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Tienda;

@Stateless
public class TiendaFacade extends AbstractFacade<Tienda>{
	@PersistenceContext(unitName = "ProyectoDeRecuperacion")
	 private EntityManager em;
	 
	 public TiendaFacade() {
		 super(Tienda.class);
	 }
	 
	 protected EntityManager getEntityManager() {
		 return em;
	 }
}
