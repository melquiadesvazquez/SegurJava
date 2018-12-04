package managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import beans.Sensor;
import modelo.service.ServiceAlarma;


@ManagedBean
public class SensoresBean {
	@ManagedProperty("#{serviceAlarma}")
	ServiceAlarma serviceAlarma;
	
	@ManagedProperty("#{loginBean}")
	LoginBean login;
	
	private String sensorLugar;
	private List<Sensor> sensores;
	private String mensajeError;
	
	public SensoresBean() {
		sensorLugar = "";
		mensajeError = "";	
	}
	
	public SensoresBean(ServiceAlarma serviceAlarma, LoginBean login, String sensorLugar, List<Sensor> sensores, String mensajeError) {
		super();
		this.serviceAlarma = serviceAlarma;
		this.login = login;
		this.sensorLugar = sensorLugar;
		this.sensores = sensores;
		this.mensajeError = mensajeError;
	}

	public ServiceAlarma getServiceAlarma() {
		return serviceAlarma;
	}

	public void setServiceAlarma(ServiceAlarma serviceAlarma) {
		this.serviceAlarma = serviceAlarma;
	}
	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public String getSensorLugar() {
		return sensorLugar;
	}

	public void setSensorLugar(String sensorLugar) {
		this.sensorLugar = sensorLugar;
	}

	public List<Sensor> getSensores() {
		sensores=serviceAlarma.readAllSensoresPorCliente(login.getClienteLogueado().getIdCliente());
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
		sensor.setActivo(true);
		serviceAlarma.updateSensor(sensor.getIdSensor(), sensor);
		return "sensores";
	}
	
	public String desactivar(Sensor sensor) {
		sensor.setActivo(false);
		serviceAlarma.updateSensor(sensor.getIdSensor(), sensor);
		return "sensores";
	}
	
	public String crear() {
		Sensor sensor = new Sensor(0, true, false, sensorLugar, null, login.getClienteLogueado());
		serviceAlarma.createSensor(sensor);
		return "sensores";
	}
	
	public String quitar(Sensor sensor) {
		serviceAlarma.deleteSensor(sensor.getIdSensor());
		return "sensores";
	}
	
	public String baja() {
		serviceAlarma.deleteCliente(login.getClienteLogueado().getIdCliente());
		return "login";
	}
}
