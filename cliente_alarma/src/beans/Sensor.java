package beans;

import java.io.Serializable;
import java.util.List;


public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idSensor;

	private boolean activo;

	private boolean alerta;

	private String lugar;

	private Cliente cliente;

	public Sensor() {
	}
	
	

	public Sensor(int idSensor, boolean activo, boolean alerta, String lugar, List<Historico> historicos, Cliente cliente) {
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