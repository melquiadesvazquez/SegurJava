package managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import beans.Cliente;
import modelo.service.ServiceAlarma;


@ManagedBean
public class ClientesBean {
	@ManagedProperty("#{serviceAlarma}")
	ServiceAlarma serviceAlarma;
	
	private List<Cliente> clientes;
	private String mensajeError;
	
	public ClientesBean() {
		mensajeError = "";	
	}
	
	public ClientesBean(ServiceAlarma serviceAlarma, List<Cliente> clientes, String mensajeError) {
		super();
		this.serviceAlarma = serviceAlarma;
		this.clientes = clientes;
		this.mensajeError = mensajeError;
	}

	public ServiceAlarma getServiceAlarma() {
		return serviceAlarma;
	}

	public void setServiceAlarma(ServiceAlarma serviceAlarma) {
		this.serviceAlarma = serviceAlarma;
	}
	
	public List<Cliente> getClientes() {
		clientes=serviceAlarma.readAllClientes();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
				
	public String activar(Cliente cliente) {
		cliente.setActivo(true);
		serviceAlarma.updateCliente(cliente.getIdCliente(), cliente);
		return "clientes";
	}
	
	public String desactivar(Cliente cliente) {
		cliente.setActivo(false);
		serviceAlarma.updateCliente(cliente.getIdCliente(), cliente);
		return "clientes";
	}
}
