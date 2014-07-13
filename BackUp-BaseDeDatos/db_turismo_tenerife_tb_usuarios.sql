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
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) DEFAULT NULL,
  `apellidos` varchar(40) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'Pepe','Perez','prueba@prueba.com','prueba'),(2,'Adrián','Ferrera','fionexpert@gmail.com','prueba'),(5,'Juan','Hernandez','juan@prueba.com','prueba'),(6,'Eli','Hernandez','eli@prueba.com','prueba'),(7,'Bea','Hernande','bea@prueba.com','prueba'),(8,'Luis','Da Silva','luis@prueba.com','prueba'),(12,'Magec','J','correo','111'),(13,'Ã?lvaro','RodrÃ­guez','prueba@gmail.com','1234'),(14,'Kevin','Kevin','','prueba'),(15,'a','a','a','a'),(16,'mimi','sicu','mimisicu89@gmail.com','123456'),(19,'\'','\'','\'','1'),(20,'1','1','1','1'),(21,'2','2','2','2'),(27,'w','w','w','w'),(28,'PruebaConexion','PruebaConexion','PruebaConexion','prueba'),(29,'Yvette','HernÃ¡ndez','yheralo@gmail.com','Apjw_projava'),(30,'Yvette','HernÃ¡ndez','kaylacegk@gmail.com','blablosa'),(32,'mimi','sicu','mail@gmail.com','1234567');
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-27 22:53:44
