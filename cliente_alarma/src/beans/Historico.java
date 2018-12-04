package beans;

import java.io.Serializable;
import java.util.Date;


public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idHistorico;

	private Date fecha;


	private Sensor sensor;

	public Historico() {
	}
	
	

	public Historico(int idHistorico, Date fecha, Sensor sensor) {
		super();
		this.idHistorico = idHistorico;
		this.fecha = fecha;
		this.sensor = sensor;
	}



	public int getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}