-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: servletcrudmvc
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `Categoryld` int NOT NULL AUTO_INCREMENT,
  `Categorycode` varchar(100) DEFAULT NULL,
  `Categoryname` varchar(100) DEFAULT NULL,
  `Images` varchar(500) DEFAULT NULL,
  `Status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`Categoryld`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'WEB','Lập trình Web','https://via.placeholder.com/150',_binary ''),(2,'DB','Cơ sở dữ liệu','https://via.placeholder.com/150',_binary '');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `OrderDetailId` int NOT NULL AUTO_INCREMENT,
  `Price` double DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `OrderId` int DEFAULT NULL,
  `VideoId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`OrderDetailId`),
  KEY `FK2gx7xy70r5p6sg5rocuus6kyy` (`OrderId`),
  KEY `FKpo1bxrlijj5dl38pgfi004g5k` (`VideoId`),
  CONSTRAINT `FK2gx7xy70r5p6sg5rocuus6kyy` FOREIGN KEY (`OrderId`) REFERENCES `orders` (`OrderId`),
  CONSTRAINT `FKpo1bxrlijj5dl38pgfi004g5k` FOREIGN KEY (`VideoId`) REFERENCES `videos` (`Videold`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (1,1000,1,1,'v01'),(2,1000,1,2,'v01'),(3,1000,1,3,'v01'),(4,1000,1,4,'v01'),(5,1000,1,5,'v01');
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `OrderId` int NOT NULL AUTO_INCREMENT,
  `OrderDate` datetime(6) DEFAULT NULL,
  `PaymentMethod` varchar(50) DEFAULT NULL,
  `Status` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `TotalAmount` double DEFAULT NULL,
  `UserId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `FKlj9lgmu9u65vgmm6a9tmnjry7` (`UserId`),
  CONSTRAINT `FKlj9lgmu9u65vgmm6a9tmnjry7` FOREIGN KEY (`UserId`) REFERENCES `users` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2026-10-04 20:04:03.476000','COD','Mới',1000,'admin'),(2,'2026-10-04 20:04:13.093000','COD','Mới',1000,'admin'),(3,'2026-10-04 20:04:15.732000','COD','Mới',1000,'admin'),(4,'2026-10-04 20:36:54.712000','COD','Mới',1000,'admin'),(5,'2026-10-04 20:41:38.315000','COD','Mới',1000,'admin');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `Username` varchar(50) NOT NULL,
  `Active` bit(1) DEFAULT NULL,
  `Admin` bit(1) DEFAULT NULL,
  `Email` varchar(150) DEFAULT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `Images` varchar(500) DEFAULT NULL,
  `Password` varchar(50) NOT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin',_binary '',_binary '\0',NULL,NULL,NULL,'123456',NULL),('bin',_binary '',_binary '\0',NULL,NULL,NULL,'123456',NULL),('buiducduy',_binary '',_binary '\0',NULL,NULL,NULL,'123',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos` (
  `Videold` varchar(50) NOT NULL,
  `Active` bit(1) DEFAULT NULL,
  `Categoryld` int DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Poster` varchar(255) DEFAULT NULL,
  `Title` varchar(200) DEFAULT NULL,
  `Views` int DEFAULT NULL,
  PRIMARY KEY (`Videold`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES ('v01',_binary '',1,'Học lập trình web với Servlet và JSP từ cơ bản đến nâng cao.','https://picsum.photos/seed/v01/300/200','Hướng dẫn Servlet JSP cơ bản',100),('v02',_binary '',1,'Kết nối database sử dụng Hibernate ORM trong Java.','https://picsum.photos/seed/v02/300/200','Lập trình Hibernate JPA',150),('v03',_binary '',2,'Các câu lệnh store procedure và trigger hiệu suất cao.','https://picsum.photos/seed/v03/300/200','Truy vấn SQL Server nâng cao',200),('v04',_binary '',1,'Kiến trúc Model View Controller trong Java Web.','https://picsum.photos/seed/v04/300/200','Xây dựng ứng dụng MVC',120),('v05',_binary '',1,'Khóa học Spring Boot thực chiến xây dựng Restful API.','https://picsum.photos/seed/v05/300/200','Spring Boot toàn tập',300),('v06',_binary '',1,'Giao thức TCP/IP và lập trình socket với Java.','https://picsum.photos/seed/v06/300/200','Lập trình mạng căn bản',80),('v07',_binary '',1,'Chống tấn công XSS, CSRF trong Java Servlet.','https://picsum.photos/seed/v07/300/200','Bảo mật ứng dụng Web',210);
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-05  3:50:34
