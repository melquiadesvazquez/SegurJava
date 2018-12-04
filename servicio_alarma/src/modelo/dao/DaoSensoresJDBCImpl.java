package modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import entidades.Sensor;

@Repository("daoSensoresJDBC")
public class DaoSensoresJDBCImpl implements DaoSensoresJDBC  {

	@Autowired
	JdbcTemplate tmp;
	
	@Override
	public List<Sensor> recogerSensores() {
		String sql="Select * from Sensores";
		List<Sensor> sensores;
		sensores=tmp.query(sql, 
				(rs,f)->new Sensor(rs.getInt("idSensor"), 
								rs.getBoolean("activo"),
								rs.getBoolean("alerta"),
								rs.getString("lugar"), null)
		);
		return sensores;
	}
	
	@Override
	public List<Sensor> recogerSensores(int idCliente) {
		String sql="Select * from Sensores Where idCliente=?";
		List<Sensor> sensores;
		sensores=tmp.query(sql, 
				new Object[] { idCliente },
				(rs,f)->new Sensor(rs.getInt("idSensor"), 
								rs.getBoolean("activo"),
								rs.getBoolean("alerta"),
								rs.getString("lugar"), null)
		);
		return sensores;
	}
	
	@Override
	public List<Sensor> recogerSensoresConAlerta() {
		String sql="Select * from Sensores Where alerta=1";
		List<Sensor> sensores;
		sensores=tmp.query(sql,
				(rs,f)->new Sensor(rs.getInt("idSensor"), 
								rs.getBoolean("activo"),
								rs.getBoolean("alerta"),
								rs.getString("lugar"), null)
		);
		return sensores;
	}
	
	@Override
	public List<Sensor> recogerSensoresConAlerta(int idCliente) {
		String sql="Select * from Sensores Where idCliente=? And alerta=1";
		List<Sensor> sensores;
		sensores=tmp.query(sql, 
				new Object[] { idCliente },
				(rs,f)->new Sensor(rs.getInt("idSensor"), 
								rs.getBoolean("activo"),
								rs.getBoolean("alerta"),
								rs.getString("lugar"), null)
		);
		return sensores;
	}

}
