package modelo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entidades.Historico;

public interface DaoHistoricos extends JpaRepository<Historico,Integer>{
	@Query("Select h from Historico h Where h.sensor.cliente.idCliente=?1")
	List<Historico> recogerHistoricosCliente(int idCliente);
	
	@Query("Select h from Historico h Where h.fecha between ?1 And ?2")
	List<Historico> recogerHistoricosFechas(Date from, Date to);
}
