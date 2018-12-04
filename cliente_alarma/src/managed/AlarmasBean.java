package managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import beans.Sensor;
import modelo.service.ServiceAlarma;


@ManagedBean
public class AlarmasBean {
	@ManagedProperty("#{serviceAlarma}")
	ServiceAlarma serviceAlarma;
	
	private List<Sensor> sensores;
	private String mensajeError;
	
	public AlarmasBean() {
		mensajeError = "";	
	}
	
	public AlarmasBean(ServiceAlarma serviceAlarma, List<Sensor> sensores, String mensajeError) {
		super();
		this.serviceAlarma = serviceAlarma;
		this.sensores = sensores;
		this.mensajeError = mensajeError;
	}

	public ServiceAlarma getServiceAlarma() {
		return serviceAlarma;
	}

	public void setServiceAlarma(ServiceAlarma serviceAlarma) {
		this.serviceAlarma = serviceAlarma;
	}
	
	public List<Sensor> getSensores() {
		sensores=serviceAlarma.readAllSensores();
		return sensores;
	}

	public void setSensores(List<Sensor> sensores) {
		this.sensores = sensores;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
				
	public String activar(Sensor sensor) {
		sensor.setAlerta(true);
		serviceAlarma.updateSensor(sensor.getIdSensor(), sensor);
		return "alarmas";
	}
	
	public String desactivar(Sensor sensor) {
		sensor.setAlerta(false);
		serviceAlarma.updateSensor(sensor.getIdSensor(), sensor);
		return "alarmas";
	}
}
