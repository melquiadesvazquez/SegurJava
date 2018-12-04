package modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Sensor;

public interface DaoSensores extends JpaRepository<Sensor,Integer>{
	
	
}
