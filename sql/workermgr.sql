-- MySQL dump 10.13  Distrib 8.2.0, for Linux (x86_64)
--
-- Host: localhost    Database: workermgr
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '职工名称',
  `sex` int NOT NULL COMMENT '性别',
  `age` int NOT NULL COMMENT '年龄',
  `dept_name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门',
  `emp_degree_name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学历',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (40,'张一',0,25,'业务部','本科'),(41,'张二',1,26,'人事部','本科'),(42,'张三',0,27,'后勤部','大专'),(43,'张四',1,28,'人事部','大专'),(44,'张五',0,29,'后勤部','大专'),(45,'张六',1,29,'后勤部','本科'),(46,'张七',0,33,'业务部','研究生'),(47,'张八',0,32,'业务部','本科'),(48,'张九',1,33,'业务部','大专'),(49,'李一',1,45,'业务部','研究生'),(50,'李二',1,19,'人事部','本科'),(51,'李三',0,28,'业务部','研究生'),(52,'李四',1,46,'后勤部','研究生'),(53,'李五',0,58,'业务部','大专'),(54,'李六',1,22,'人事部','研究生'),(55,'李七',0,26,'后勤部','大专'),(56,'李八',0,25,'人事部','研究生'),(57,'李九',1,29,'后勤部','研究生'),(58,'王一',0,45,'后勤部','本科'),(59,'王二',1,21,'业务部','本科'),(60,'王三',0,21,'业务部','大专'),(61,'王四',0,23,'业务部','大专'),(62,'王五',1,33,'业务部','大专'),(63,'王六',0,45,'人事部','本科'),(64,'王七',0,35,'业务部','研究生'),(65,'王八',0,41,'后勤部','本科'),(66,'王九',1,25,'业务部','大专'),(67,'赵一',0,26,'人事部','研究生'),(68,'赵二',0,20,'后勤部','本科'),(69,'赵三',1,21,'人事部','研究生'),(70,'赵四',0,19,'后勤部','研究生'),(71,'赵五',1,35,'后勤部','大专'),(72,'赵六',0,24,'业务部','研究生'),(73,'赵七',0,29,'业务部','大专'),(74,'赵八',1,33,'业务部','研究生'),(75,'赵九',0,45,'业务部','本科');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'editor');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `introduction` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '介绍',
  `avatar` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `role_id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$IP5hLNxjyHpaZHCmh4Z3v.ApDc0JdKm9xlF3kcY5qZLQhZ6NchlaG','bcz','https://pic.imgdb.cn/item/65688c2cc458853aefcb0375.png','1,2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-01 21:28:10
