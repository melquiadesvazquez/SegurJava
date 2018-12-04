package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;

	private boolean activo;

	private int cbancaria;

	private String direccion;

	private String dni;

	private String email;

	private String nombre;

	private String password;

	private String usuario;

	public Cliente() {
	}
	
	

	public Cliente(int idCliente, boolean activo, int cbancaria, String direccion, String dni, String email,
			String nombre, String password, String usuario, List<Sensor> sensores) {
		super();
		this.idCliente = idCliente;
		this.activo = activo;
		this.cbancaria = cbancaria;
		this.direccion = direccion;
		this.dni = dni;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.usuario = usuario;
	}



	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getCbancaria() {
		return this.cbancaria;
	}

	public void setCbancaria(int cbancaria) {
		this.cbancaria = cbancaria;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}