package modelo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Cliente;
import entidades.Historico;
import entidades.Sensor;
import modelo.dao.DaoClientes;
import modelo.dao.DaoHistoricos;
import modelo.dao.DaoSensores;
import modelo.dao.DaoSensoresJDBC;

@Service(value="alarmaService")
public class AlarmaServiceImpl implements AlarmaService {
	
	@Autowired
	DaoClientes dclientes;
	
	@Autowired
	DaoSensores dsensores;
	
	@Autowired
	DaoSensoresJDBC dsensoresJDBC;
	
	@Autowired
	DaoHistoricos dhistoricos;
	
	
	// ****************** //
	// CLIENTES
	// ****************** //

	@Override
	public List<Cliente> readAllClientes() {
		return dclientes.findAll();
	}

	@Override
	public Cliente readCliente(int idCliente) {
		return dclientes.findById(idCliente).get();
	}
	
	@Override
	public Cliente readCliente(String usuario, String password) {
		return dclientes.autenticar(usuario, DigestUtils.shaHex(password));
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		Cliente newCliente = dclientes.findByDni(cliente.getDni());
		
		if (newCliente != null) {
			newCliente.setActivo(true);			
		}
		else {
			newCliente = cliente;
			newCliente.setPassword(DigestUtils.shaHex(newCliente.getPassword()));
		}		
		
		dclientes.save(newCliente);
		
		return newCliente;
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		dclientes.save(cliente);
		return cliente;
	}

	@Override
	public void deleteCliente(int idCliente) {
		Cliente c = dclientes.findById(idCliente).get();
		c.setActivo(false);
		dclientes.save(c);		
	}
	

	// ****************** //
	// SENSORES
	// ****************** //
	
	@Override
	public List<Sensor> readAllSensores() {
		return dsensores.findAll();
	}
	
	@Override
	public List<Sensor> readAllSensoresJDBC() {
		return dsensoresJDBC.recogerSensores();
	}
	
	@Override
	public List<Sensor> readAllSensoresConAlertaJDBC() {		
		return dsensoresJDBC.recogerSensoresConAlerta();
	}

	@Override
	public List<Sensor> readAllSensores(int idCliente) {		
		return dclientes.recogerSensores(idCliente);
	}
	
	@Override
	public List<Sensor> readAllSensoresJDBC(int idCliente) {		
		return dsensoresJDBC.recogerSensores(idCliente);
	}
	
	@Override
	public List<Sensor> readAllSensoresConAlertaJDBC(int idCliente) {		
		return dsensoresJDBC.recogerSensoresConAlerta(idCliente);
	}

	@Override
	public Sensor readSensor(int idSensor) {
		return dsensores.findById(idSensor).get();
	}

	@Override
	public Sensor createSensor(Sensor sensor) {
		dsensores.saveAndFlush(sensor);		
		return sensor;
	}
	
	@Override
	public Sensor updateSensor(Sensor sensor) {
		dsensores.saveAndFlush(sensor);		
		return sensor;
	}

	@Override
	public void deleteSensor(int idSensor) {
		dsensores.deleteById(idSensor);		
	}

	
	// ****************** //	
	// HISTORICOS
	// ****************** //

	@Override
	public List<Historico> readAllHistoricos() {
		return dhistoricos.findAll();
	}

	@Override
	public List<Historico> readAllHistoricos(int idCliente) {
		return dhistoricos.recogerHistoricosCliente(idCliente);
	}

	@Override
	public List<Historico> readAllHistoricos(String dni) {
		List<Historico> result = new ArrayList<Historico>();
		Cliente cliente = dclientes.findByDni(dni);
		
		if (cliente != null) {
			result = dhistoricos.recogerHistoricosCliente(cliente.getIdCliente());
		}
		
		return result;
	}

	@Override
	public List<Historico> readAllHistoricos(String from, String to) {
		List<Historico> historicos = new ArrayList<Historico>();
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			historicos = dhistoricos.recogerHistoricosFechas(formatter.parse(from + " 00:00:00"), formatter.parse(to + " 23:59:59"));
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		return historicos;
	}

	@Override
	public Historico readHistorico(int idHistorico) {
		return dhistoricos.findById(idHistorico).get();
	}

	@Override
	public Historico createHistorico(Historico historico) {
		dhistoricos.save(historico);
		return historico;
	}

	@Override
	public Historico updateHistorico(Historico historico) {
		dhistoricos.save(historico);
		return historico;
	}

	@Override
	public void deleteHistorico(int idHistorico) {
		dsensores.deleteById(idHistorico);
	}
	

}
