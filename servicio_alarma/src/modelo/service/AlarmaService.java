package modelo.service;

import java.util.List;

import entidades.Cliente;
import entidades.Historico;
import entidades.Sensor;

public interface AlarmaService {
	
	// ****************** //
	// CLIENTES
	// ****************** //
	List<Cliente> readAllClientes();
	Cliente readCliente(int idCliente);
	Cliente readCliente(String usuario, String password);
	Cliente createCliente(Cliente cliente);
	Cliente updateCliente(Cliente cliente);
	void deleteCliente(int idCliente);
	
	// ****************** //
	// SENSORES
	// ****************** //
	List<Sensor> readAllSensores();
	List<Sensor> readAllSensoresJDBC();
	List<Sensor> readAllSensoresConAlertaJDBC();
	List<Sensor> readAllSensores(int idCliente);
	List<Sensor> readAllSensoresJDBC(int idCliente);
	List<Sensor> readAllSensoresConAlertaJDBC(int idCliente);
	Sensor readSensor(int idSensor);
	Sensor createSensor(Sensor sensor);
	Sensor updateSensor(Sensor sensor);
	void deleteSensor(int idSensor);
	
	// ****************** //	
	// HISTORICOS
	// ****************** //
	List<Historico> readAllHistoricos();
	List<Historico> readAllHistoricos(int idCliente);
	List<Historico> readAllHistoricos(String dni);
	List<Historico> readAllHistoricos(String from, String to);
	Historico readHistorico(int idHistorico);
	Historico createHistorico(Historico historico);
	Historico updateHistorico(Historico historico);
	void deleteHistorico(int idHistorico);
}
