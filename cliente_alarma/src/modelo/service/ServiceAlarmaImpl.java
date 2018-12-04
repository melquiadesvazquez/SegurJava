package modelo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import beans.Cliente;
import beans.Historico;
import beans.Sensor;

@Service(value="serviceAlarma")
public class ServiceAlarmaImpl implements ServiceAlarma {
	String url="http://localhost:3000";
	RestTemplate tmp=new RestTemplate();
	
	
	// ****************** //
	// CLIENTES
	// ****************** //
	
	// GET TODOS LOS CLIENTES
	@Override
	public List<Cliente> readAllClientes() {
		Cliente[] clientes = tmp.getForObject(url+"/clientes", Cliente[].class);
		return Arrays.asList(clientes);
	}
	
	// GET CLIENTE POR ID
	@Override
	public Cliente readClientePorId(int idCliente) {
		Cliente cliente = tmp.getForObject(url+"/clientes/"+idCliente, Cliente.class);
		return cliente;
	}
	
	// GET CLIENTE POR CREDENCIALES
	@Override
	public Cliente readClientePorCredenciales(String usuario, String password) {
		Cliente cliente = tmp.getForObject(url+"/clientes/"+usuario+"/"+password, Cliente.class);
		return cliente;
	}
	
	// POST CLIENTE NUEVO
	@Override
	public Cliente createCliente(Cliente cliente) {
		Cliente newCliente = tmp.postForObject(url+"/clientes/", cliente, Cliente.class);		
		return newCliente;
	}
	
	// PUT CLIENTE ACTUALIZADO
	@Override
	public Cliente updateCliente(int idCliente, Cliente cliente) {
		ResponseEntity<Cliente> rp=tmp.exchange(url+"/clientes/"+idCliente, HttpMethod.PUT, new HttpEntity<Cliente>(cliente), Cliente.class);		
		return rp.getBody();
	}
	
	// DELETE CLIENTE A BORRAR
	@Override
	public void deleteCliente(int idCliente) {
		tmp.delete(url+"/clientes/"+idCliente);
	}
	
	
	// ****************** //
	// SENSORES
	// ****************** //
	
	// GET TODOS LOS SENSORES
	@Override
	public List<Sensor> readAllSensores() {
		Sensor[] sensores = tmp.getForObject(url+"/sensores", Sensor[].class);
		return Arrays.asList(sensores);
	}
	
	// GET TODOS LOS SENSORES POR CLIENTE
	@Override
	public List<Sensor> readAllSensoresPorCliente(int idCliente) {
		Sensor[] sensores = tmp.getForObject(url+"/clientes/"+idCliente+"/sensores", Sensor[].class);
		return Arrays.asList(sensores);
	}
	
	// GET SENSOR POR ID
	@Override
	public Sensor readSensorPorId(int idSensor) {
		Sensor sensor = tmp.getForObject(url+"/sensores/"+idSensor, Sensor.class);
		return sensor;
	}
	
	// POST SENSOR NUEVO
	@Override
	public Sensor createSensor(Sensor sensor) {
		Sensor newSensor = tmp.postForObject(url+"/sensores/", sensor, Sensor.class);		
		return newSensor;
	}
	
	// PUT SENSOR ACTUALIZADO
	@Override
	public Sensor updateSensor(int idSensor, Sensor sensor) {
		ResponseEntity<Sensor> rp=tmp.exchange(url+"/sensores/"+idSensor, HttpMethod.PUT, new HttpEntity<Sensor>(sensor), Sensor.class);		
		return rp.getBody();
	}
	
	// DELETE SENSOR A BORRAR
	@Override
	public void deleteSensor(int idSensor) {
		tmp.delete(url+"/sensores/"+idSensor);		
	}
	
	// ****************** //	
	// HISTORICOS
	// ****************** //
	
	// GET TODOS LOS HISTORICOS
	@Override
	public List<Historico> readAllHistoricos(){
		Historico[] historicos = tmp.getForObject(url+"/historicos", Historico[].class);
		return Arrays.asList(historicos);
	}
	
	// GET TODOS LOS HISTORICOS POR FECHA
	@Override
	public List<Historico> readAllHistoricosPorCliente(int idCliente) {
		Historico[] historicos = tmp.getForObject(url+"/clientes/"+idCliente+"/historicos", Historico[].class);
		return Arrays.asList(historicos);
	}
	
	// GET TODOS LOS HISTORICOS POR DNI
	@Override
	public List<Historico> readAllHistoricosPorDNI(String dni) {
		Historico[] historicos = tmp.getForObject(url+"/historicosdni/"+dni, Historico[].class);
		return Arrays.asList(historicos);
	}
	
	// GET TODOS LOS HISTORICOS POR FECHA
	@Override
	public List<Historico> readAllHistoricosPorFecha(String from, String to) {
		Historico[] historicos = tmp.getForObject(url+"/historicos/"+from+"/"+to, Historico[].class);
		return Arrays.asList(historicos);
	}
		
	// GET HISTORICO POR ID
	@Override
	public Historico readHistoricoPorId(int idHistorico) {
		Historico historico = tmp.getForObject(url+"/historicos/"+idHistorico, Historico.class);
		return historico;
	}

	// POST HISTORICO NUEVO
	@Override
	public Historico createHistorico(Historico historico) {			
		Historico newHistorico = tmp.postForObject(url+"/historicos/", historico, Historico.class);		
		return newHistorico;
	}
	
	// PUT HISTORICO ACTUALIZADO
	@Override
	public Historico updateHistorico(int idHistorico, Historico historico) {			
		ResponseEntity<Historico> rp=tmp.exchange(url+"/historicos/"+idHistorico, HttpMethod.PUT, new HttpEntity<Historico>(historico), Historico.class);		
		return rp.getBody();
	}
	
	// DELETE HISTORICO A BORRAR
	@Override
	public void deleteHistorico(int idHistorico) {			
		tmp.delete(url+"/historicos/"+idHistorico);
	}
}
