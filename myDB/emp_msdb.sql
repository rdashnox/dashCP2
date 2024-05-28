-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: emp_msdb
-- ------------------------------------------------------
-- Server version	8.0.36

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

DROP DATABASE IF EXISTS emp_msdb;
CREATE database IF NOT EXISTS emp_msdb;
use emp_msdb;
--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `AttID` int NOT NULL AUTO_INCREMENT,
  `ID` int NOT NULL,
  `LogDate` date NOT NULL,
  `LogTime` time NOT NULL,
  `Status` varchar(45) NOT NULL,
  PRIMARY KEY (`AttID`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,6,'2024-01-01','07:56:01','Logged in'),(2,32,'2024-01-01','07:58:01','Logged in'),(3,6,'2024-01-01','17:02:01','Logged out'),(4,32,'2024-01-01','17:01:31','Logged out'),(5,6,'2024-01-02','07:58:01','Logged in'),(6,32,'2024-01-02','08:06:01','Logged in'),(7,6,'2024-01-02','20:02:01','Logged out'),(8,32,'2024-01-02','20:02:01','Logged out'),(9,6,'2024-01-05','07:59:01','Logged in'),(10,32,'2024-01-05','08:14:01','Logged in'),(11,6,'2024-01-05','17:02:01','Logged out'),(12,32,'2024-01-05','16:02:01','Logged out'),(13,6,'2024-01-08','07:59:08','Logged in'),(14,32,'2024-01-08','07:59:40','Logged in'),(15,6,'2024-01-08','17:02:12','Logged out'),(16,32,'2024-01-08','17:02:18','Logged out'),(17,6,'2024-01-09','07:59:08','Logged in'),(18,32,'2024-01-09','07:59:28','Logged in'),(19,6,'2024-01-09','17:02:01','Logged out'),(20,32,'2024-01-09','17:02:48','Logged out'),(21,6,'2024-01-10','07:49:08','Logged in'),(22,32,'2024-01-10','07:59:58','Logged in'),(23,6,'2024-01-10','17:02:48','Logged out'),(24,32,'2024-01-10','16:52:48','Logged out'),(25,6,'2024-01-11','07:49:08','Logged in'),(26,32,'2024-01-11','07:49:08','Logged in'),(27,6,'2024-01-11','17:02:48','Logged out'),(28,32,'2024-01-11','17:02:48','Logged out'),(29,6,'2024-01-12','07:49:08','Logged in'),(30,32,'2024-01-12','07:49:08','Logged in'),(31,6,'2024-01-12','17:02:48','Logged out'),(32,32,'2024-01-12','17:02:48','Logged out'),(33,6,'2024-01-15','07:49:08','Logged in'),(34,32,'2024-01-15','07:49:08','Logged in'),(35,6,'2024-01-15','17:02:48','Logged out'),(36,32,'2024-01-15','17:02:48','Logged out'),(37,6,'2024-01-16','07:49:08','Logged in'),(38,32,'2024-01-16','07:49:08','Logged in'),(39,6,'2024-01-16','17:02:48','Logged out'),(40,32,'2024-01-16','17:02:48','Logged out'),(41,6,'2024-01-17','07:49:08','Logged in'),(42,32,'2024-01-17','07:49:08','Logged in'),(43,6,'2024-01-17','17:02:48','Logged out'),(44,32,'2024-01-17','17:02:48','Logged out'),(45,6,'2024-01-18','07:49:08','Logged in'),(46,32,'2024-01-18','07:49:08','Logged in'),(47,6,'2024-01-18','17:02:48','Logged out'),(48,32,'2024-01-18','17:02:48','Logged out'),(49,6,'2024-01-19','07:49:08','Logged in'),(50,32,'2024-01-19','07:49:08','Logged in'),(51,6,'2024-01-19','17:02:48','Logged out'),(52,32,'2024-01-19','17:02:48','Logged out'),(53,6,'2024-01-22','07:49:08','Logged in'),(54,32,'2024-01-22','07:49:08','Logged in'),(55,6,'2024-01-22','17:02:48','Logged out'),(56,32,'2024-01-22','17:02:48','Logged out'),(57,6,'2024-01-23','07:49:08','Logged in'),(58,32,'2024-01-23','07:49:08','Logged in'),(59,6,'2024-01-23','17:02:48','Logged out'),(60,32,'2024-01-23','17:02:48','Logged out'),(61,6,'2024-01-26','07:49:08','Logged in'),(62,32,'2024-01-26','07:49:08','Logged in'),(63,6,'2024-01-26','17:02:48','Logged out'),(64,32,'2024-01-26','17:02:48','Logged out'),(65,6,'2024-01-29','07:49:08','Logged in'),(66,32,'2024-01-29','07:49:08','Logged in'),(67,6,'2024-01-29','17:02:48','Logged out'),(68,32,'2024-01-29','17:02:48','Logged out'),(69,6,'2024-01-30','07:49:08','Logged in'),(70,32,'2024-01-30','07:49:08','Logged in'),(71,6,'2024-01-30','17:02:48','Logged out'),(72,32,'2024-01-30','17:02:48','Logged out'),(73,6,'2024-01-31','07:49:08','Logged in'),(74,32,'2024-01-31','07:49:08','Logged in'),(75,6,'2024-01-31','17:02:48','Logged out'),(76,32,'2024-01-31','17:02:48','Logged out'),(77,3,'2024-01-01','07:56:01','Logged in'),(78,3,'2024-01-01','17:02:48','Logged out'),(79,3,'2024-01-02','07:56:01','Logged in'),(80,3,'2024-01-02','17:02:48','Logged out'),(81,3,'2024-01-03','07:56:01','Logged in'),(82,3,'2024-01-03','17:02:48','Logged out'),(83,3,'2024-01-04','07:56:01','Logged in'),(84,3,'2024-01-04','17:02:48','Logged out'),(85,3,'2024-01-05','07:56:01','Logged in'),(86,3,'2024-01-05','17:02:48','Logged out'),(87,3,'2024-01-08','07:56:01','Logged in'),(88,3,'2024-01-08','17:02:48','Logged out'),(89,3,'2024-01-09','07:56:01','Logged in'),(90,3,'2024-01-09','17:02:48','Logged out'),(91,3,'2024-01-10','07:56:01','Logged in'),(92,3,'2024-01-10','17:02:48','Logged out'),(93,3,'2024-01-11','07:56:01','Logged in'),(94,3,'2024-01-11','17:02:48','Logged out'),(95,3,'2024-01-12','07:56:01','Logged in'),(96,3,'2024-01-12','17:02:48','Logged out'),(97,3,'2024-01-15','07:56:01','Logged in'),(98,3,'2024-01-15','17:02:48','Logged out'),(99,3,'2024-01-16','07:56:01','Logged in'),(100,3,'2024-01-16','17:02:48','Logged out'),(101,3,'2024-01-17','07:56:01','Logged in'),(102,3,'2024-01-17','17:02:48','Logged out'),(103,3,'2024-01-18','07:56:01','Logged in'),(104,3,'2024-01-18','17:02:48','Logged out'),(105,3,'2024-01-19','07:56:01','Logged in'),(106,3,'2024-01-19','17:02:48','Logged out'),(107,3,'2024-01-22','07:56:01','Logged in'),(108,3,'2024-01-22','17:02:48','Logged out'),(109,3,'2024-01-23','07:56:01','Logged in'),(110,3,'2024-01-23','17:02:48','Logged out'),(111,3,'2024-01-24','07:56:01','Logged in'),(112,3,'2024-01-24','17:02:48','Logged out'),(113,3,'2024-01-25','07:56:01','Logged in'),(114,3,'2024-01-25','17:02:48','Logged out'),(115,3,'2024-01-26','07:56:01','Logged in'),(116,3,'2024-01-26','17:02:48','Logged out'),(117,3,'2024-01-29','07:56:01','Logged in'),(118,3,'2024-01-29','17:02:48','Logged out'),(119,3,'2024-01-30','07:56:01','Logged in'),(120,3,'2024-01-30','17:02:48','Logged out'),(121,3,'2024-01-31','07:56:01','Logged in'),(122,3,'2024-01-31','17:02:48','Logged out');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorphdb`
--

DROP TABLE IF EXISTS `motorphdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motorphdb` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Last Name` varchar(55) NOT NULL,
  `First Name` varchar(55) NOT NULL,
  `Birthday` date NOT NULL,
  `Email` varchar(55) NOT NULL,
  `Password` varchar(55) NOT NULL,
  `Designation` varchar(55) NOT NULL,
  `Address` text,
  `Phone Number` text,
  `SSS #` text,
  `Philhealth #` text,
  `TIN #` text,
  `Pag-ibig #` text,
  `Status` text,
  `Position` text,
  `Immediate Supervisor` text,
  `Basic Salary` varchar(55) DEFAULT NULL,
  `Rice Subsidy` varchar(55) DEFAULT NULL,
  `Phone Allowance` varchar(55) DEFAULT NULL,
  `Clothing Allowance` varchar(55) DEFAULT NULL,
  `Gross Semi-monthly Rate` varchar(55) DEFAULT NULL,
  `Hourly Rate` varchar(55) DEFAULT NULL,
  `FirstLogin` int DEFAULT NULL,
  `Security Question` varchar(45) DEFAULT NULL,
  `Security Answer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorphdb`
