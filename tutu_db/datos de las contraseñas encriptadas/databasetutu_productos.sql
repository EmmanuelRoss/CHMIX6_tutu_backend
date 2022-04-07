-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: databasetutu
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idproductos` int NOT NULL AUTO_INCREMENT,
  `nombre_prod` varchar(30) NOT NULL,
  `precio` varchar(45) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `url_imagen` varchar(200) NOT NULL,
  `talla` varchar(20) DEFAULT NULL,
  `cantidad_dis` int DEFAULT NULL,
  `categoria_idcategoria` int NOT NULL,
  PRIMARY KEY (`idproductos`,`categoria_idcategoria`),
  KEY `fk_productos_categoria_idx` (`categoria_idcategoria`),
  CONSTRAINT `fk_productos_categoria` FOREIGN KEY (`categoria_idcategoria`) REFERENCES `categoria` (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (5,'sombrero','30','sombrero rojo','sadfgasdf.jpg','l',25,1),(7,'gorra azulsdf','600.0','sombrero azul ','sadfgasdf.jpg','xxl',18,1),(8,'gorra ojo de tigre','600.0','sombrero azul ','sadfgasdf.jpg','xxl',18,1),(9,'gorra ojo de xochil','600.0','sombrero azul ','sadfgasdf.jpg','xxl',18,2),(10,'gorra que parece sombrero','30.0','sombrero rojo','sadfgasdf.jpg','l',25,2),(11,'ra que parece sombrero','30.0','sombrero rojo','sadfgasdf.jpg','l',25,2),(12,'sombrero violeta','30.0','sombrero rojo','sadfgasdf.jpg','l',25,2);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07  9:39:28
