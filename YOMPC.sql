/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 8.0.13 : Database - yompc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yompc` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `yompc`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `user` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `admin` */

insert  into `admin`(`id`,`user`,`password`) values 
(1,'1000','123');

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `bookId` int(20) NOT NULL COMMENT '图书编号',
  `bookName` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '图书名称',
  `ISBN` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '图书ISBN号',
  `author` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '作者',
  `publisherId` int(40) DEFAULT NULL COMMENT '出版社Id',
  `pricer` float DEFAULT NULL COMMENT '价格',
  `total` int(10) unsigned DEFAULT NULL COMMENT '图书总数',
  `introduction` varchar(8000) CHARACTER SET utf8 DEFAULT NULL COMMENT '图书简介',
  `frontCover` varchar(2000) CHARACTER SET utf8 DEFAULT NULL COMMENT '图书封面信息',
  `totalLending` int(10) unsigned DEFAULT NULL COMMENT '借出总数',
  `bookTypeId` int(8) DEFAULT NULL COMMENT '图书类型Id',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `books` */

insert  into `books`(`bookId`,`bookName`,`ISBN`,`author`,`publisherId`,`pricer`,`total`,`introduction`,`frontCover`,`totalLending`,`bookTypeId`) values 
(5,'HTML','76567567568','YOMPC',1,50,4,'null','null',0,1),
(6,'Python','65465465','YOMPC',1,88,9,'null','null',0,2),
(7,'SADA','645654','ASDASD',1,646,5,'ASDDAS','ADADS',0,1),
(8,'sdasa','51465','asdas',1,1,1,'asd','asd',0,1);

/*Table structure for table `booktype` */

DROP TABLE IF EXISTS `booktype`;

CREATE TABLE `booktype` (
  `bookTypeId` int(11) DEFAULT NULL COMMENT '书本类型编号',
  `bookType` varchar(40) CHARACTER SET utf8 DEFAULT NULL COMMENT '书本类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `booktype` */

insert  into `booktype`(`bookTypeId`,`bookType`) values 
(1,'普世价值'),
(2,'哲学、宗教'),
(3,'社会科学总论'),
(4,'政治、法律'),
(5,'军事'),
(6,' 经济'),
(7,'文化、科学、教育、体育'),
(8,'语言、文字'),
(9,'文学'),
(10,'艺术'),
(11,'历史、地理'),
(12,'自然科学总论');

/*Table structure for table `classtable` */

DROP TABLE IF EXISTS `classtable`;

CREATE TABLE `classtable` (
  `classId` int(11) NOT NULL COMMENT '班级编号',
  `className` varchar(40) CHARACTER SET utf8 DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `classtable` */

insert  into `classtable`(`classId`,`className`) values 
(1,'17软件技术1班'),
(2,'17软件技术2班'),
(3,'17计算机应用技术1班'),
(4,'17网络技术3班');

/*Table structure for table `lendtable` */

DROP TABLE IF EXISTS `lendtable`;

CREATE TABLE `lendtable` (
  `lendBookId` int(11) NOT NULL COMMENT '借书编号',
  `bookId` int(11) DEFAULT NULL COMMENT '书本id',
  `stuId` int(11) DEFAULT NULL COMMENT '学生id',
  `lendTime` date DEFAULT NULL COMMENT '借出时间',
  `returnTime` date DEFAULT NULL COMMENT '归还时间',
  `returnFlag` tinyint(1) DEFAULT NULL COMMENT '是否归还',
  PRIMARY KEY (`lendBookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `lendtable` */

