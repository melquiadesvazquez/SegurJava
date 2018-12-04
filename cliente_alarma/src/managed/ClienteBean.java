package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import beans.Cliente;
import modelo.service.ServiceAlarma;
@ManagedBean
public class ClienteBean {
	@ManagedProperty("#{serviceAlarma}")
	ServiceAlarma serviceAlarma;		
	private Cliente cliente;	
	private String mensajeError;
	
	public ClienteBean() {
		cliente = new Cliente();
		cliente.setCbancaria(0);
		mensajeError = "";	
	}
	
	public ClienteBean(ServiceAlarma serviceAlarma, Cliente cliente, String mensajeError) {
		super();
		this.serviceAlarma = serviceAlarma;
		this.cliente = cliente;
		this.mensajeError = mensajeError;
	}

	public ServiceAlarma getServiceAlarma() {
		return serviceAlarma;
	}

	public void setServiceAlarma(ServiceAlarma serviceAlarma) {
		this.serviceAlarma = serviceAlarma;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
			
	//controlador
	public String registrar() {
		if(serviceAlarma.createCliente(cliente) != null) {
			return "login";
		}else {
			mensajeError="El usuario no es válido!";
			return null; //se queda en la página
		}
		
	}


	
}
