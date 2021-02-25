package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Tienda
 *
 */
@Entity

public class Tienda implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private String direccion;
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "tienda")
	@JsonbTransient
	private List<Cliente> clientes = new ArrayList<Cliente>();
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "tienda")
	@JsonbTransient
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	
	public Tienda(int codigo, String nombre, String direccion) {
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setDireccion(direccion);
	}
	
	public Tienda() {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void addClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void addComentarios(Comentario comentario) {
		this.comentarios.add(comentario);
	}
   

   
}
