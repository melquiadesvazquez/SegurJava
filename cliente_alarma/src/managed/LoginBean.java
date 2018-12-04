package managed;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import beans.Cliente;
import modelo.service.ServiceAlarma;

@SessionScoped
@ManagedBean
public class LoginBean implements Serializable{
	@ManagedProperty("#{serviceAlarma}")
	ServiceAlarma serviceAlarma;
	private String usuario;
	private String password;
	private Cliente clienteLogueado;
	private String mensajeError;
	
	public LoginBean() {
		usuario = "";
		password = "";
		clienteLogueado = new Cliente();
		clienteLogueado.setCbancaria(0);
		mensajeError = "";
	}
	
	public LoginBean(ServiceAlarma serviceAlarma, String usuario, String password, Cliente clienteLogueado, String mensajeError) {
		super();
		this.serviceAlarma = serviceAlarma;
		this.usuario = usuario;
		this.password = password;
		this.clienteLogueado = clienteLogueado;
		this.mensajeError = mensajeError;
	}
	
	public ServiceAlarma getServiceAlarma() {
		return serviceAlarma;
	}
	public void setServiceAlarma(ServiceAlarma serviceAlarma) {
		this.serviceAlarma = serviceAlarma;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public Cliente getClienteLogueado() {
		return clienteLogueado;
	}

	public void setClienteLogueado(Cliente clienteLogueado) {
		this.clienteLogueado = clienteLogueado;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	//controlador de acción
	public String login() {
		Cliente cliente = serviceAlarma.readClientePorCredenciales(usuario, password);
		if(cliente!=null) {	
			clienteLogueado = cliente;
			return "sensores";
		}
		else {
			mensajeError="El usuario no es válido!";
			return null;
		}
	}
}
