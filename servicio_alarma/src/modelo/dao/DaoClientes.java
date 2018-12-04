package modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entidades.Cliente;
import entidades.Sensor;


public interface DaoClientes extends JpaRepository<Cliente,Integer>{
	@Query("Select s from Sensor s Where s.cliente.idCliente=?1")
	List<Sensor> recogerSensores(int idCliente);
	
	@Query("Select c from Cliente c Where c.usuario=?1 And c.password=?2 And c.activo=1")
	Cliente autenticar(String usuario, String password);
	
	Cliente findByDni(String dni);
}
