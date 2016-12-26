/*
Navicat MySQL Data Transfer

Source Server         : zs
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : abe

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-12-26 18:18:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `power_role`
-- ----------------------------
DROP TABLE IF EXISTS `power_role`;
CREATE TABLE `power_role` (
  `r_id` varchar(255) NOT NULL DEFAULT '',
  `r_name` varchar(255) DEFAULT NULL,
  `r_desc` varchar(255) DEFAULT NULL,
  `r_parent_ids` varchar(255) DEFAULT NULL,
  `r_create_time` datetime DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_role
-- ----------------------------
INSERT INTO `power_role` VALUES ('1612264116', '经理', '11', '0', '2016-12-26 16:09:57', '271634032221266');
INSERT INTO `power_role` VALUES ('1612264742', '222222222', '2222222', '0', '2016-12-26 16:23:30', '271634032221266');
INSERT INTO `power_role` VALUES ('1612268207', '小经理', '213', '0', '2016-12-26 16:22:31', '271634032221266');

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
  `u_photo_path` varchar(255) DEFAULT NULL,
  `u_note` varchar(255) DEFAULT NULL,
  `trp_id` varchar(255) DEFAULT NULL,
  `r_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_num` (`u_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'yd-7111', '', '123456', '1', null, null, null, '', '1612264116');
INSERT INTO `users` VALUES ('121454061227706', 'lsf', '李老师', '123', '2', '2016-12-12 14:54:06', null, null, '121617080757562', null);
INSERT INTO `users` VALUES ('121634531947973', 'hxs', '黄先生', '123', '1', '2016-12-12 16:34:53', null, null, '121631303308559', null);
INSERT INTO `users` VALUES ('131006370239645', 'sljr', '山岭巨人', '123', '1', '2016-12-13 10:06:36', 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/131006370239645/13101439834.png', null, '', null);
INSERT INTO `users` VALUES ('212030047403656', '00123', '提阿尼头', '123', '1', '2016-12-21 20:30:04', null, null, '212030046888631', null);
INSERT INTO `users` VALUES ('271634032221266', 'qwe', '张顺1', '123', '1', '2016-10-26 23:08:14', 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/271634032221266/13101330046.png', null, '1', '1612268207');
