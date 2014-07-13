CREATE DATABASE  IF NOT EXISTS `db_turismo_tenerife` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_turismo_tenerife`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: db_turismo_tenerife
-- ------------------------------------------------------
-- Server version	5.5.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_usuario_recorrido`
--

DROP TABLE IF EXISTS `tb_usuario_recorrido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuario_recorrido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT NULL,
  `id_recorrido` int(11) DEFAULT NULL,
  `adultos` int(11) DEFAULT NULL,
  `niños` int(11) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_recorrido` (`id_recorrido`),
  CONSTRAINT `tb_usuario_recorrido_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuarios` (`id_usuario`),
  CONSTRAINT `tb_usuario_recorrido_ibfk_2` FOREIGN KEY (`id_recorrido`) REFERENCES `tb_recorrido` (`id_recorrido`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario_recorrido`
--

LOCK TABLES `tb_usuario_recorrido` WRITE;
/*!40000 ALTER TABLE `tb_usuario_recorrido` DISABLE KEYS */;
INSERT INTO `tb_usuario_recorrido` VALUES (1,2,3,1,0,0),(2,2,3,1,0,0),(3,2,5,1,0,0),(4,16,7,2,0,0),(5,16,7,2,-1,0),(6,16,5,1,0,1),(7,16,3,1,0,1),(8,16,3,1,0,1),(10,15,3,1,1,1),(11,15,7,1,1,1),(12,15,7,1,1,1),(13,15,8,1,0,1),(14,15,8,1,0,1),(15,15,8,1,0,1),(16,15,8,1,0,1),(17,15,8,1,0,1),(18,15,8,1,0,1),(19,15,3,1,0,1),(20,15,3,1,0,1),(21,30,9,1,1,0),(22,2,3,2,0,0),(23,2,5,1,0,0),(24,2,5,3,3,0),(25,12,3,1,0,0),(26,12,6,1,0,0),(27,2,3,1,0,0),(28,15,6,1,0,1),(29,15,6,1,0,1),(30,2,3,1,0,0),(31,2,9,1,3,1),(32,2,3,1,0,0),(33,2,3,1,0,0),(34,2,3,1,1,0),(35,2,3,1,0,0),(36,32,6,2,1,1),(37,32,8,2,1,1),(38,2,3,1,0,0),(39,2,7,1,0,1),(40,2,3,1,0,1);
/*!40000 ALTER TABLE `tb_usuario_recorrido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-27 22:53:45
