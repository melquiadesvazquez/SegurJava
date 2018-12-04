# Segur Java

Aplicación web para el mantenimiento y la monitorización de una empresa de seguridad:

# Tecnologías utilizadas:

+ Cliente/Administrador web (cliente_alarma):
	+ JSF
	+ Spring Rest

+ Servicio web Segur Java (servicio_alarma)
	+ Spring Boot
	+ JPA
	+ Spring ORM
	+ Spring Data
	+ Spring Webflux
	+ Hibernate

+ Servicio web Policia (webservice_policia)
	+ Spring Boot
	+ JPA
	+ Spring ORM
	+ Hibernate
	
# Uso del cliente web:

+ Registrar cliente http://localhost:8080/cliente_alarma/faces/cliente.xhtml
+ Mostrar clientes http://localhost:8080/cliente_alarma/faces/clientes.xhtml
+ Mostrar informes http://localhost:8080/cliente_alarma/faces/historicos.xhtml
+ Probar alarmas http://localhost:8080/cliente_alarma/faces/alarmas.xhtml
+ Login cliente http://localhost:8080/cliente_alarma/faces/login.xhtml

# Uso del API Segur Java (http://localhost:3000/)

## CLIENTES

### GET: TODOS LOS CLIENTES
/clientes

### GET: CLIENTE POR ID
/clientes/{idCliente}

### GET: CLIENTE POR CREDENCIALES
/clientes/{usuario}/{password}

### POST: CLIENTE NUEVO
/clientes

### PUT: CLIENTE ACTUALIZADO
/clientes/{idCliente}

### DELETE: CLIENTE A BORRAR
/clientes/{idCliente}


## SENSORES

### GET: TODOS LOS SENSORES
/sensores

### GET: TODOS LOS SENSORES POR CLIENTE
/clientes/{idCliente}/sensores

### GET: TODOS LOS SENSORES POR CLIENTE FLUX
/clientes/{idCliente}/sensoresflux
	
### GET: SENSOR POR ID
/sensores/{idSensor}

### POST: SENSOR NUEVO
/sensores

### PUT: SENSOR ACTUALIZADO
/sensores/{idSensor}

### DELETE: SENSOR A BORRAR
/sensores/{idSensor}


## HISTORICOS

### GET: TODOS LOS HISTORICOS
/historicos

### GET: TODOS LOS HISTORICOS POR FECHA
/clientes/{idCliente}/historicos

### GET: TODOS LOS HISTORICOS POR DNI
/historicosdni/{dni}

### GET: TODOS LOS HISTORICOS POR FECHA
/historicos/{from}/{to}
	
### GET: HISTORICO POR ID
/historicos/{idHistorico}

### POST: HISTORICO NUEVO
/historicos

### PUT: HISTORICO ACTUALIZADO
/historicos/{idHistorico}

### DELETE: HISTORICO A BORRAR
/historicos/{idHistorico}
	
