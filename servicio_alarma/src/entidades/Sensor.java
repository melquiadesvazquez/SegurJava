package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sensores database table.
 * 
 */
@Entity
@Table(name="sensores")
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSensor;

	private boolean activo;

	private boolean alerta;

	private String lugar;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	public Sensor() {
	}
	
	

	public Sensor(int idSensor, boolean activo, boolean alerta, String lugar, Cliente cliente) {
		super();
		this.idSensor = idSensor;
		this.activo = activo;
		this.alerta = alerta;
		this.lugar = lugar;
		this.cliente = cliente;
	}



	public int getIdSensor() {
		return this.idSensor;
	}

	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean getAlerta() {
		return this.alerta;
	}

	public void setAlerta(boolean alerta) {
		this.alerta = alerta;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}