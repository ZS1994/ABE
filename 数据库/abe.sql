/*
Navicat MySQL Data Transfer

Source Server         : zs
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : abe

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-11-12 15:41:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `card`
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `c_id` varchar(255) NOT NULL DEFAULT '',
  `c_num` varchar(255) NOT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  `it_id` varchar(255) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  `c_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_num` (`c_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------

-- ----------------------------
-- Table structure for `card_log`
-- ----------------------------
DROP TABLE IF EXISTS `card_log`;
CREATE TABLE `card_log` (
  `cl_id` varchar(255) NOT NULL DEFAULT '',
  `c_id` varchar(255) DEFAULT NULL,
  `cl_time` datetime DEFAULT NULL,
  `cl_state` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card_log
-- ----------------------------

-- ----------------------------
-- Table structure for `ceshi`
-- ----------------------------
DROP TABLE IF EXISTS `ceshi`;
CREATE TABLE `ceshi` (
  `y` year(4) DEFAULT NULL,
  `id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ceshi
-- ----------------------------
INSERT INTO `ceshi` VALUES ('2001', '1');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` varchar(255) NOT NULL DEFAULT '',
  `c_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for `forum`
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `f_id` varchar(255) NOT NULL DEFAULT '',
  `f_content` varchar(255) DEFAULT NULL,
  `f_like` int(11) DEFAULT NULL,
  `f_create_time` datetime DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES ('041349048402255', '今天是暗暗地的晴天，心情好。', '2', '2016-11-04 13:49:04', '2');
INSERT INTO `forum` VALUES ('041514597569159', '再补充一句', '0', '2016-11-04 15:14:59', '2');
INSERT INTO `forum` VALUES ('091025067281683', '天晴了', '2', '2016-11-09 10:25:06', '2');

-- ----------------------------
-- Table structure for `forum_comment`
-- ----------------------------
DROP TABLE IF EXISTS `forum_comment`;
CREATE TABLE `forum_comment` (
  `fc_id` varchar(255) NOT NULL DEFAULT '',
  `fc_content` varchar(255) DEFAULT NULL,
  `fc_create_time` datetime DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  `f_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_comment
-- ----------------------------
INSERT INTO `forum_comment` VALUES ('041350419518100', '你说的不对，今天是下雨天，心情不好。', '2016-11-04 13:50:41', '2', '041349048402255');
INSERT INTO `forum_comment` VALUES ('041402093441169', '再补充一句', '2016-11-04 14:02:09', '2', '041349048402255');
INSERT INTO `forum_comment` VALUES ('041514182604408', '再补充一句', '2016-11-04 15:14:18', '2', '041349048402255');
INSERT INTO `forum_comment` VALUES ('091026383452692', '天很蓝', '2016-11-09 10:26:38', '1', '091025067281683');
INSERT INTO `forum_comment` VALUES ('091030502201674', '你在哪里', '2016-11-09 10:30:50', '2', '091025067281683');
INSERT INTO `forum_comment` VALUES ('091030594214051', '你好吗', '2016-11-09 10:30:59', '2', '091025067281683');
INSERT INTO `forum_comment` VALUES ('091031050305243', '下雨了', '2016-11-09 10:31:05', '2', '091025067281683');

-- ----------------------------
-- Table structure for `forum_like`
-- ----------------------------
DROP TABLE IF EXISTS `forum_like`;
CREATE TABLE `forum_like` (
  `fl_id` varchar(255) NOT NULL DEFAULT '',
  `f_id` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_like
-- ----------------------------
INSERT INTO `forum_like` VALUES ('091103268266335', '091025067281683', '1');
INSERT INTO `forum_like` VALUES ('091103480463287', '091025067281683', '2');

-- ----------------------------
-- Table structure for `info_parents`
-- ----------------------------
DROP TABLE IF EXISTS `info_parents`;
CREATE TABLE `info_parents` (
  `ip_id` varchar(255) NOT NULL DEFAULT '',
  `ip_name` varchar(255) DEFAULT NULL,
  `ip_sex` varchar(255) DEFAULT NULL,
  `ip_age` int(11) DEFAULT NULL,
  `ip_phone` varchar(255) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info_parents
-- ----------------------------

-- ----------------------------
-- Table structure for `info_student`
-- ----------------------------
DROP TABLE IF EXISTS `info_student`;
CREATE TABLE `info_student` (
  `is_id` varchar(255) NOT NULL DEFAULT '',
  `is_num` varchar(255) NOT NULL,
  `is_name` varchar(255) DEFAULT NULL,
  `is_sex` varchar(255) DEFAULT NULL,
  `is_birthday` date DEFAULT NULL,
  `is_age` int(11) DEFAULT NULL,
  `is_local` int(11) DEFAULT NULL,
  `is_teacher_children` int(11) DEFAULT NULL,
  `is_school` varchar(255) DEFAULT NULL,
  `is_grade` varchar(255) DEFAULT NULL,
  `is_class` varchar(255) DEFAULT NULL,
  `is_into_year` year(4) DEFAULT NULL,
  `is_parent_name` varchar(255) DEFAULT NULL,
  `is_parent_phone` varchar(255) DEFAULT NULL,
  `is_parent_relation` varchar(255) DEFAULT NULL,
  `is_into_date` date DEFAULT NULL,
  `is_leave_date` date DEFAULT NULL,
  `is_state` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  `sc_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`is_id`),
  UNIQUE KEY `is_num` (`is_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info_student
-- ----------------------------
INSERT INTO `info_student` VALUES ('021800143615870', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `info_student` VALUES ('021801067533512', '3', null, null, null, '21', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `info_student` VALUES ('021801341931046', '4', null, null, null, '21', null, null, null, null, null, null, '范冰冰', null, null, null, null, null, null, null);
INSERT INTO `info_student` VALUES ('031038565676712', '12', '丸子', '男', '2012-10-10', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `info_student` VALUES ('1', '1', null, null, null, null, null, null, null, null, null, '2016', null, null, null, null, null, null, null, null);
INSERT INTO `info_student` VALUES ('121424258992377', '123566', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `info_student` VALUES ('121424533788916', '1235661', null, null, '2016-10-12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `info_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `info_teacher`;
CREATE TABLE `info_teacher` (
  `it_id` varchar(255) NOT NULL DEFAULT '',
  `it_num` varchar(255) NOT NULL,
  `it_name` varchar(255) DEFAULT NULL,
  `it_sex` varchar(255) DEFAULT NULL,
  `it_birthday` date DEFAULT NULL,
  `it_age` int(11) DEFAULT NULL,
  `it_phone` varchar(255) DEFAULT NULL,
  `it_wechat` varchar(255) DEFAULT NULL,
  `it_qq` varchar(255) DEFAULT NULL,
  `it_section` varchar(255) DEFAULT NULL,
  `it_post` varchar(255) DEFAULT NULL,
  `it_into_date` date DEFAULT NULL,
  `it_leave_date` date DEFAULT NULL,
  `it_state` varchar(255) DEFAULT NULL,
  `it_last_time` datetime DEFAULT NULL,
  `it_create_time` datetime DEFAULT NULL,
  `it_address` varchar(255) DEFAULT NULL,
  `ss_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`it_id`),
  UNIQUE KEY `it_num` (`it_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info_teacher
-- ----------------------------
INSERT INTO `info_teacher` VALUES ('1', '1', '李老师', '女', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `n_id` varchar(255) NOT NULL,
  `n_title` varchar(255) NOT NULL,
  `n_content` varchar(255) DEFAULT NULL,
  `n_imgs` varchar(255) DEFAULT NULL,
  `n_url` varchar(255) DEFAULT NULL,
  `n_origin` varchar(255) DEFAULT NULL,
  `n_type` varchar(255) DEFAULT NULL,
  `n_creat_time` varchar(255) DEFAULT NULL,
  `n_final_time` varchar(255) DEFAULT NULL,
  `n_istop` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  `n_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for `place_area`
-- ----------------------------
DROP TABLE IF EXISTS `place_area`;
CREATE TABLE `place_area` (
  `pa_id` varchar(255) NOT NULL DEFAULT '',
  `pa_name` varchar(255) DEFAULT NULL,
  `pc_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of place_area
-- ----------------------------
INSERT INTO `place_area` VALUES ('081048178317015', '龙华新区', '081015244834643');

-- ----------------------------
-- Table structure for `place_city`
-- ----------------------------
DROP TABLE IF EXISTS `place_city`;
CREATE TABLE `place_city` (
  `pc_id` varchar(255) NOT NULL DEFAULT '',
  `pc_name` varchar(255) DEFAULT NULL,
  `pp_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of place_city
-- ----------------------------
INSERT INTO `place_city` VALUES ('081015244834643', '深圳', '1');

-- ----------------------------
-- Table structure for `place_province`
-- ----------------------------
DROP TABLE IF EXISTS `place_province`;
CREATE TABLE `place_province` (
  `pp_id` varchar(255) NOT NULL DEFAULT '',
  `pp_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of place_province
-- ----------------------------
INSERT INTO `place_province` VALUES ('1', '广东');
INSERT INTO `place_province` VALUES ('2', '湖北');

-- ----------------------------
-- Table structure for `recipe`
-- ----------------------------
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE `recipe` (
  `r_id` varchar(255) NOT NULL,
  `sc_id` varchar(255) DEFAULT NULL,
  `r_type` varchar(255) DEFAULT NULL,
  `r_time` varchar(255) DEFAULT NULL,
  `r_state` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  `r_creat_time` varchar(255) DEFAULT NULL,
  `r_status` varchar(255) DEFAULT NULL,
  `r_images` varchar(255) DEFAULT NULL,
  `is_id_accept` varchar(255) DEFAULT NULL,
  `is_id_all` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recipe
-- ----------------------------

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `s_id` varchar(255) NOT NULL DEFAULT '',
  `s_name` varchar(255) DEFAULT NULL,
  `s_address` varchar(255) DEFAULT NULL,
  `pa_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('081127533142283', '深圳市观澜第二小学', '深圳市观澜大道500号', '081048178317015');

-- ----------------------------
-- Table structure for `school_class`
-- ----------------------------
DROP TABLE IF EXISTS `school_class`;
CREATE TABLE `school_class` (
  `sc_id` varchar(255) NOT NULL DEFAULT '',
  `sc_name` varchar(255) DEFAULT NULL,
  `sg_id` varchar(255) DEFAULT NULL,
  `it_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_class
-- ----------------------------
INSERT INTO `school_class` VALUES ('081430070197575', '1-1班', '081350572999692', '1');

-- ----------------------------
-- Table structure for `school_grade`
-- ----------------------------
DROP TABLE IF EXISTS `school_grade`;
CREATE TABLE `school_grade` (
  `sg_id` varchar(255) NOT NULL DEFAULT '',
  `sg_name` varchar(255) DEFAULT NULL,
  `s_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_grade
-- ----------------------------
INSERT INTO `school_grade` VALUES ('081350572999692', '一年级', '081127533142283');

-- ----------------------------
-- Table structure for `school_section`
-- ----------------------------
DROP TABLE IF EXISTS `school_section`;
CREATE TABLE `school_section` (
  `ss_id` varchar(255) NOT NULL DEFAULT '',
  `ss_name` varchar(255) DEFAULT NULL,
  `s_id` varchar(255) DEFAULT NULL,
  `ss_id_last` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ss_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_section
-- ----------------------------

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `s_id` varchar(255) NOT NULL DEFAULT '',
  `s_score` int(11) DEFAULT NULL,
  `c_id` varchar(255) DEFAULT NULL,
  `is_id` varchar(255) DEFAULT NULL,
  `s_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for `timetables`
-- ----------------------------
DROP TABLE IF EXISTS `timetables`;
CREATE TABLE `timetables` (
  `t_id` varchar(255) NOT NULL DEFAULT '',
  `c_id` varchar(255) DEFAULT NULL,
  `sc_id` varchar(255) DEFAULT NULL,
  `it_id` varchar(255) DEFAULT NULL,
  `t_start_time` time DEFAULT NULL,
  `t_end_time` time DEFAULT NULL,
  `t_date` date DEFAULT NULL,
  `t_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of timetables
-- ----------------------------

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
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_num` (`u_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'qqq', '测试修改', '123', '2', null, 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/123213141/31223058436.png', null, null);
INSERT INTO `users` VALUES ('2', 'qwe', '张顺', '123', '1', '2016-10-26 23:08:14', 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/271634032221266/271634032221266.png', null, null);
