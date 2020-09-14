/*
Navicat MySQL Data Transfer

Source Server         : Mongo
Source Server Version : 50544
Source Host           : 127.0.0.1:3306
Source Database       : zhaolingsys

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2018-11-13 15:48:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_dept
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept` (
  `dept_id` tinyint(4) NOT NULL,
  `dept_name` char(20) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
INSERT INTO `tbl_dept` VALUES ('1', '计算机学院');
INSERT INTO `tbl_dept` VALUES ('2', '电子电气工程学院');
INSERT INTO `tbl_dept` VALUES ('3', '物理与光电技术学院');
INSERT INTO `tbl_dept` VALUES ('4', '机械工程学院');

-- ----------------------------
-- Table structure for tbl_identity
-- ----------------------------
DROP TABLE IF EXISTS `tbl_identity`;
CREATE TABLE `tbl_identity` (
  `identity_id` tinyint(4) NOT NULL,
  `identity_name` char(255) NOT NULL,
  PRIMARY KEY (`identity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_identity
-- ----------------------------
INSERT INTO `tbl_identity` VALUES ('0', '普通用户');
INSERT INTO `tbl_identity` VALUES ('1', '管理员');

-- ----------------------------
-- Table structure for tbl_item
-- ----------------------------
DROP TABLE IF EXISTS `tbl_item`;
CREATE TABLE `tbl_item` (
  `item_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(25) NOT NULL,
  `itemClass_id` tinyint(4) NOT NULL,
  `item_img` varchar(25) DEFAULT NULL,
  `item_describe` text,
  `item_date` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_status` char(10) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_item_itemClass` (`itemClass_id`),
  KEY `fk_item_user` (`user_id`),
  CONSTRAINT `fk_item_itemClass` FOREIGN KEY (`itemClass_id`) REFERENCES `tbl_itemclass` (`itemClass_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_item_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_item
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_itemclass
-- ----------------------------
DROP TABLE IF EXISTS `tbl_itemclass`;
CREATE TABLE `tbl_itemclass` (
  `itemClass_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `itemClass_name` char(20) NOT NULL,
  PRIMARY KEY (`itemClass_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_itemclass
-- ----------------------------
INSERT INTO `tbl_itemclass` VALUES ('1', '钱包');
INSERT INTO `tbl_itemclass` VALUES ('2', '钥匙');
INSERT INTO `tbl_itemclass` VALUES ('3', '卡类/证照');
INSERT INTO `tbl_itemclass` VALUES ('4', '数码产品');
INSERT INTO `tbl_itemclass` VALUES ('5', '手袋/挎包');
INSERT INTO `tbl_itemclass` VALUES ('6', '首饰/挂饰');
INSERT INTO `tbl_itemclass` VALUES ('7', '书籍/文件');
INSERT INTO `tbl_itemclass` VALUES ('8', '其他');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_tel` varchar(11) NOT NULL,
  `user_qq` varchar(11) DEFAULT NULL,
  `dept_id` tinyint(4) NOT NULL,
  `identity_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_user_dept` (`dept_id`),
  KEY `fk_user_identity` (`identity_id`),
  KEY `user_id` (`user_id`,`user_name`),
  KEY `user_name` (`user_name`),
  CONSTRAINT `fk_user_dept` FOREIGN KEY (`dept_id`) REFERENCES `tbl_dept` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_identity` FOREIGN KEY (`identity_id`) REFERENCES `tbl_identity` (`identity_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'mongo', '123456', '1756223781', '791695518', '1', '1');
INSERT INTO `tbl_user` VALUES ('2', 'huzuwei', '123456', '18700950516', '1290499013', '1', '0');
INSERT INTO `tbl_user` VALUES ('3', 'zhangsan', '123123', '1578512565', '231154221', '2', '0');
