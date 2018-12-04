package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historicos database table.
 * 
 */
@Entity
@Table(name="historicos")
@NamedQuery(name="Historico.findAll", query="SELECT h FROM Historico h")
public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHistorico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	//bi-directional many-to-one association to Sensor
	@ManyToOne
	@JoinColumn(name="idSensor")
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