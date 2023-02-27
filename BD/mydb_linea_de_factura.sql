-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `linea_de_factura`
--

DROP TABLE IF EXISTS `linea_de_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `linea_de_factura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_prod` int DEFAULT NULL,
  `id_fact` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `id_tipo_desc` int NOT NULL,
  `precio_linea` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK408lhysps05usxvqj4nqy1fwm` (`id_prod`),
  CONSTRAINT `FK408lhysps05usxvqj4nqy1fwm` FOREIGN KEY (`id_prod`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea_de_factura`
--

LOCK TABLES `linea_de_factura` WRITE;
/*!40000 ALTER TABLE `linea_de_factura` DISABLE KEYS */;
INSERT INTO `linea_de_factura` VALUES (38,38,31,1,0,4.45),(39,40,31,1,0,21.99),(40,14,31,1,0,2.12),(41,21,31,1,0,0.21),(42,15,31,2,0,4.2),(43,15,31,2,0,4.2),(44,14,31,1,0,2.12),(45,15,32,1,0,2.1),(46,21,32,1,0,0.21),(47,33,32,1,0,1.19),(48,14,32,1,0,2.12);
/*!40000 ALTER TABLE `linea_de_factura` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-26 23:50:14
