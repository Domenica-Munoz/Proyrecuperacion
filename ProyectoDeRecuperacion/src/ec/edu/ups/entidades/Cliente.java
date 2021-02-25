package ec.edu.ups.entidades;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private String apellido;
	private String cedula;
	private String direccion;
	private String telefono;
	private String correo;
	private String password;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
	@JsonbTransient
	private Comentario comentario;
	@ManyToOne
	@JoinColumn
	@JsonbTransient
	private Tienda tienda;
	
	
	
	
	public Cliente(int codigo, String nombre, String apellido, String cedula, String direccion, 
			String telefono,String correo, String password, Tienda tienda) {
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setCorreo(correo);
		this.setPassword(password);
		this.setTienda(tienda);
	}


	public Cliente() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
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


	public Tienda getTienda() {
		return tienda;
	}


	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	
   
}
