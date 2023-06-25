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
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `transaction_id` varchar(255) NOT NULL,
  `absent` int DEFAULT NULL,
  `allowances` double DEFAULT NULL,
  `appr_Points` int DEFAULT NULL,
  `bonus` double DEFAULT NULL,
  `credited_By` varchar(255) DEFAULT NULL,
  `delay_Points` int DEFAULT NULL,
  `final_Salary` double DEFAULT NULL,
  `leaves` int DEFAULT NULL,
  `loans` int DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `net_Salary` double DEFAULT NULL,
  `prof_Tax` double DEFAULT NULL,
  `source_Bank` varchar(255) DEFAULT NULL,
  `tds` double DEFAULT NULL,
  `transaction_Date` date DEFAULT NULL,
  `warning_Points` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `emp_Id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FKt5gef4am623kttfrcp386nf2m` (`emp_Id`),
  CONSTRAINT `FKt5gef4am623kttfrcp386nf2m` FOREIGN KEY (`emp_Id`) REFERENCES `addemployeedetails` (`emp_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES ('SAL2305001',5,10.33,4,10.66,'Venkat sir',5,331975.365178,5,1,'MARCH',500000.55,10,'Axis Bank',10.45,'2023-05-01',4,2023,'2329002'),('SAL2305002',5,10.33,4,10.66,'Venkat sir',5,331975.365178,5,1,'MARCH',500000.55,10,'Axis Bank',10.45,'2023-05-01',4,2023,'2301003');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
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
