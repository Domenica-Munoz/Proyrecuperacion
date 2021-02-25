package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{
	
	 @PersistenceContext(unitName = "ProyectoDeRecuperacion")
	 private EntityManager em;
	 
	 public ClienteFacade() {
		 super(Cliente.class);
	 }
	 
	 protected EntityManager getEntityManager() {
		 return em;
	 }
	 
	 public Cliente inicioSesion (String correo, String password) {
    	Cliente Cliente=null;
    	System.out.println("Intento Inicio");
    	
    	String consulta = "Select per From Cliente per Where per.correo=:correo and per.password=:password";
    	try {
    		Cliente= (Cliente) em.createQuery(consulta).setParameter("correo", correo).setParameter("password", password).getSingleResult();
    	}catch(Exception e) {
    		System.out.println(">>>Warning (ClienteFacade:Inicio sesion: )"+e.getMessage());
    	}
    	return Cliente;
    }
	 
}