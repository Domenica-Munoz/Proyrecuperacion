package ec.edu.ups.controladores;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.TiendaFacade;
import ec.edu.ups.entidades.Tienda;
import ec.edu.ups.entidades.Cliente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	@EJB
	private TiendaFacade ejbTiendaFacade;
	
	public static Cliente cliente;
	
	public static List<Cliente> clientes;
	
	private String nombre;
	private String apellido;
    private String direccion;
    private String telefono;
    private String cedula;
    private String correo;
    private String password;
    
    
    public void agregarCliente() {
    	Tienda tienda = new Tienda(1,"Tienda 1","Cuenca");
		Cliente cliente = new Cliente(0, nombre, apellido, cedula, direccion, telefono, correo, password, tienda);
		tienda.addClientes(cliente);
		ejbTiendaFacade.edit(tienda);
		//ejbClienteFacade.create(cliente);
		nombre="";
		apellido="";
		direccion="";
		telefono="";
		cedula="";
		correo="";
    		
    }
    
    
    
    
    
    

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> Clientes) {
		this.clientes = Clientes;
	}

	public static Cliente getCliente() {
		return cliente;
	}




	public static void setCliente(Cliente Cliente) {
		ClienteBean.cliente = Cliente;
	}




	public ClienteFacade getEjbClienteFacade() {
		return ejbClienteFacade;
	}
	public void setEjbClienteFacade(ClienteFacade ejbClienteFacade) {
		this.ejbClienteFacade = ejbClienteFacade;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
    
	
    
}