--

LOCK TABLES `motorphdb` WRITE;
/*!40000 ALTER TABLE `motorphdb` DISABLE KEYS */;
INSERT INTO `motorphdb` VALUES (1,'Garcia','Manuel III','1983-10-11','admin@motorph.com','pass1','Admin','Valero Carpark Building Valero Street 1227, Makati City','966-860-270','44-4506057-3','820126853951','442-605-657-000','691295330870','Regular','Chief Executive Officer','N/A','90,000','1,500','2,000','1,000','45,000','535.71',0,NULL,NULL),(2,'Lim','Antonio','1988-06-19','emp@motorph.com','pass3','Employee','San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite','171-867-411','52-2061274-9','331735646338','683-102-776-000','663904995411','Regular','Chief Operating Officer','Garcia, Manuel III','60,000','1,500','2,000','1,000','30,000','357.14',0,NULL,NULL),(3,'Aquino','Bianca Sofia','1989-08-04','','','Employee','Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City','966-889-370','30-8870406-2','177451189665','971-711-280-000','171519773969','Regular','Chief Finance Officer','Garcia, Manuel III','60,000','1,000','2,000','1,000','30,000','357.14',0,NULL,NULL),(4,'Reyes','Isabella','1994-06-16','','','Employee','460 Solanda Street Intramuros 1000, Manila','786-868-477','40-2511815-0','341911411254','876-809-437-000','416946776041','Regular','Chief Marketing Officer','Garcia, Manuel III','60,000','1,500','2,000','1,000','30,000','357.14',0,NULL,NULL),(5,'Hernandez','Eduard','1989-09-23','','','Employee','National Highway, Gingoog,  Misamis Occidental','088-861-012','50-5577638-1','957436191812','031-702-374-000','952347222457','Regular','IT Operations and Systems','Lim, Antonio','52,670','1,500','1,000','1,000','26,335','313.51',0,NULL,NULL),(6,'Villanueva','Andrea Mae','1988-02-14','hr@motorph.com','pass2','Admin','17/85 Stracke Via Suite 042, Poblacion, Las PiÃ±as 4783 Dinagat Islands ','918-621-603','49-1632020-8','382189453145','317-674-022-000','441093369646','Regular','HR Manager','Lim, Antonio','52,670','1,500','1,000','1,000','26,335','313.51',0,NULL,NULL),(7,'San Jose','Brad ','1996-03-15','','','Employee','99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi','797-009-261','40-2400714-1','239192926939','672-474-690-000','210850209964','Regular','HR Team Leader','Villanueva, Andrea Mae','42,975','1,500','800','800','21,488','255.8',0,NULL,NULL),(8,'Romualdez','Alice','1992-05-14','','','Employee','12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte ','983-606-799','55-4476527-2','545652640232','888-572-294-000','211385556888','Regular','HR Rank and File','San, Jose Brad','22,500','1,500','500','500','11,250','133.93',0,NULL,NULL),(9,'Atienza','Rosie ','1948-09-24','','','Employee','90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte','266-036-427','41-0644692-3','708988234853','604-997-793-000','260107732354','Regular','HR Rank and File','San, Jose Brad','22,500','1,500','500','500','11,250','133.93',0,NULL,NULL),(10,'Alvaro','Roderick','1988-03-30','','','Employee','#284 T. Morato corner, Scout Rallos Street, Quezon City','053-381-386','64-7605054-4','578114853194','525-420-419-000','799254095212','Regular','Accounting Head','Aquino, Bianca Sofia ','52,670','1,500','1,000','1,000','26,335','313.51',0,NULL,NULL),(11,'Salcedo','Anthony','1993-09-14','','','Employee','93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate','070-766-300','26-9647608-3','126445315651','210-805-911-000','218002473454','Regular','Payroll Manager','Alvaro, Roderick','50,825','1,500','1,000','1,000','25,413','302.53',0,NULL,NULL),(12,'Lopez','Josie ','1987-01-14','','','Employee','49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro','478-355-427','44-8563448-3','431709011012','218-489-737-000','113071293354','Regular','Payroll Team Leader','Salcedo, Anthony','38,475','1,500','800','800','19,238','229.02',0,NULL,NULL),(13,'Farala','Martha','1942-01-11','','','Employee','42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte ','329-034-366','45-5656375-0','233693897247','210-835-851-000','631130283546','Regular','Payroll Rank and File','Salcedo, Anthony','24,000','1,500','500','500','12,000','142.86',0,NULL,NULL),(14,'Martinez','Leila','1970-07-11','','','Employee','37/46 Kulas Roads, Maragondon 0962 Quirino ','877-110-749','27-2090996-4','515741057496','275-792-513-000','101205445886','Regular','Payroll Rank and File','Salcedo, Anthony','24,000','1,500','500','500','12,000','142.86',0,NULL,NULL),(15,'Romualdez','Fredrick ','1985-03-10','','','Employee','22A/52 Lubowitz Meadows, Pililla 4895 Zambales','023-079-009','26-8768374-1','308366860059','598-065-761-000','223057707853','Regular','Account Manager','Lim, Antonio','53,500','1,500','1,000','1,000','26,750','318.45',0,NULL,NULL),(16,'Mata','Christian','1987-10-21','','','Employee','90 O\'Keefe Spur Apt. 379, Catigbian 2772 Sulu ','783-776-744','49-2959312-6','824187961962','103-100-522-000','631052853464','Regular','Account Team Leader','Romualdez, Fredrick ','42,975','1,500','800','800','21,488','255.8',0,NULL,NULL),(17,'De Leon','Selena ','1975-02-20','','','Employee','89A Armstrong Trace, Compostela 7874 Maguindanao','975-432-139','27-2090208-8','587272469938','482-259-498-000','719007608464','Regular','Account Team Leader','Romualdez, Fredrick ','41,850','1,500','800','800','20,925','249.11',0,NULL,NULL),(18,'San Jose','Allison ','1986-06-24','','','Employee','08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union','179-075-129','45-3251383-0','745148459521','121-203-336-000','114901859343','Regular','Account Rank and File','Mata, Christian','22,500','1,500','500','500','11,250','133.93',0,NULL,NULL),(19,'Rosario','Cydney ','1996-10-06','','','Employee','93A/21 Berge Points, Tapaz 2180 Quezon','868-819-912','49-1629900-2','579253435499','122-244-511-000','265104358643','Regular','Account Rank and File','Mata, Christian','22,500','1,500','500','500','11,250','133.93',0,NULL,NULL),(20,'Bautista','Mark ','1991-02-12','','','Employee','65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino','683-725-348','49-1647342-5','399665157135','273-970-941-000','260054585575','Regular','Account Rank and File','Mata, Christian','23,250','1,500','500','500','11,625','138.39',0,NULL,NULL),(21,'Lazaro','Darlene ','1985-11-25','','','Employee','47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino','740-721-558','45-5617168-2','606386917510','354-650-951-000','104907708845','Probationary','Account Rank and File','Mata, Christian','23,250','1,500','500','500','11,625','138.39',0,NULL,NULL),(22,'Delos Santos','Kolby ','1980-02-26','','','Employee','06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur','739-443-033','52-0109570-6','357451271274','187-500-345-000','113017988667','Probationary','Account Rank and File','Mata, Christian','24,000','1,500','500','500','12,000','142.86',0,NULL,NULL),(23,'Santos','Vella ','1983-12-31','','','Employee','99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur','955-879-269','52-9883524-3','548670482885','101-558-994-000','360028104576','Probationary','Account Rank and File','Mata, Christian','22,500','1,500','500','500','11,250','133.93',0,NULL,NULL),(24,'Del Rosario','Tomas','1978-12-18','','','Employee','80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque','882-550-989','45-5866331-6','953901539995','560-735-732-000','913108649964','Probationary','Account Rank and File','Mata, Christian','22,500','1,500','500','500','11,250','133.93',0,NULL,NULL),(25,'Tolentino','Jacklyn ','1984-05-19','','','Employee','96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao','675-757-366','47-1692793-0','753800654114','841-177-857-000','210546661243','Probationary','Account Rank and File','De Leon, Selena','24,000','1,500','500','500','12,000','142.86',0,NULL,NULL),(26,'Gutierrez','Percival ','1970-12-18','','','Employee','58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur','512-899-876','40-9504657-8','797639382265','502-995-671-000','210897095686','Probationary','Account Rank and File','De Leon, Selena','24,750','1,500','500','500','12,375','147.32',0,NULL,NULL),(27,'Manalaysay','Garfield ','1986-08-28','','','Employee','60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur','948-628-136','45-3298166-4','810909286264','336-676-445-000','211274476563','Probationary','Account Rank and File','De Leon, Selena','24,750','1,500','500','500','12,375','147.32',0,NULL,NULL),(28,'Villegas','Lizeth ','1981-12-12','','','Employee','66/77 Mann Views, Luisiana 1263 Dinagat Islands','332-372-215','40-2400719-4','934389652994','210-395-397-000','122238077997','Probationary','Account Rank and File','De Leon, Selena','24,000','1,500','500','500','12,000','142.86',0,NULL,NULL),(29,'Ramos','Carol ','1978-08-20','','','Employee','72/70 Stamm Spurs, Bustos 4550 Iloilo','250-700-389','60-1152206-4','351830469744','395-032-717-000','212141893454','Probationary','Account Rank and File','De Leon, Selena','22,500','1,500','500','500','11,250','133.93',0,NULL,NULL),(30,'Maceda','Emelia ','1973-04-14','','','Employee','50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija','973-358-041','54-1331005-0','465087894112','215-973-013-000','515012579765','Probationary','Account Rank and File','De Leon, Selena','22,500','1,500','500','500','11,250','133.93',0,NULL,NULL),(31,'Aguilar','Delia ','1989-01-27','','','Employee','95 Cremin Junction, Surallah 2809 Cotabato','529-705-439','52-1859253-1','136451303068','599-312-588-000','110018813465','Probationary','Account Rank and File','De Leon, Selena','50,000','1,500','500','500','11,250','133.93',0,NULL,NULL),(32,'Castro','John Rafael','1992-02-09','castro@motorph.com','12345','Employee','Hi-way, Yati, Liloan Cebu','332-424-955 ','26-7145133-4','601644902402','404-768-309-000','697764069311','Regular','Sales & Marketing','Reyes, Isabella','52,670','1,500','1,000','1,000','26,335','313.51',0,NULL,NULL),(33,'Martinez','Carlos Ian','1990-11-16','','','Employee','Bulala, Camalaniugan','078-854-208','11-5062972-7','380685387212','256-436-296-000','993372963726','Regular','Supply Chain and Logistics','Reyes, Isabella','52,670','1,500','1,000','1,000','26,335','313.51',0,NULL,NULL),(34,'Santos','Beatriz','1990-08-07','','','Employee','Agapita Building, Metro Manila','526-639-511','20-2987501-5','918460050077','911-529-713-000','874042259378','Regular','Customer Service and Relations','Reyes, Isabella','52,670','1,500','1,000','1,000','26,335','313.51',0,NULL,NULL),(35,'test','test1','2024-02-02','test@motorph.com','12345','Employee',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'What is the name of your first pet?','ikaw');
/*!40000 ALTER TABLE `motorphdb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payroll` (
  `IDpayroll` int NOT NULL AUTO_INCREMENT,
  `ID` int NOT NULL,
  `Date` varchar(45) NOT NULL,
  `Rice Subsidy` varchar(45) NOT NULL,
  `Phone Allowance` varchar(45) NOT NULL,
  `Clothing Allowance` varchar(45) NOT NULL,
  `Total Allowances` varchar(45) NOT NULL,
  `SSS` varchar(45) NOT NULL,
  `Philhealth` varchar(45) NOT NULL,
  `Pag-ibig` varchar(45) NOT NULL,
  `TIN` varchar(45) NOT NULL,
  `Total Deductions` varchar(45) NOT NULL,
  `Total Net Salary` varchar(45) NOT NULL,
  `Term` varchar(100) NOT NULL,
  PRIMARY KEY (`IDpayroll`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES `payroll` WRITE;
/*!40000 ALTER TABLE `payroll` DISABLE KEYS */;
INSERT INTO `payroll` VALUES (7,3,'2024-02-25 13:06:25','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 1 (Month Day: 1st day until 15th)'),(8,3,'2023-03-25 22:45:24','1,200','2,000','1,000','4,200.00','1,125.00','900.00','100.0','2,935.50','5,060.50','32,139.50','Term 1 (Month Day: 1st day until 15th)'),(9,3,'2022-04-25 22:45:53','1,000','2,000','1,000','4,000.00','1,125.00','900.00','100.0','2,885.50','5,010.50','31,989.50','Term 1 (Month Day: 1st day until 15th)'),(10,3,'2024-02-25 23:01:11','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 2 (Month Day:16th day until last day)'),(11,2,'2024-02-26 14:23:48','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 1 (Month Day: 1st day until 15th)'),(12,2,'2024-02-26 14:23:59','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 2 (Month Day:16th day until last day)'),(13,3,'2024-02-26 19:46:06','1,500','2,000','1,000','4,500.00','1,125.00','900.00','100.0','3,010.50','5,135.50','32,364.50','Term 1 (Month Day: 1st day until 15th)'),(14,35,'2024-02-26 19:49:29','1,000','2,000','3,000','6,000.00','1,125.00','750.00','100.0','2,138.40','4,113.40','29,386.60','Term 1 (Month Day: 1st day until 15th)'),(15,3,'2024-02-27 15:09:59','1,000','2,001','1,001','4,002.00','1,125.00','900.00','100.0','2,886.00','5,011.00','31,991.00','Term 1 (Month Day: 1st day until 15th)');
/*!40000 ALTER TABLE `payroll` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-01 16:37:55
