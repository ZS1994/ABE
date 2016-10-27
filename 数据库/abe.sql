/*
Navicat MySQL Data Transfer

Source Server         : zs
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : abe

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-10-27 15:38:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` varchar(255) NOT NULL DEFAULT '',
  `u_num` varchar(255) NOT NULL DEFAULT '',
  `u_name` varchar(255) DEFAULT NULL,
  `u_pass` varchar(255) DEFAULT NULL,
  `u_type` varchar(255) DEFAULT NULL,
  `u_create_time` datetime DEFAULT NULL,
  `u_note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_num` (`u_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1111', 'qwe', '张顺', '123', '001', '2016-10-26 23:08:14', null);
