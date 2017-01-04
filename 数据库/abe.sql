/*
Navicat MySQL Data Transfer

Source Server         : zhangshun
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : abe

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-01-03 10:08:57
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
INSERT INTO `all_inform` VALUES ('1', '老江湖的价值', '130904467975589', '扯了这么多，我想说的是，技术能力和阅历，随着程序员年龄和工作经验的增加，其重要性和价值将超越知识、技术本身。这是我们必须意识到的，这也是老江湖的价值所在。', '已发布', '2016-12-27 12:12:30.0');
INSERT INTO `all_inform` VALUES ('2', '企业的分类', '130904467975589', '外包型公司，通过承接别的企业的部分或全部软件业务来发展。这导致了业务不稳定，编程语言、技术框架等技术方面也不稳定。', '已发布', '2016-12-27 12:12:30.0');

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
INSERT INTO `card` VALUES ('0154791586', '1', '131230197602955', '131106520147201', '2016-12-27 19:37:41', '已发卡');

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
INSERT INTO `card_log` VALUES ('1612271370', '0154791586', '2016-12-27 19:41:48', '上车');
INSERT INTO `card_log` VALUES ('1612274624', '0154791586', '2016-12-27 19:41:46', '上车');
INSERT INTO `card_log` VALUES ('1612276823', '0154791586', '2016-12-27 19:41:47', '上车');
INSERT INTO `card_log` VALUES ('1612277356', '0154791586', '2016-12-27 19:39:39', '上车');
INSERT INTO `card_log` VALUES ('1612279850', '0154791586', '2016-12-27 19:41:47', '上车');

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
INSERT INTO `class_inform` VALUES ('1612313655', '明天家长会u', '131106520147201', '明天加战', '131109104493487', '已发布', '2016-12-31 23:42:30');

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
INSERT INTO `code` VALUES ('130904467975589', '18307211633', '862595', '2016-12-15 16:23:31', '2016-12-15 16:33:31');
INSERT INTO `code` VALUES ('212235023123815', '18307211633', '531361', '2016-12-22 10:40:19', '2016-12-22 10:50:19');
INSERT INTO `code` VALUES ('admin', '18307211633', '422614', '2016-12-22 10:34:57', '2016-12-22 10:44:57');

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
INSERT INTO `course` VALUES ('131102143658222', '语文');

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
INSERT INTO `forum` VALUES ('241232484992355', 'lala', '0', '2016-12-24 12:32:48', '212235023123815');
INSERT INTO `forum` VALUES ('261618077288521', 'aa', '0', '2016-12-26 16:18:07', '212235023123815');
INSERT INTO `forum` VALUES ('261618115659240', '33', '0', '2016-12-26 16:18:11', '212235023123815');
INSERT INTO `forum` VALUES ('261618157939624', '44', '0', '2016-12-26 16:18:15', '212235023123815');
INSERT INTO `forum` VALUES ('261618193346075', '55', '0', '2016-12-26 16:18:19', '212235023123815');
INSERT INTO `forum` VALUES ('261618221895245', '66', '0', '2016-12-26 16:18:22', '212235023123815');
INSERT INTO `forum` VALUES ('261618255591846', '77', '0', '2016-12-26 16:18:25', '212235023123815');
INSERT INTO `forum` VALUES ('261618309875582', '88', '0', '2016-12-26 16:18:30', '212235023123815');
INSERT INTO `forum` VALUES ('261618349033545', '99', '0', '2016-12-26 16:18:34', '212235023123815');
INSERT INTO `forum` VALUES ('261618378367627', '10', '0', '2016-12-26 16:18:37', '212235023123815');
INSERT INTO `forum` VALUES ('261618401134634', '11', '0', '2016-12-26 16:18:40', '212235023123815');
INSERT INTO `forum` VALUES ('261618434053352', '12', '0', '2016-12-26 16:18:43', '212235023123815');
INSERT INTO `forum` VALUES ('261619000819441', '13', '0', '2016-12-26 16:19:00', '212235023123815');
INSERT INTO `forum` VALUES ('261619030612803', '14', '0', '2016-12-26 16:19:03', '212235023123815');
INSERT INTO `forum` VALUES ('261619054017584', '15', '0', '2016-12-26 16:19:05', '212235023123815');
INSERT INTO `forum` VALUES ('261619080223471', '16', '1', '2016-12-26 16:19:08', '212235023123815');

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
INSERT INTO `forum_comment` VALUES ('1612294713', 'zheshi1', '2016-12-29 17:28:54', '212235023123815', '261619080223471');
INSERT INTO `forum_comment` VALUES ('1612307897', '123456', '2016-12-30 21:49:32', '212235023123815', '261619080223471');
INSERT INTO `forum_comment` VALUES ('1701011427', '搞什么啊', '2017-01-01 10:13:38', '131107321846506', '261619080223471');
INSERT INTO `forum_comment` VALUES ('241249437629248', 'ce', '2016-12-24 12:49:43', '212235023123815', '241232484992355');
INSERT INTO `forum_comment` VALUES ('241249564602492', 'faafa', '2016-12-24 12:49:56', '212235023123815', '241232484992355');

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
INSERT INTO `forum_like` VALUES ('1701015311', '261619080223471', '131107321846506');

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
INSERT INTO `info_parents` VALUES ('131232059508893', '张萍依', '女', '1995-06-21', '18307211633', '龙坑');
INSERT INTO `info_parents` VALUES ('212235022502632', null, null, null, '13265737301', null);

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
INSERT INTO `info_student` VALUES ('131230197602955', '201601001', '小美', '女', '2015-01-06', '1', '0', '2016-09-24', null, '正在校学生', '131109104493487', null);

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
INSERT INTO `info_teacher` VALUES ('131106520147201', '201602001', '李淑芳', '女', '1995-06-13', '18307211633', '授课老师', '2016-06-16', null, '在职', '龙坑', '');

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
INSERT INTO `licence` VALUES ('130903487494281', 'w37Rv91RHCox++dmMl1jwg==', '127.0.0.1', '2016-12-13 09:17:02', '2016-12-13 10:46:18');
INSERT INTO `licence` VALUES ('130904467975589', '18112', '172.16.1.241', '2016-12-31 17:55:47', '2016-12-31 18:56:14');
INSERT INTO `licence` VALUES ('130907379769695', '17565', '172.16.1.241', '2016-12-22 10:14:03', '2016-12-22 11:21:17');
INSERT INTO `licence` VALUES ('131107321846506', '17393', '172.16.1.241', '2017-01-01 09:51:21', '2017-01-01 11:38:33');
INSERT INTO `licence` VALUES ('212235023123815', '17990', '172.16.1.241', '2016-12-31 23:46:29', '2017-01-01 00:46:38');

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
INSERT INTO `news` VALUES ('1612277433', '儒家经典《大学》', '<p>\r\n\r\n<span style=\"color: rgb(54, 46, 43); font-family: &quot; microsoft yahei&quot;; font-size: 14px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: normal; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;\" data-fr-verified=\"true\">所以，早在几千年前，我们的儒家经典《大学》就预料到了将来会有程序员这种人群，对他们的生活做出了概括性的预言：“苟日新，日日新，又日新”。</span>\r\n\r\n<br></p>', null, null, '请输入...', '新闻', '2016-12-27 16:08:35', '2016-12-27 16:08:35', '0', '130904467975589', '1');
INSERT INTO `news` VALUES ('1612278463', '《天龙八部》', '<p>\r\n\r\n<span style=\"color: rgb(54, 46, 43); font-family: &quot; microsoft yahei&quot;; font-size: 14px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: normal; letter-spacing: normal; orphans: 2; text-align: left; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;\" data-fr-verified=\"true\">《天龙八部》中的神仙姐姐王语嫣，很多少年看了都很喜欢。从IT的角度看，她实际上就是一个掌握了很多知识、技术的字典型程序员，但不会实际开发。</span>\r\n\r\n<br></p>', null, null, '请输入...', '新闻', '2016-12-27 16:09:50', '2016-12-27 16:09:50', '0', '130904467975589', '1');

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
INSERT INTO `person_inform` VALUES ('1', '老江湖的价值', '扯了这么多，我想说的是，技术能力和阅历，随着程序员年龄和工作经验的增加，其重要性和价值将超越知识、技术本身。这是我们必须意识到的，这也是老江湖的价值所在。', '130904467975589', '已发布', '2016-12-27 12:12:30.0');
INSERT INTO `person_inform` VALUES ('2', '企业的分类', '外包型公司，通过承接别的企业的部分或全部软件业务来发展。这导致了业务不稳定，编程语言、技术框架等技术方面也不稳定。', '130904467975589', '已发布', '2016-12-27 12:12:30.0');

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
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_role
-- ----------------------------
INSERT INTO `power_role` VALUES ('1612274121', '超级管理员', '又有所有权限', '0', '2016-12-27 12:12:30', '130904467975589');

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
INSERT INTO `power_role_permission` VALUES ('1612271500', '1612274121', '2');
INSERT INTO `power_role_permission` VALUES ('1612272585', '1612274121', '4');
INSERT INTO `power_role_permission` VALUES ('1612277512', '1612274121', '3');
INSERT INTO `power_role_permission` VALUES ('1612278949', '1612274121', '1');

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
INSERT INTO `school` VALUES ('131105025965483', '深圳市第二幼儿园', '深圳市福田区通心岭同心路9号', '1');

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
INSERT INTO `school_class` VALUES ('131109104493487', '1班', '131105203177247', '131106520147201', '2016-12-13 11:09:10', '有效');

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
INSERT INTO `school_grade` VALUES ('131105203177247', '1年级', '131105025965483');

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
INSERT INTO `student_parent_rel` VALUES ('151624302612422', '131230197602955', '131232059508893', '妈妈');
INSERT INTO `student_parent_rel` VALUES ('221040591864498', '131230197602955', '212235022502632', '爸爸');

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
INSERT INTO `timetables` VALUES ('131110186686403', '131102143658222', '131109104493487', '131106520147201', '10:30:00', '11:00:00', '1', '1');

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
  UNIQUE KEY `u_num` (`u_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('130903487494281', '13265737301', 'jack', '123456', '1', '2016-12-13 09:03:48', null, null, null, null);
INSERT INTO `users` VALUES ('130904467975589', 'test', 'test', '123', '1', '2016-12-13 09:04:46', 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/130904467975589/21105917366.png', null, null, '1612274121');
INSERT INTO `users` VALUES ('130907379769695', 'test001', 'chang', '123', '1', '2016-12-13 09:07:37', null, null, null, null);
INSERT INTO `users` VALUES ('131107321846506', 'lsf', '小李', '123', '2', '2016-12-13 11:07:48', null, null, '131106520147201', null);
INSERT INTO `users` VALUES ('131233468047161', 'zpy', '平移', '123', '1', '2016-12-13 12:33:46', null, null, '131232059508893', null);
INSERT INTO `users` VALUES ('1612318856', 'pake', '帕克', '123', '2', '2016-12-31 18:29:52', null, null, '212235022502632', '1612274121');
INSERT INTO `users` VALUES ('212235023123815', 'test002', 'chang', '123', '1', '2016-12-21 22:35:02', 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/212235023123815/22102733661.png', null, '212235022502632', null);

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
INSERT INTO `vacate` VALUES ('1612296778', '131230197602955', '212235023123815', '131106520147201', '大大', '2016-12-29  上午', '2016-12-29 14:49:35', '');
INSERT INTO `vacate` VALUES ('1612298054', '131230197602955', '212235023123815', '131106520147201', '病假', '2016-12-29  全天', '2016-12-29 14:44:44', '');
INSERT INTO `vacate` VALUES ('1612299385', '131230197602955', '212235023123815', '131106520147201', 'yes nice bus math', '2016-12-29  上午', '2016-12-29 14:57:04', '');
