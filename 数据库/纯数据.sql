/*
Navicat MySQL Data Transfer

Source Server         : zs
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : abe

Target Server Type    : MYSQL
Target Server Version : 60099
File Encoding         : 65001

Date: 2016-12-12 17:44:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Records of all_inform
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of card
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of card_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of ceshi
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of class_inform
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of code
-- ----------------------------
BEGIN;
INSERT INTO `code` VALUES ('121634531947973', '15817383353', '833524', '2016-12-12 16:45:24', '2016-12-12 16:55:24');
COMMIT;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('121609334029681', '1'), ('121609349265752', '2'), ('121609365558290', '3'), ('121609381195341', '1');
COMMIT;

-- ----------------------------
-- Records of forum
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of forum_comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of forum_like
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of hx_group
-- ----------------------------
BEGIN;
INSERT INTO `hx_group` VALUES ('274733559288168976', '1班2016年12月', '121454061227706', '1班2016年12月。系统默认自动创建。', '2016-12-12 16:25:31', 'native');
COMMIT;

-- ----------------------------
-- Records of info_parents
-- ----------------------------
BEGIN;
INSERT INTO `info_parents` VALUES ('121631303308559', '黄福华', '男', '1998-02-13', '15817383353', '福田');
COMMIT;

-- ----------------------------
-- Records of info_student
-- ----------------------------
BEGIN;
INSERT INTO `info_student` VALUES ('121629582332762', '2016010001', '小美', '女', '2015-01-01', '1', '0', '2016-09-01', null, '正在校学生', '121625317338152', null);
COMMIT;

-- ----------------------------
-- Records of info_teacher
-- ----------------------------
BEGIN;
INSERT INTO `info_teacher` VALUES ('121617080757562', '2016020001', '李淑芳', '女', '1996-06-12', '18681543873', '授课老师', '2016-12-12', null, '入职', '龙坑', '');
COMMIT;

-- ----------------------------
-- Records of licence
-- ----------------------------
BEGIN;
INSERT INTO `licence` VALUES ('121454061227706', 'Anv3xUwcl0YDy+dtfGxlvg==', '127.0.0.1', '2016-12-12 16:21:32', '2016-12-12 17:21:32'), ('121634531947973', 'roTI3mPcywd9T5Cs4Xpkog==', '127.0.0.1', '2016-12-12 16:42:27', '2016-12-12 17:45:54'), ('271634032221266', 'zx+N7EPWpJEn+hnjUDTlEQ==', '127.0.0.1', '2016-12-12 14:52:58', '2016-12-12 15:52:58');
COMMIT;

-- ----------------------------
-- Records of news
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of person_inform
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of place_area
-- ----------------------------
BEGIN;
INSERT INTO `place_area` VALUES ('1', '龙华新区', '1');
COMMIT;

-- ----------------------------
-- Records of place_city
-- ----------------------------
BEGIN;
INSERT INTO `place_city` VALUES ('1', '深圳', '1');
COMMIT;

-- ----------------------------
-- Records of place_province
-- ----------------------------
BEGIN;
INSERT INTO `place_province` VALUES ('1', '广东');
COMMIT;

-- ----------------------------
-- Records of recipe
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of return
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of school
-- ----------------------------
BEGIN;
INSERT INTO `school` VALUES ('121450439752915', '深圳市第二幼儿园', '深圳市福田区通心岭同心路9号', '1');
COMMIT;

-- ----------------------------
-- Records of school_class
-- ----------------------------
BEGIN;
INSERT INTO `school_class` VALUES ('121625317338152', '1班', '1', '121617080757562', '2016-12-12 16:25:31', '有效');
COMMIT;

-- ----------------------------
-- Records of school_grade
-- ----------------------------
BEGIN;
INSERT INTO `school_grade` VALUES ('121451107531942', '1年级', '121450439752915'), ('121451250157260', '2年级', '121450439752915');
COMMIT;

-- ----------------------------
-- Records of school_section
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of score
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of student_parent_rel
-- ----------------------------
BEGIN;
INSERT INTO `student_parent_rel` VALUES ('121717088049855', '121629582332762', '121631303308559', '父女');
COMMIT;

-- ----------------------------
-- Records of timetables
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('121454061227706', 'lsf', '李老师', '123', '2', '2016-12-12 14:54:06', null, null, '121617080757562'), ('121634531947973', 'hxs', '黄先生', '123', '1', '2016-12-12 16:34:53', null, null, '121631303308559'), ('271634032221266', 'qwe', '张顺', '123', '1', '2016-10-26 23:08:14', 'http://zhangshun-zs1994.oicp.net:15202/ABE_WEB/photo/271634032221266/26180936276.png', null, '1');
COMMIT;

-- ----------------------------
-- Records of vacate
-- ----------------------------
BEGIN;
COMMIT;
