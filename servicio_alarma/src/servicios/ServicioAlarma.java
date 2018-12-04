package servicios;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entidades.Cliente;
import entidades.Historico;
import entidades.Sensor;
import modelo.service.AlarmaService;
import reactor.core.publisher.Flux;

@CrossOrigin(origins="*")
@RestController
public class ServicioAlarma {
	@Autowired
	AlarmaService alarmaService;
		
	// ****************** //
	// CLIENTES
	// ****************** //
	
	// GET TODOS LOS CLIENTES
	@GetMapping(value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> readAllClientes(){
		return alarmaService.readAllClientes();
	}
	
	// GET CLIENTE POR ID
	@GetMapping(value="/clientes/{idCliente}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente readClientePorId(@PathVariable("idCliente") int idCliente) {
		return alarmaService.readCliente(idCliente);
	}
	
	// GET CLIENTE POR CREDENCIALES
	@GetMapping(value="/clientes/{usuario}/{password}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente readClientePorCredenciales(@PathVariable("usuario") String usuario, @PathVariable("password") String password) {
		return alarmaService.readCliente(usuario, password);
	}
	
	// POST CLIENTE NUEVO
	@PostMapping(value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente createCliente(@RequestBody Cliente cliente) {			
		return alarmaService.createCliente(cliente);
	}
	
	
	// PUT CLIENTE ACTUALIZADO
	@PutMapping(value="/clientes/{idCliente}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente updateCliente(@PathVariable("idCliente") int idCliente, @RequestBody Cliente cliente) {			
		return alarmaService.updateCliente(cliente);
	}
	
	// DELETE CLIENTE A BORRAR
	@DeleteMapping(value="/clientes/{idCliente}")
	public void deleteCliente(@PathVariable("idCliente") int idCliente) {			
		alarmaService.deleteCliente(idCliente);
	}
	

	// ****************** //
	// SENSORES
	// ****************** //
	
	// GET TODOS LOS SENSORES
	@GetMapping(value="/sensores", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Sensor> readAllSensores(){
		return alarmaService.readAllSensores();
	}
	
	// GET TODOS LOS SENSORES POR CLIENTE
	@GetMapping(value="/clientes/{idCliente}/sensores", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Sensor> readAllSensoresPorCliente(@PathVariable("idCliente") int idCliente){
		return alarmaService.readAllSensores(idCliente);
	}
	
	// GET TODOS LOS SENSORES POR CLIENTE FLUX
	@GetMapping(value="/clientes/{idCliente}/sensoresflux", produces="text/event-stream")
	public Flux<Stream<Object>> readAllSensoresPorClienteFluxTest(@PathVariable("idCliente") int idCliente) {		
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<Sensor> sensores = alarmaService.readAllSensoresConAlertaJDBC(idCliente);
			
		return Flux.just(sensores.stream().map(s -> s.getIdSensor()));
	}
		
	// GET SENSOR POR ID
	@GetMapping(value="/sensores/{idSensor}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Sensor readSensorPorId(@PathVariable("idSensor") int idSensor) {
		return alarmaService.readSensor(idSensor);
	}
	
	// POST SENSOR NUEVO
	@PostMapping(value="/sensores", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Sensor createCliente(@RequestBody Sensor sensor) {			
		return alarmaService.createSensor(sensor);
	}
	
	// PUT SENSOR ACTUALIZADO
	@PutMapping(value="/sensores/{idSensor}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Sensor updateCliente(@PathVariable("idSensor") int idSensor, @RequestBody Sensor sensor) {
		if (sensor.getAlerta()) {
			alarmaService.createHistorico(new Historico(0, new Date(), sensor));
		}
		
		return alarmaService.updateSensor(sensor);
	}
	
	// DELETE SENSOR A BORRAR
	@DeleteMapping(value="/sensores/{idSensor}")
	public void deleteSensor(@PathVariable("idSensor") int idSensor) {			
		alarmaService.deleteSensor(idSensor);
	}
			

	// ****************** //	
	// HISTORICOS
	// ****************** //
	
	// GET TODOS LOS HISTORICOS
	@GetMapping(value="/historicos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Historico> readAllHistoricos(){
		return alarmaService.readAllHistoricos();
	}
	
	// GET TODOS LOS HISTORICOS POR FECHA
	@GetMapping(value="/clientes/{idCliente}/historicos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Historico> readAllHistoricosPorCliente(@PathVariable("idCliente") int idCliente) {
		return alarmaService.readAllHistoricos(idCliente);
	}
	
	// GET TODOS LOS HISTORICOS POR DNI
	@GetMapping(value="/historicosdni/{dni}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Historico> readAllHistoricosPorDNI(@PathVariable("dni") String dni) {
		return alarmaService.readAllHistoricos(dni);
	}
	
	// GET TODOS LOS HISTORICOS POR FECHA
	@GetMapping(value="/historicos/{from}/{to}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Historico> readAllHistoricosPorFecha(@PathVariable("from") String from, @PathVariable("to") String to) {
		return alarmaService.readAllHistoricos(from, to);
	}
		
	// GET HISTORICO POR ID
	@GetMapping(value="/historicos/{idHistorico}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Historico readHistoricoPorId(@PathVariable("idHistorico") int idHistorico) {
		return alarmaService.readHistorico(idHistorico);
	}

	// POST HISTORICO NUEVO
	@PostMapping(value="/historicos", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Historico createHistorico(@RequestBody Historico historico) {			
		return alarmaService.createHistorico(historico);
	}
	
	// PUT HISTORICO ACTUALIZADO
	@PutMapping(value="/historicos/{idHistorico}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Historico updateHistorico(@PathVariable("idHistorico") int idHistorico, @RequestBody Historico historico) {			
		return alarmaService.updateHistorico(historico);
	}
	
	// DELETE HISTORICO A BORRAR
	@DeleteMapping(value="/historicos/{idHistorico}")
	public void deleteHistorico(@PathVariable("idHistorico") int idHistorico) {			
		alarmaService.deleteHistorico(idHistorico);
	}
	
}
