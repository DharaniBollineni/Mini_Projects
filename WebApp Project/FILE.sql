-- MySQL dump 10.16  Distrib 10.1.41-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	10.1.41-MariaDB-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coaches`
--

DROP TABLE IF EXISTS `coaches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coaches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coaches`
--

LOCK TABLES `coaches` WRITE;
/*!40000 ALTER TABLE `coaches` DISABLE KEYS */;
INSERT INTO `coaches` VALUES (1,'Kristy Keppich-Birrell'),(2,'Tanya Dearns'),(3,'Sue Hawkins'),(4,'Simone McKinnis'),(5,'Rob Wright'),(6,'Debbie Fuller'),(7,'Roselee Jencke'),(8,'Noeline Taurua'),(9,'Julie Fitzgerald'),(10,'Stacey Rosman');
/*!40000 ALTER TABLE `coaches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_tb`
--

DROP TABLE IF EXISTS `event_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_tb` (
  `event_number` int(11) NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(100) NOT NULL,
  `email` varchar(70) NOT NULL,
  `phoneNumber` varchar(70) NOT NULL,
  `Event_type` varchar(70) DEFAULT NULL,
  `needDate` varchar(70) DEFAULT NULL,
  `yourMsg` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`event_number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_tb`
--

LOCK TABLES `event_tb` WRITE;
/*!40000 ALTER TABLE `event_tb` DISABLE KEYS */;
INSERT INTO `event_tb` VALUES (1,'dharani','Dharani@gmail.com','02200202','weekend party','20/10/2019','please contact'),(2,'Chinmayi','chin@gmail.com','0220020211','weekend party','3/02/2020','need to talk'),(3,'ravanth','ravanth@gmail.com','0233223','Birthday party','4/10/2019','it\'s two hrs party in the afternoon from 12pm to 2pm'),(4,'ravanth','Vani@gmail.com','0233223','Birthday party','24/10/2019','hi please call');
/*!40000 ALTER TABLE `event_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `games` (
  `home_id` int(11) DEFAULT NULL,
  `away_id` int(11) DEFAULT NULL,
  `home_score` int(11) DEFAULT NULL,
  `away_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (6,8,57,58),(7,3,70,55),(10,1,63,44),(5,4,57,42),(2,9,57,56),(5,9,78,50),(1,4,44,59),(8,3,58,58),(6,10,44,54),(7,2,61,45),(4,7,47,58),(5,1,68,44),(10,3,64,50),(9,8,53,63),(2,6,52,52),(1,7,46,58),(10,5,52,63),(8,2,67,54),(3,6,56,55),(8,10,69,62),(7,5,61,51),(4,9,57,34),(2,3,57,58),(6,1,52,49),(7,6,70,42),(5,2,79,41),(1,8,54,69),(3,4,48,69),(9,10,44,58),(10,7,52,61),(4,5,51,59),(3,9,57,58),(6,2,55,53),(9,6,49,45),(10,4,53,54),(7,1,62,51),(3,5,52,73),(2,8,63,67),(4,1,57,51),(5,7,58,54),(8,6,66,60),(9,2,54,44),(7,4,56,44),(1,10,51,63),(3,8,51,81),(6,9,51,54),(8,7,66,51),(5,10,57,58),(4,6,69,46),(2,1,46,60),(9,3,56,55),(1,5,53,67),(4,10,60,55),(8,9,64,54),(3,2,59,64),(8,4,65,56),(10,2,70,47),(1,3,58,55),(6,5,53,59),(9,7,47,71),(6,3,62,54),(5,8,59,59),(7,10,63,52),(9,1,56,55),(2,4,53,66);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match_teams`
--

DROP TABLE IF EXISTS `match_teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `match_teams` (
  `match_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match_teams`
--

LOCK TABLES `match_teams` WRITE;
/*!40000 ALTER TABLE `match_teams` DISABLE KEYS */;
INSERT INTO `match_teams` VALUES (1,6,57),(1,8,58),(2,7,70),(2,3,55),(3,10,63),(3,1,44),(4,5,57),(4,4,42),(5,2,57),(5,9,56),(6,5,78),(6,9,50),(7,1,44),(7,4,59),(8,8,58),(8,3,58),(9,6,44),(9,10,54),(10,7,61),(10,2,45),(11,4,47),(11,7,58),(12,5,68),(12,1,44),(13,10,64),(13,3,50),(14,9,53),(14,8,63),(15,2,52),(15,6,52),(16,1,46),(16,7,58),(17,10,52),(17,5,63),(18,8,67),(18,2,54),(19,3,56),(19,6,55),(20,8,69),(20,10,62),(21,7,61),(21,5,51),(22,4,57),(22,9,34),(23,2,57),(23,3,58),(24,6,52),(24,1,49),(25,7,70),(25,6,42),(26,5,79),(26,2,41),(27,1,54),(27,8,69),(28,3,48),(28,4,69),(29,9,44),(29,10,58),(30,10,52),(30,7,61),(31,4,51),(31,5,59),(32,3,57),(32,9,58),(33,6,55),(33,2,53),(34,9,49),(34,6,45),(35,10,53),(35,4,54),(36,7,62),(36,1,51),(37,3,52),(37,5,73),(38,2,63),(38,8,67),(39,4,57),(39,1,51),(40,5,58),(40,7,54),(41,8,66),(41,6,60),(42,9,54),(42,2,44),(43,7,56),(43,4,44),(44,1,51),(44,10,63),(45,3,51),(45,8,81),(46,6,51),(46,9,54),(47,8,66),(47,7,51),(48,5,57),(48,10,58),(49,4,69),(49,6,46),(50,2,46),(50,1,60),(51,9,56),(51,3,55),(52,1,53),(52,5,67),(53,4,60),(53,10,55),(54,8,64),(54,9,54),(55,3,59),(55,2,64),(56,8,65),(56,4,56),(57,10,70),(57,2,47),(58,1,58),(58,3,55),(59,6,53),(59,5,59),(60,9,47),(60,7,71),(61,6,62),(61,3,54),(62,5,59),(62,8,59),(63,7,63),(63,10,52),(64,9,56),(64,1,55),(65,2,53),(65,4,66);
/*!40000 ALTER TABLE `match_teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `at_team` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (1,6),(2,7),(3,10),(4,5),(5,2),(6,5),(7,1),(8,8),(9,6),(10,7),(11,4),(12,5),(13,10),(14,9),(15,2),(16,1),(17,10),(18,8),(19,3),(20,8),(21,7),(22,4),(23,2),(24,6),(25,7),(26,5),(27,1),(28,3),(29,9),(30,10),(31,4),(32,3),(33,6),(34,9),(35,10),(36,7),(37,3),(38,2),(39,4),(40,5),(41,8),(42,9),(43,7),(44,1),(45,3),(46,6),(47,8),(48,5),(49,4),(50,2),(51,9),(52,1),(53,4),(54,8),(55,3),(56,8),(57,10),(58,1),(59,6),(60,9),(61,6),(62,5),(63,7),(64,9),(65,2);
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer_tb`
--

DROP TABLE IF EXISTS `offer_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer_tb` (
  `code_number` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(100) NOT NULL,
  `price` varchar(70) NOT NULL,
  PRIMARY KEY (`code_number`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer_tb`
--

LOCK TABLES `offer_tb` WRITE;
/*!40000 ALTER TABLE `offer_tb` DISABLE KEYS */;
INSERT INTO `offer_tb` VALUES (1,'Espresso','$2'),(2,'Americano','$3'),(3,'Cappuccino','$3'),(4,'Affogato','$2'),(5,'Corto','$3'),(6,'Latte','$2'),(7,'Macchiato','$3'),(8,'French','$3'),(9,'Iced Coffee','$4'),(10,'Decaf Coffee','$4');
/*!40000 ALTER TABLE `offer_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_tb`
--

DROP TABLE IF EXISTS `order_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_tb` (
  `order_number` int(11) NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(100) NOT NULL,
  `email` varchar(70) NOT NULL,
  `contact_number` varchar(70) NOT NULL,
  `item_name` varchar(70) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `pickup_time` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`order_number`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_tb`
--

LOCK TABLES `order_tb` WRITE;
/*!40000 ALTER TABLE `order_tb` DISABLE KEYS */;
INSERT INTO `order_tb` VALUES (14,'jack','abcd100@mail.com','02220002','Corto',2,'9am'),(15,'kiran','abcd100@mail.com','02255330','IcedCoffee',3,'1:20pm'),(17,'Eswari','Dharani1@gmail.com','02222000','Cappuccino',2,'9am'),(20,'Blue','Dharani1@gmail.com','02230330','Latte',12,'10pm'),(23,'Madi','Dharani1@gmail.com','023232390','Latte',2,'10:15am'),(25,'Gai','abcd100@mail.com','0202002','Espresso',1,'2pm');
/*!40000 ALTER TABLE `order_tb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_positions`
--

DROP TABLE IF EXISTS `player_positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_positions` (
  `player_id` int(11) DEFAULT NULL,
  `position` char(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_positions`
--

LOCK TABLES `player_positions` WRITE;
/*!40000 ALTER TABLE `player_positions` DISABLE KEYS */;
INSERT INTO `player_positions` VALUES (1,'WA'),(1,'C'),(2,'GA'),(2,'WA'),(2,'GS'),(3,'GA'),(3,'GS'),(4,'GK'),(4,'GD'),(5,'C'),(5,'WA'),(6,'GK'),(6,'GD'),(7,'WA'),(7,'C'),(7,'WD'),(8,'GD'),(8,'GK'),(8,'WD'),(9,'GA'),(9,'GS'),(10,'C'),(10,'WA'),(11,'GK'),(11,'GD'),(12,'WD'),(12,'C'),(12,'WA'),(13,'GD'),(13,'GK'),(14,'GA'),(14,'GS'),(15,'GS'),(15,'GA'),(16,'GK'),(16,'GD'),(16,'GS'),(17,'WD'),(17,'C'),(18,'WA'),(18,'C'),(18,'GA'),(19,'GA'),(19,'GS'),(20,'GK'),(20,'GD'),(21,'C'),(21,'WD'),(22,'WA'),(22,'C'),(22,'GA'),(23,'WD'),(24,'GS'),(25,'GA'),(25,'WA'),(25,'GS'),(26,'WA'),(26,'GS'),(26,'GA'),(27,'GA'),(27,'WA'),(27,'C'),(28,'GS'),(28,'GA'),(29,'WA'),(29,'C'),(30,'GK'),(30,'GD'),(31,'WD'),(31,'C'),(31,'WA'),(32,'WD'),(32,'C'),(33,'GK'),(33,'GD'),(33,'WD'),(34,'GK'),(34,'GD'),(34,'WD'),(35,'WD'),(35,'C'),(36,'GK'),(37,'GA'),(37,'GS'),(38,'GS'),(38,'GA'),(39,'GK'),(39,'GD'),(40,'GK'),(40,'GD'),(40,'WD'),(41,'WD'),(41,'C'),(42,'WA'),(42,'C'),(43,'GD'),(43,'WD'),(44,'C'),(44,'WA'),(45,'GD'),(45,'GK'),(45,'WD'),(46,'WA'),(47,'GS'),(47,'GA'),(48,'C'),(48,'WA'),(49,'C'),(49,'WA'),(49,'WD'),(50,'GK'),(50,'GD'),(50,'WD'),(51,'WD'),(51,'C'),(52,'GA'),(52,'GS'),(53,'GS'),(54,'GA'),(54,'GS'),(54,'WA'),(55,'C'),(55,'WD'),(55,'WA'),(56,'WA'),(56,'C'),(57,'GD'),(58,'GS'),(59,'GD'),(60,'GD'),(60,'WD'),(60,'C'),(60,'WA'),(61,'GD'),(61,'GK'),(62,'C'),(62,'WD'),(63,'GS'),(63,'GA'),(64,'WD'),(64,'C'),(65,'GK'),(65,'GD'),(66,'GA'),(66,'GS'),(67,'GS'),(68,'GD'),(68,'GK'),(69,'GK'),(69,'GD'),(69,'WD'),(70,'GD'),(70,'WD'),(71,'C'),(71,'WD'),(72,'GS'),(73,'GK'),(73,'GD'),(74,'GS'),(74,'GA'),(75,'GK'),(75,'GD'),(76,'GD'),(76,'WD'),(77,'WA'),(77,'C'),(77,'WD'),(78,'C'),(78,'WD'),(78,'WA'),(79,'WD'),(79,'C'),(79,'GD'),(80,'GA'),(80,'GS'),(81,'C'),(81,'WA'),(82,'GD'),(82,'WD'),(83,'GA'),(83,'GS'),(83,'WA'),(84,'GK'),(84,'GD'),(85,'WA'),(85,'C'),(86,'GS'),(87,'C'),(87,'WA'),(88,'WD'),(88,'C'),(88,'WA'),(89,'GA'),(89,'GS'),(90,'WD'),(90,'C'),(91,'GD'),(91,'GK'),(92,'GS'),(92,'GA'),(93,'GK'),(93,'GD'),(93,'WD'),(94,'GK'),(94,'GD'),(95,'GA'),(95,'GS'),(96,'GD'),(96,'GK'),(97,'GS'),(97,'GA'),(98,'GS'),(98,'GA'),(99,'GD'),(99,'GK'),(100,'GD'),(100,'GK'),(101,'GS'),(101,'GA'),(102,'GD'),(102,'WD'),(103,'GA'),(103,'WA'),(104,'C'),(104,'WA'),(104,'WD'),(105,'C'),(105,'WA'),(106,'WD'),(106,'GD'),(107,'GA'),(107,'GS'),(108,'WA'),(108,'C'),(109,'GS'),(110,'GS'),(110,'GA'),(111,'C'),(111,'WD'),(112,'C'),(112,'WA'),(112,'WD'),(113,'GD'),(113,'GK'),(114,'C'),(114,'WA'),(115,'GD'),(115,'GK'),(116,'GK'),(116,'GD'),(117,'GA'),(117,'GS'),(118,'GK'),(118,'GD'),(119,'GS'),(119,'GA');
/*!40000 ALTER TABLE `player_positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(90) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `hometown` varchar(90) DEFAULT NULL,
  `team` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'Emily Beaton',180,'Loxton, SA',1),(2,'Erin Bell',178,'Sydney, NSW',1),(3,'Stephanie Puopolo',181,'Melbourne, Victoria',1),(4,'Samantha Poolman',189,'Newcastle, NSW',1),(5,'Madeleine Proud',174,'Adelaide, SA',1),(6,'Kate Shimmin',186,'Adelaide, SA',1),(7,'Khao Watts',170,'Millicent, South Australia',1),(8,'Amy Steel',190,'Melbourne, VIC',1),(9,'Carla Borrego',193,'Jamaica',1),(10,'Hannah Petty',177,'Adelaide, South Australia',1),(11,'Sarah Klau',190,'null',1),(12,'Jade Clarke',174,'Manchester, England',1),(13,'Katrina Grant',186,'Papakura, NZ',2),(14,'Jodi Brown',185,'Whanganui, NZ',2),(15,'Ameliaranne Wells',186,'Bundaberg, QLD',2),(16,'Phoenix Karaka',186,'Auckland, New Zealand',2),(17,'Elias Scheres',178,'Tokoroa, NZ',2),(18,'Whitney Souness',182,'Porirua, NZ',2),(19,'Blaze Leslie',182,'Karratha, Western Australia',2),(20,'Jacinta Messer',184,'Brisbane, Queensland',2),(21,'Samon Nathan',178,'Waitakere, New Zealand',2),(22,'Chelsea Locke',181,'Paddington, New South Wales',2),(23,'Kate Wells',176,'Stratford, New Zealand',2),(24,'Maia Wilson',189,'Auckland, New Zealand',2),(25,'Anna Thompson',175,'Christchurch, NZ',3),(26,'Bailey Mes',187,'Auckland, NZ',3),(27,'Gemma Hazeldine',170,'Christchurch, NZ',3),(28,'Mwai Kumwenda',183,'Mzimba, MAW',3),(29,'Nicola Mackle',169,'Timaru, New Zealand',3),(30,'Jess Moulds',188,'Helensville, NZ',3),(31,'Erikana Pedersen',173,'Auckland, NZ',3),(32,' Hayley Saunders',179,'Gore, NZ',3),(33,'Louise Thayer',185,'Invercargill, NZ',3),(34,'Zoe Walker',183,'Nelson, NZ',3),(35,'Charlotte Elley',174,'Westport, New Zealand',3),(36,'Olivia Coughlan',188,'Palmerston North',3),(37,'Alice Teague-Neeld',183,'Bundoora, VIC',4),(38,'Karyn Bailey',193,'Williamstown, VIC',4),(39,'Emily Mannix',187,'Geelong, VIC',4),(40,'Geva Mentor',188,'Bournemouth, ENG',4),(41,'Kate Moloney',177,'Greensborough, VIC',4),(42,'Madison Robinson',168,'Geelong, Victoria',4),(43,'Chloe Watson',183,'Fitzroy, VIC',4),(44,'Elizabeth Watson',178,'Carlton, VIC',4),(45,'Joanna Weston',188,'Corowa, VIC',4),(46,'Kelsey Browne',164,'Geelong, VIC',4),(47,'Emma Ryde',197,'Dandenong, Victoria',4),(48,'Kimberlee Green',176,'Sydney, New South Wales',5),(49,'Paige Hadley',173,'Sydney, New South Wales',5),(50,'Sharni Layton',187,'Melbourne, Victoria',5),(51,'Abbey McCulloch',178,'Sydney, NSW',5),(52,'Susan Pettitt',180,'Canberra, ACT',5),(53,'Caitlin Thwaites',188,'Bendigo, VIC',5),(54,'Stephanie Wood',175,'Hyde Park, Queensland',5),(55,'Laura Langman',173,'Waikato, New Zealand',5),(56,'Kaitlyn Bryce',170,'Nowra, New South Wales',5),(57,'Lauren Moore',184,'Sydney, New South Wales',5),(58,'Amy Sommerville',180,'Sydney, New South Wales',5),(59,'Maddy Turner',183,'Adelaide, South Australia',5),(60,'Kayla Cullen',185,'Auckland, New Zealand',6),(61,'Temalisi Fakahokotau',182,'Auckland, New Zealand',6),(62,'Serena Guthrie',180,'Jersey, United Kingdom',6),(63,'Cathrine Tuivaiti',189,'Auckland, New Zealand',6),(64,'Nadia Loveday',171,'Auckland, New Zealand',6),(65,'Sulu Fitzpatrick',188,'Auckland, New Zealand',6),(66,'Maria Tutaia',188,'Tokoroa, New Zealand',6),(67,'Megan Craig',203,'Lower Hutt, New Zealand',6),(68,'Holly Fowler',182,'Auckland, New Zealand',6),(69,'Anna Harrison',190,'Westport, New Zealand',6),(70,'Michaela Sokolich-Beatson',183,'Auckland, New Zealand',6),(71,'Fa\'amu Ioane',172,'Apia, Samoa',6),(72,'Romelda Aiken',196,'Jamaica',7),(73,'Laura Clemesha',190,'Toowoomba, Queensland',7),(74,'Beryl Friday',184,'Ingham, Queensland',7),(75,'Laura Geitz',185,'Ipswich, Queensland',7),(76,'Clare McMeniman',185,'Brisbane, Queensland',7),(77,'Caitlyn Nevins',173,'Echuca, Victoria',7),(78,'Kimberley Ravaillion',176,'Strathfield, New South Wales',7),(79,'Gabrielle Simpson',176,'Sydney, New South Wales',7),(80,'Gretel Tippett',192,'Gold Coast, Queensland',7),(81,'Mahalia Cassidy',173,'Redcliffe, Queensland',7),(82,'Hulita Haukinima',178,'Logan, Queensland',7),(83,'Chelsea Lemke',182,'Gawler, South Australia',7),(84,'Te Huinga Reo Selby-Rickit',184,'Hamilton, NZ',8),(85,'Gina Crampton',174,'Hamilton, New Zealand',8),(86,'Jhaniele Fowler-Reid',198,'Montego Bay, Jamaica',8),(87,'Shannon Francois',178,'Motueka, New Zealand',8),(88,'Wendy Frew',174,'Invercargill, New Zealand',8),(89,'Brooke Leaver',183,'Auckland, New Zealand',8),(90,'Stacey Peeters',173,'Matamata, New Zealand',8),(91,'Storm Purvis',186,'Christchurch, New Zealand',8),(92,'Te Paea Selby-Rickit',188,'Otaki, New Zealand',8),(93,'Jane Watson',181,'Christchurch, New Zealand',8),(94,'Abby Erwood',181,'Dunedin, New Zealand',8),(95,'Jamie Hume',182,'Clyde, New Zealand',8),(96,'Leana de Bruin',190,'Bethlehem, South Africa',9),(97,'Ellen Halpenny',185,'Napier, New Zealand',9),(98,'Joanne Harten',188,'Essex, ENG',9),(99,'Kelly Jury',192,'Stratford, New Zealand',9),(100,'Kristiana Manu\'a',182,'Wellington, New Zealand',9),(101,'Malia Paseka',183,'Auckland, New Zealand',9),(102,'Jamie-Lee Price',179,'Sydney, New South Wales',9),(103,'Grace Rasmussen',177,'Auckland, New Zealand',9),(104,'Samantha Sinclair',171,'Rotorua, New Zealand',9),(105,' Courtney Tairi',180,'Sydney, New South Wales',9),(106,'Katherine Coffin',182,'Hamilton, New Zealand',9),(107,'Paula Griffin',1,'Auckland, New Zealand',9),(108,'Verity Simmons',170,'Liverpool, New South Wales',10),(109,'Cailtin Bassett',193,'Perth, Western Australia',10),(110,'Kate Beveridge',193,'Perth, Western Australia',10),(111,'Ashleigh Brazill',175,'Campbelltown, NSW',10),(112,'Shae Brown',181,'Melbourne, Victoria',10),(113,'Courtney Bruce',189,'Gosnells, Western Australia',10),(114,'Ingrid Colyer',165,'Karridale, Western Australia',10),(115,'Josie Janz-Dawson',185,'Thursday Island, Queensland',10),(116,'April Brandley',185,'Nowra, New South Wales',10),(117,'Natalie Medhurst',175,'Warracknabeal, Victoria',10),(118,'Erena Mikaere',193,'Rotorua, New Zealand',10),(119,'Kaylia Stanton',189,'Perth, Western Australia',10),(125,NULL,NULL,NULL,NULL),(126,NULL,NULL,NULL,NULL),(127,'Schoolchild',166,'Wellington',5),(128,'dharani',182,'Wellington',3);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `coach` int(11) DEFAULT NULL,
  `captain` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Thunderbirds',1,2),(2,'Pulse',2,13),(3,'Tactix',3,25),(4,'Vixens',4,42),(5,'Swifts',5,55),(6,'Mystics',6,66),(7,'Firebirds',7,75),(8,'Steel',8,88),(9,'Magic',9,96),(10,'Fever',10,111);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tb`
--

DROP TABLE IF EXISTS `user_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_tb` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `email` varchar(70) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tb`
--

LOCK TABLES `user_tb` WRITE;
/*!40000 ALTER TABLE `user_tb` DISABLE KEYS */;
INSERT INTO `user_tb` VALUES (1,'Chin','chin@gmail.com','0'),(2,'Chin','abc@email.com','0'),(5,'Abcd','abcd1@mail.com','0'),(6,'Abcde','abcde@gmail.com','0'),(8,'Chin','chin2@gmail.com','0'),(9,'Dharani','Dharani1@gmail.com','Abcdef1!'),(10,'userA','usera1@gmail.com','Abcdef1!'),(11,'Dharani','Dharani3@gmail.com','Abcdef1!'),(12,'Dharani','Dharani@gmail.com','Abcdef1!'),(14,'Dharani','abcd12@mail.com','Abcdefg1!'),(16,'userABC','Dharani21@gmail.com','Abcdef1!'),(17,'userAb','userBc@gamil.com','GaiGai1!'),(18,'userAcd','userabc@gmail.com','Abcdef1!'),(20,'dharanig','dharanig@gmail.com','Abcdef1!'),(21,'Dharani','abcd23@mail.com','Abcdef1!'),(26,'userA','user12A@gmail.com','Apple11!'),(27,'Dharani','dharani44@gmail.com','Abcdef1!'),(28,'Dharani','Dharu@gmail.com','Abcdef1!'),(29,'Dharani','chin34@gmail.com','Abcdef1!'),(30,'Dharani','Dharanigai@gmail.com','Abcdef1!'),(31,'Dharani','dharani121@gmail.com','Abcdef1!'),(32,'Chin','abcd100@mail.com','Abcdef1!'),(33,'Dharani','dharani1212@mail.com','Abcdef1'),(34,'Chin','Dharanich1985@gmail.com','Abcdef1'),(36,'Chin','bollineni.dharani@gmail.com','Abcdef1'),(37,'Vani','Vani@gmail.com','Vani1!'),(38,'Dharani','harani@gmail.com','Abcdef1!'),(40,'userA','abcd122@mail.com','Abcdef1!');
/*!40000 ALTER TABLE `user_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-20 12:17:39
