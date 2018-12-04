package modelo.dao;

import java.util.List;

import entidades.Sensor;

public interface DaoSensoresJDBC {
	
	List<Sensor> recogerSensores();
	
	List<Sensor> recogerSensores(int idCliente);

	List<Sensor> recogerSensoresConAlerta();

	List<Sensor> recogerSensoresConAlerta(int idCliente);	

}