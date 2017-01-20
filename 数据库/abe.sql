/*
Navicat MySQL Data Transfer

Source Server         : zs
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : abe

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-01-20 17:16:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `all_inform`
-- ----------------------------
DROP TABLE IF EXISTS `all_inform`;
CREATE TABLE `all_inform` (
  `ai_id` varchar(255) NOT NULL,
  `ai_title` varchar(255) DEFAULT NULL,
  `it_id` varchar(255) DEFAULT NULL,
  `ai_content` varchar(255) DEFAULT NULL,
  `ai_status` varchar(255) DEFAULT NULL,
  `ai_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ai_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of all_inform
-- ----------------------------

-- ----------------------------
-- Table structure for `card`
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `c_id` varchar(255) NOT NULL DEFAULT '',
  `c_type` varchar(255) DEFAULT NULL,
  `srt_id` varchar(255) DEFAULT NULL,
  `it_id` varchar(255) DEFAULT NULL,
  `c_create_time` datetime DEFAULT NULL,
  `c_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('', '1', '121629582332762', '121617080757562', null, '已发卡');
INSERT INTO `card` VALUES ('1231231232312', '1', '121629582332762', '121617080757562', '2016-12-19 19:54:47', '已发卡');

-- ----------------------------
-- Table structure for `card_log`
-- ----------------------------
DROP TABLE IF EXISTS `card_log`;
CREATE TABLE `card_log` (
  `cl_id` varchar(255) NOT NULL DEFAULT '',
  `c_id` varchar(255) DEFAULT NULL,
  `cl_time` datetime DEFAULT NULL,
  `cl_state` varchar(255) DEFAULT NULL,
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

-- ----------------------------
-- Table structure for `class_inform`
-- ----------------------------
DROP TABLE IF EXISTS `class_inform`;
CREATE TABLE `class_inform` (
  `ci_id` varchar(255) NOT NULL,
  `ci_title` varchar(255) DEFAULT NULL,
  `it_id` varchar(255) DEFAULT NULL,
  `ci_content` varchar(255) DEFAULT NULL,
  `sc_id` varchar(255) DEFAULT NULL,
  `ci_status` varchar(255) DEFAULT NULL,
  `ci_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ci_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_inform
-- ----------------------------

-- ----------------------------
-- Table structure for `code`
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `u_id` varchar(255) NOT NULL DEFAULT '',
  `c_phone` varchar(255) DEFAULT NULL,
  `c_code` varchar(255) DEFAULT NULL,
  `c_time` datetime DEFAULT NULL,
  `c_no_time` datetime DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code
-- ----------------------------
INSERT INTO `code` VALUES ('121634531947973', '15817383353', '833524', '2016-12-12 16:45:24', '2016-12-12 16:55:24');
INSERT INTO `code` VALUES ('admin', '18307211633', '152567', '2016-12-21 20:29:51', '2016-12-21 20:39:51');

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
INSERT INTO `course` VALUES ('131048219119868', '语文');
INSERT INTO `course` VALUES ('131048252282289', '数学');
INSERT INTO `course` VALUES ('1701123996', '&quot;体育&quot;&lt;br/&gt;&quot;&quot;你好');

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

-- ----------------------------
-- Table structure for `hx_group`
-- ----------------------------
DROP TABLE IF EXISTS `hx_group`;
CREATE TABLE `hx_group` (
  `g_id` varchar(255) NOT NULL DEFAULT '',
  `g_name` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  `g_desc` varchar(255) DEFAULT NULL,
  `g_create_time` datetime DEFAULT NULL,
  `g_note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hx_group
-- ----------------------------
INSERT INTO `hx_group` VALUES ('274733559288168976', '1班2016年12月', '121454061227706', '1班2016年12月。系统默认自动创建。', '2016-12-12 16:25:31', 'native');

-- ----------------------------
-- Table structure for `info_parents`
-- ----------------------------
DROP TABLE IF EXISTS `info_parents`;
CREATE TABLE `info_parents` (
  `ip_id` varchar(255) NOT NULL DEFAULT '',
  `ip_name` varchar(255) DEFAULT NULL,
  `ip_sex` varchar(255) DEFAULT NULL,
  `ip_birthday` date DEFAULT NULL,
  `ip_phone` varchar(255) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info_parents
-- ----------------------------
INSERT INTO `info_parents` VALUES ('121631303308559', '黄福华', '男', '1998-02-13', '15817383353', '福田');
INSERT INTO `info_parents` VALUES ('212030046888631', null, null, null, '18307211633', null);

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
  `is_local` int(11) DEFAULT NULL,
  `is_teacher_children` int(11) DEFAULT NULL,
  `is_into_date` date DEFAULT NULL,
  `is_leave_date` date DEFAULT NULL,
  `is_state` varchar(255) DEFAULT NULL,
  `sc_id` varchar(255) DEFAULT NULL,
  `is_class_line` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`is_id`),
  UNIQUE KEY `is_num` (`is_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info_student
-- ----------------------------
INSERT INTO `info_student` VALUES ('121629582332762', '2016010001', '小美', '女', '2015-01-01', '1', '0', '2016-09-01', '2016-09-01', '正常就读', '121625317338152', null);
INSERT INTO `info_student` VALUES ('151049180533419', '2016010002', '小天', '男', null, '0', '0', null, null, '已退学', '121625317338152', null);
INSERT INTO `info_student` VALUES ('1701148276', '2016010101', '徐福', '男', '2014-01-08', '1', '0', '2017-01-14', null, '正常就读', '1701141614', null);

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
  `it_phone` varchar(255) DEFAULT NULL,
  `it_post` varchar(255) DEFAULT NULL,
  `it_into_date` date DEFAULT NULL,
  `it_leave_date` date DEFAULT NULL,
  `it_state` varchar(255) DEFAULT NULL,
  `it_address` varchar(255) DEFAULT NULL,
  `ss_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`it_id`),
  UNIQUE KEY `it_num` (`it_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info_teacher
-- ----------------------------
INSERT INTO `info_teacher` VALUES ('121617080757562', '2016020001', '李淑芳', '女', '1996-06-12', '18681543873', '授课老师', '2016-12-12', null, '正常在校', '龙坑', null);
INSERT INTO `info_teacher` VALUES ('1701075088', '201602', '李小薇', '女', '1992-01-07', '18307211633', '授课老师', '2017-01-07', null, '正常在校', '广水', null);

-- ----------------------------
-- Table structure for `licence`
-- ----------------------------
DROP TABLE IF EXISTS `licence`;
CREATE TABLE `licence` (
  `u_id` varchar(255) NOT NULL DEFAULT '',
  `l_licence` varchar(255) DEFAULT NULL,
  `l_ip` varchar(255) DEFAULT NULL,
  `l_date_start` datetime DEFAULT NULL,
  `l_date_end` datetime DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of licence
-- ----------------------------
INSERT INTO `licence` VALUES ('121454061227706', 'Anv3xUwcl0YDy+dtfGxlvg==', '127.0.0.1', '2016-12-12 16:21:32', '2016-12-12 17:21:32');
INSERT INTO `licence` VALUES ('121634531947973', 'roTI3mPcywd9T5Cs4Xpkog==', '127.0.0.1', '2016-12-12 16:42:27', '2016-12-12 17:45:54');
INSERT INTO `licence` VALUES ('131006370239645', 'CPJ26Ja1ms+ZZyYCIXZAqg==', '127.0.0.1', '2016-12-13 10:14:24', '2016-12-13 11:14:39');
INSERT INTO `licence` VALUES ('271634032221266', '17610', '127.0.0.1', '2017-01-06 16:12:45', '2017-01-06 17:18:15');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `n_id` varchar(255) NOT NULL,
  `n_title` varchar(255) NOT NULL,
  `n_content` text,
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
INSERT INTO `news` VALUES ('201538456445059', '好好好', '<p>啊实打实大大啊实打实大声道的萨达是的撒的打算的11111111111111</p>', null, null, '请输入...', '生活', '2016-12-20 00:00:00', '2016-12-20 17:03:34', '0', '1', '1');
INSERT INTO `news` VALUES ('201703570213957', '的点点滴滴', '<p>啊实打实大声道的</p>', null, null, '阿萨德', '生活', '2016-12-20 00:00:00', '2016-12-20 17:04:11', '0', '1', '1');

-- ----------------------------
-- Table structure for `person_inform`
-- ----------------------------
DROP TABLE IF EXISTS `person_inform`;
CREATE TABLE `person_inform` (
  `pi_id` varchar(255) NOT NULL,
  `pi_title` varchar(255) DEFAULT NULL,
  `pi_content` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  `pi_status` varchar(255) DEFAULT NULL,
  `pi_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person_inform
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
INSERT INTO `place_area` VALUES ('1', '龙华新区', '1');

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
INSERT INTO `place_city` VALUES ('1', '深圳', '1');

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
-- Table structure for `power_permission`
-- ----------------------------
DROP TABLE IF EXISTS `power_permission`;
CREATE TABLE `power_permission` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_permission
-- ----------------------------
INSERT INTO `power_permission` VALUES ('1', '用户添加');
INSERT INTO `power_permission` VALUES ('2', '用户删除');
INSERT INTO `power_permission` VALUES ('3', '用户修改');
INSERT INTO `power_permission` VALUES ('4', '用户查询');

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
  `r_type` varchar(255) DEFAULT NULL,
  `s_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_role
-- ----------------------------
INSERT INTO `power_role` VALUES ('1701148497', '超级管理员', '全部的权限', '0', '2017-01-14 17:35:06', '121454061227706', '超级管理员', '121450439752915');
INSERT INTO `power_role` VALUES ('1701202326', '校长办公室', '管理各部门运作', '0', '2017-01-20 16:56:10', '1701204598', '学校管理员', '1701146144');
INSERT INTO `power_role` VALUES ('1701206296', '行政部', '普通', '0,1701202326', '2017-01-20 16:58:59', '1701204598', '普通', '1701146144');

-- ----------------------------
-- Table structure for `power_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `power_role_permission`;
CREATE TABLE `power_role_permission` (
  `rp_id` varchar(255) NOT NULL DEFAULT '',
  `r_id` varchar(255) DEFAULT NULL,
  `p_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_role_permission
-- ----------------------------
INSERT INTO `power_role_permission` VALUES ('1701143871', '1701148497', '2');
INSERT INTO `power_role_permission` VALUES ('1701146060', '1701148497', '4');
INSERT INTO `power_role_permission` VALUES ('1701146097', '1701148497', '3');
INSERT INTO `power_role_permission` VALUES ('1701148492', '1701148497', '1');
INSERT INTO `power_role_permission` VALUES ('1701203911', '1701202326', '3');
INSERT INTO `power_role_permission` VALUES ('1701204932', '1701202326', '4');
INSERT INTO `power_role_permission` VALUES ('1701204989', '1701202326', '1');
INSERT INTO `power_role_permission` VALUES ('1701205531', '1701202326', '2');
INSERT INTO `power_role_permission` VALUES ('1701207729', '1701206296', '4');

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
  `r_images_url` varchar(255) DEFAULT NULL,
  `is_id_accept` varchar(255) DEFAULT NULL,
  `is_id_all` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recipe
-- ----------------------------

-- ----------------------------
-- Table structure for `return`
-- ----------------------------
DROP TABLE IF EXISTS `return`;
CREATE TABLE `return` (
  `r_id` varchar(255) NOT NULL,
  `r_content` varchar(255) DEFAULT NULL,
  `r_time` varchar(255) DEFAULT NULL,
  `r_status` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of return
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
INSERT INTO `school` VALUES ('121450439752915', '深圳市第二幼儿园', '深圳市福田区通心岭同心路9号', '1');
INSERT INTO `school` VALUES ('1701146144', '阳光幼儿园', '福明看守所', '1');

-- ----------------------------
-- Table structure for `school_class`
-- ----------------------------
DROP TABLE IF EXISTS `school_class`;
CREATE TABLE `school_class` (
  `sc_id` varchar(255) NOT NULL DEFAULT '',
  `sc_name` varchar(255) DEFAULT NULL,
  `sg_id` varchar(255) DEFAULT NULL,
  `it_id` varchar(255) DEFAULT NULL,
  `sc_create_time` datetime DEFAULT NULL,
  `sc_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_class
-- ----------------------------
INSERT INTO `school_class` VALUES ('121625317338152', '1班', '121451107531942', '121617080757562', '2016-12-12 16:25:31', '有效');
INSERT INTO `school_class` VALUES ('1701141614', '1班', '1701143372', '1701075088', '2017-01-14 13:41:35', '有效');

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
INSERT INTO `school_grade` VALUES ('121451107531942', '1年级', '121450439752915');
INSERT INTO `school_grade` VALUES ('121451250157260', '2年级', '121450439752915');
INSERT INTO `school_grade` VALUES ('1701143372', '1年级', '1701146144');

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
-- Table structure for `student_parent_rel`
-- ----------------------------
DROP TABLE IF EXISTS `student_parent_rel`;
CREATE TABLE `student_parent_rel` (
  `sp_id` varchar(255) NOT NULL DEFAULT '',
  `is_id` varchar(255) DEFAULT NULL,
  `ip_id` varchar(255) DEFAULT NULL,
  `sp_relation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_parent_rel
-- ----------------------------
INSERT INTO `student_parent_rel` VALUES ('121717088049855', '121629582332762', '121631303308559', '父女');

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
  `t_week` int(11) DEFAULT NULL,
  `t_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of timetables
-- ----------------------------
INSERT INTO `timetables` VALUES ('131049001449070', '131048219119868', '121625317338152', '121617080757562', '10:30:00', '11:00:00', '1', '1');

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
INSERT INTO `users` VALUES ('1', 'yd-7111', '张顺', '123456', '1', null, null, null, '', '1612278984');
INSERT INTO `users` VALUES ('121454061227706', 'lsf', '李老师', '123', '2', '2016-12-12 14:54:06', null, null, '121617080757562', '1701148497');
INSERT INTO `users` VALUES ('121634531947973', 'hxs', '黄先生', '123', '1', '2016-12-12 16:34:53', null, null, '121631303308559', null);
INSERT INTO `users` VALUES ('131006370239645', 'sljr', '山岭巨人', '123', '1', '2016-12-13 10:06:36', 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/131006370239645/13101439834.png', null, '', null);
INSERT INTO `users` VALUES ('1701204598', 'lxw', '小李', '123', '2', '2017-01-20 16:52:56', null, null, '1701075088', '1701202326');
INSERT INTO `users` VALUES ('212030047403656', '00123', '提阿尼头', '123', '1', '2016-12-21 20:30:04', null, null, '212030046888631', null);
INSERT INTO `users` VALUES ('271634032221266', 'qwe', '张顺1', '123', '1', '2016-10-26 23:08:14', 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/271634032221266/13101330046.png', null, '1', '1612278984');

-- ----------------------------
-- Table structure for `vacate`
-- ----------------------------
DROP TABLE IF EXISTS `vacate`;
CREATE TABLE `vacate` (
  `v_id` varchar(255) NOT NULL,
  `is_id` varchar(255) DEFAULT NULL,
  `u_id` varchar(255) DEFAULT NULL,
  `it_id` varchar(255) DEFAULT NULL,
  `v_content` varchar(255) DEFAULT NULL,
  `v_date` varchar(255) DEFAULT NULL,
  `v_time` varchar(255) DEFAULT NULL,
  `v_resp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vacate
-- ----------------------------
