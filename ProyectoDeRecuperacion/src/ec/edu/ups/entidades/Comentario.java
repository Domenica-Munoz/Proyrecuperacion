package ec.edu.ups.entidades;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comentario
 *
 */
@Entity

public class Comentario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String comentario;
	@OneToOne
	@JoinColumn
	@JsonbTransient
	private Cliente cliente;
	@ManyToOne
	@JoinColumn
	@JsonbTransient
	private Tienda tienda;
	
	public Comentario(int codigo,String comentario,Cliente cliente, Tienda tienda) {
		this.setCodigo(codigo);
		this.setComentario(comentario);
		this.setCliente(cliente);
		this.setTienda(tienda);
	}
	
	public Comentario() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	
   
}
