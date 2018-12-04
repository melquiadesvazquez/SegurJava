package modelo.service;

import java.util.List;

import beans.Cliente;
import beans.Historico;
import beans.Sensor;

public interface ServiceAlarma {
	
	// ****************** //
	// CLIENTES
	// ****************** //
	
	List<Cliente> readAllClientes();	
	Cliente readClientePorId(int idCliente);
	Cliente readClientePorCredenciales(String usuario, String password);
	Cliente createCliente(Cliente cliente);
	Cliente updateCliente(int idCliente, Cliente cliente);
	void deleteCliente(int idCliente);
	
	
	// ****************** //
	// SENSORES
	// ****************** //
	
	List<Sensor> readAllSensores();
	List<Sensor> readAllSensoresPorCliente(int idCliente);
	Sensor readSensorPorId(int idSensor);
	Sensor createSensor(Sensor sensor);
	Sensor updateSensor(int idSensor, Sensor sensor);			
	void deleteSensor(int idSensor);
	
	// ****************** //	
	// HISTORICOS
	// ****************** //

	List<Historico> readAllHistoricos();
	List<Historico> readAllHistoricosPorCliente(int idCliente);
	List<Historico> readAllHistoricosPorDNI(String dni);
	List<Historico> readAllHistoricosPorFecha(String from, String to);
	Historico readHistoricoPorId(int idHistorico);
	Historico createHistorico(Historico historico);
	Historico updateHistorico(int idHistorico, Historico historico);		
	void deleteHistorico(int idHistorico);
}