insert  into `lendtable`(`lendBookId`,`bookId`,`stuId`,`lendTime`,`returnTime`,`returnFlag`) values 
(1,1,1,NULL,NULL,NULL),
(2,7,20170001,'2018-12-24','2018-12-24',1),
(3,5,20170001,'2018-12-24','2018-12-24',1),
(4,5,20170001,'2018-12-24','2018-12-24',1),
(5,5,20170001,'2018-12-24','2018-12-24',1),
(6,5,20170001,'2018-12-24','2018-12-24',1),
(7,6,20170001,'2018-12-24','2018-12-24',1),
(8,6,20170001,'2018-12-24','2018-12-24',1),
(9,6,20170001,'2018-12-24','2018-12-24',1),
(10,6,20170001,'2018-12-24','2018-12-24',1),
(11,6,20170001,'2018-12-24','2018-12-24',1),
(12,6,20170001,'2018-12-24','2018-12-24',1),
(13,6,20170001,'2018-12-24','2018-12-24',1),
(14,6,20170001,'2018-12-24','2018-12-24',1),
(15,6,20170001,'2018-12-24','2018-12-24',1),
(16,6,20170001,'2018-12-24','2018-12-24',1),
(17,6,20170001,'2018-12-24','2018-12-24',1),
(18,5,20170001,'2018-12-24','2018-12-24',1),
(19,7,20170001,'2018-12-24','2018-12-24',1),
(20,7,20170001,'2018-12-24','2018-12-24',1),
(21,6,20170001,'2018-12-24','2018-12-24',1),
(22,6,20170001,'2018-12-24','2018-12-24',1),
(23,6,20170001,'2018-12-24','2018-12-24',1),
(24,8,20170001,'2018-12-24','2018-12-24',1),
(25,7,20170001,'2018-12-24','2018-12-24',1),
(26,7,20170001,'2018-12-24','2018-12-24',1),
(27,7,20170001,'2018-12-24','2018-12-24',1),
(28,5,20170001,'2018-12-24','2018-12-24',1),
(29,5,20170001,'2018-12-24','2018-12-24',1),
(30,5,20170001,'2018-12-24','2018-12-24',1),
(31,6,20170001,'2018-12-24','2018-12-24',1),
(32,5,20170001,'2018-12-25','2018-12-25',1),
(33,5,20170001,'2018-12-25','2018-12-25',1),
(34,5,20170001,'2018-12-25','2018-12-25',1),
(35,5,20170001,'2018-12-25','2018-12-25',1),
(36,7,20170001,'2018-12-25','2018-12-25',1),
(37,7,20170001,'2018-12-25','2018-12-25',1),
(38,7,20170001,'2018-12-25','2018-12-25',1),
(39,7,20170001,'2018-12-25','2018-12-25',1),
(40,8,20170001,'2018-12-25','2018-12-25',1),
(41,6,20170001,'2018-12-25','2018-12-25',1),
(42,6,20170001,'2018-12-25','2018-12-25',1),
(43,6,20170001,'2018-12-25','2018-12-25',1),
(44,6,20170001,'2018-12-25','2018-12-25',1),
(45,6,20170001,'2018-12-25','2018-12-25',1),
(46,6,20170001,'2018-12-25','2018-12-25',1),
(47,6,20170001,'2018-12-25','2018-12-25',1),
(48,6,20170001,'2018-12-25','2018-12-25',1),
(49,6,20170001,'2018-12-25','2018-12-25',1),
(50,5,20170001,'2018-12-26','2018-12-26',1);

/*Table structure for table `publicher` */

DROP TABLE IF EXISTS `publicher`;

CREATE TABLE `publicher` (
  `publisherId` int(11) NOT NULL COMMENT '出版社编号',
  `publisher` varchar(40) CHARACTER SET utf8 DEFAULT NULL COMMENT '出版社',
  PRIMARY KEY (`publisherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `publicher` */

insert  into `publicher`(`publisherId`,`publisher`) values 
(1,'北京大学出版社'),
(2,'清华大学出版社'),
(3,'广西师范大学出版社'),
(4,'上海交大出版社'),
(5,'邮电出版社'),
(6,'电子出版社');

/*Table structure for table `stu` */

DROP TABLE IF EXISTS `stu`;

CREATE TABLE `stu` (
  `stuId` int(80) NOT NULL COMMENT '学生编号',
  `studentId` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '学号',
  `stuName` varchar(40) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `sexId` int(8) DEFAULT NULL COMMENT '性别id',
  `classId` int(11) DEFAULT NULL COMMENT '班级id',
  `enterTime` int(11) DEFAULT NULL COMMENT '入学时间',
  `password` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stu` */

insert  into `stu`(`stuId`,`studentId`,`stuName`,`sexId`,`classId`,`enterTime`,`password`) values 
(1,'20170001','张三',1,1,2017,'123'),
(2,'20170004','YOMPC',1,1,2016,'123'),
(3,'20170005','张四',0,1,2010,'123'),
(6,'20172259','yompc',0,5,2018,'123'),
(7,'20170002','yompcs',0,6,2017,'123'),
(8,'20188','sd',0,4,2018,'123'),
(9,'20188','sd',0,4,2018,'123'),
(10,'20188','sd',0,4,2018,'123'),
(11,'20188','sd',0,4,2018,'123'),
(12,'20188','sd',0,4,2018,'123'),
(13,'20188','sd',0,4,2018,'123'),
(14,'20188','sd',0,4,2018,'123'),
(15,'20188','sd',0,4,2018,'123'),
(16,'20188','sd',0,4,2018,'123'),
(17,'20188','sd',0,4,2018,'123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
