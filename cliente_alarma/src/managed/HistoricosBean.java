package managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import beans.Historico;
import modelo.service.ServiceAlarma;


@ManagedBean
public class HistoricosBean {
	@ManagedProperty("#{serviceAlarma}")
	ServiceAlarma serviceAlarma;
	
	private List<Historico> historicos;
	private String dni;
	private String from;
	private String to;
	private String mensajeError;
	
	public HistoricosBean() {
		dni = "";
		from = "";
		to = "";
		mensajeError = "";	
	}
	
	public HistoricosBean(ServiceAlarma serviceAlarma, List<Historico> historicos, String dni, String from, String to, String mensajeError) {
		super();
		this.serviceAlarma = serviceAlarma;
		this.historicos = historicos;
		this.dni = dni;
		this.from = from;
		this.to= to;
		this.mensajeError = mensajeError;
	}

	public ServiceAlarma getServiceAlarma() {
		return serviceAlarma;
	}

	public void setServiceAlarma(ServiceAlarma serviceAlarma) {
		this.serviceAlarma = serviceAlarma;
	}
	
	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	public String buscar() {
		if (!dni.equals("")) {		
			historicos = serviceAlarma.readAllHistoricosPorDNI(dni);
		}
		else
		if (!from.equals("") && !to.equals("")) {
			try {
				historicos = serviceAlarma.readAllHistoricosPorFecha(from,  to);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			historicos = serviceAlarma.readAllHistoricos();
		}
		
		return "historicos";
	}
}
