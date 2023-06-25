-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: payroll
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
-- Table structure for table `hike`
--

DROP TABLE IF EXISTS `hike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hike` (
  `hikeId` varchar(255) NOT NULL,
  `approved_by` varchar(255) NOT NULL,
  `consolidated_sal` double NOT NULL,
  `dates_Of_End` date NOT NULL,
  `dates_Of_Start` date NOT NULL,
  `department` varchar(255) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `final_salary` double NOT NULL,
  `hike_percentage` double NOT NULL,
  `position` varchar(255) NOT NULL,
  `reporting_manager` varchar(255) NOT NULL,
  `emp_Id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hikeId`),
  KEY `FK7vl2v5el4h2sj2ge772f8i9xa` (`emp_Id`),
  CONSTRAINT `FK7vl2v5el4h2sj2ge772f8i9xa` FOREIGN KEY (`emp_Id`) REFERENCES `addemployeedetails` (`emp_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hike`
--

LOCK TABLES `hike` WRITE;
/*!40000 ALTER TABLE `hike` DISABLE KEYS */;
INSERT INTO `hike` VALUES ('HK232301003','JVENKAT SIR',100000,'2023-01-01','2022-01-01','IT','DEVELOPER',110000,10,'JUNIOR DEVELOPER','SAI SIR','2301003'),('HK232329002','JVENKAT SIR',100000,'2023-01-01','2022-01-01','IT','DEVELOPER',110000,10,'JUNIOR DEVELOPER','SAI SIR','2329002');
/*!40000 ALTER TABLE `hike` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-02  0:40:48
