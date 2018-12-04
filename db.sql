-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema segurjava
--

CREATE DATABASE IF NOT EXISTS segurjava;
USE segurjava;

--
-- Definition of table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `idCliente` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `cbancaria` int(10) unsigned NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `activo` tinyint(1) NOT NULL default '1',
  PRIMARY KEY  (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientes`
--

/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`idCliente`,`nombre`,`direccion`,`email`,`dni`,`cbancaria`,`usuario`,`password`,`activo`) VALUES 
 (1,'test','test','test','test',1,'test','test',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;


--
-- Definition of table `historicos`
--

DROP TABLE IF EXISTS `historicos`;
CREATE TABLE `historicos` (
  `idHistorico` int(10) unsigned NOT NULL auto_increment,
  `idSensor` int(10) unsigned NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY  (`idHistorico`),
  KEY `FK_historico_1` (`idSensor`),
  CONSTRAINT `FK_historico_1` FOREIGN KEY (`idSensor`) REFERENCES `sensores` (`idSensor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `historicos`
--

/*!40000 ALTER TABLE `historicos` DISABLE KEYS */;
INSERT INTO `historicos` (`idHistorico`,`idSensor`,`fecha`) VALUES 
 (1,6,'2018-12-03 09:21:59');
/*!40000 ALTER TABLE `historicos` ENABLE KEYS */;


--
-- Definition of table `sensores`
--

DROP TABLE IF EXISTS `sensores`;
CREATE TABLE `sensores` (
  `idSensor` int(10) unsigned NOT NULL auto_increment,
  `idCliente` int(10) unsigned NOT NULL,
  `activo` tinyint(1) NOT NULL default '1',
  `alerta` tinyint(1) NOT NULL default '0',
  `lugar` varchar(45) NOT NULL,
  PRIMARY KEY  (`idSensor`),
  KEY `FK_sensor_1` (`idCliente`),
  CONSTRAINT `FK_sensor_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sensores`
--

/*!40000 ALTER TABLE `sensores` DISABLE KEYS */;
INSERT INTO `sensores` (`idSensor`,`idCliente`,`activo`,`alerta`,`lugar`) VALUES 
 (1,1,1,0,'casa'),
 (3,1,1,0,'baño'),
 (5,7,0,0,'casa');
/*!40000 ALTER TABLE `sensores` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
