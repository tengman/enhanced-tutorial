/*
Navicat MySQL Data Transfer

Source Server         : 10.10.0.151
Source Server Version : 50717
Source Host           : 10.10.0.151:3306
Source Database       : tutorial

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-21 11:16:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `title` varchar(30) NOT NULL COMMENT '书名',
  `press` varchar(100) NOT NULL COMMENT '出版社',
  `category` tinyint(4) NOT NULL COMMENT '书籍所属类别',
  `author` varchar(20) NOT NULL COMMENT '作者',
  `printingPeriod` date NOT NULL COMMENT '印刷日期',
  `no` varchar(20) DEFAULT NULL COMMENT '编号',
  `price` decimal(10,2) NOT NULL COMMENT '单价',
  `createTime` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '记录创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `name` varchar(20) NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `name` varchar(10) DEFAULT NULL COMMENT '名称',
  `type` int(11) NOT NULL COMMENT '资源所属类型',
  `url` varchar(100) DEFAULT NULL COMMENT '资源的url',
  `parentId` int(11) DEFAULT NULL COMMENT '父类Id',
  `state` tinyint(255) NOT NULL DEFAULT '1' COMMENT '资源是否可用 1可用，-1不可用',
  `operation` tinyint(4) NOT NULL DEFAULT '0' COMMENT '增删改查',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES ('1', '管理面板', '1', '/admin/panel', null, '1', '1');
INSERT INTO `t_resource` VALUES ('2', '用户管理', '1', '/admin/user', null, '1', '15');
INSERT INTO `t_resource` VALUES ('3', '角色管理', '1', '/admin/role', null, '1', '15');
INSERT INTO `t_resource` VALUES ('4', '学生主页', '1', '/admin/main.do/student', null, '1', '0');
INSERT INTO `t_resource` VALUES ('5', '学生个人信息', '1', '/', null, '1', '0');
INSERT INTO `t_resource` VALUES ('6', '学生课表', '1', '/', null, '1', '0');
INSERT INTO `t_resource` VALUES ('7', '学生选课', '1', '/admin/elective.do/elective.view', null, '1', '0');
INSERT INTO `t_resource` VALUES ('8', '教师主页', '1', '/admin/main.do/teacher', null, '1', '0');
INSERT INTO `t_resource` VALUES ('9', '成绩录入', '1', '/', null, '1', '0');
INSERT INTO `t_resource` VALUES ('10', '教材添加', '1', '/admin/orderbook.do/orderbook.view', null, '1', '0');
INSERT INTO `t_resource` VALUES ('11', '学院管理', '1', '#', null, '1', '0');
INSERT INTO `t_resource` VALUES ('12', '整体概况', '2', '/', '11', '1', '0');
INSERT INTO `t_resource` VALUES ('13', '系部设置', '2', '/admin/dept.do/dept.view', '11', '1', '0');
INSERT INTO `t_resource` VALUES ('14', '专业设置', '2', '/admin/spec.do/spec.view', '11', '1', '0');
INSERT INTO `t_resource` VALUES ('15', '班级管理', '2', '/admin/clazz.do/clazz.view', '11', '1', '0');
INSERT INTO `t_resource` VALUES ('16', '添加课程', '2', '/admin/course.do/course.view', '11', '1', '0');
INSERT INTO `t_resource` VALUES ('17', '课程安排', '2', '/admin/section.do/section.view', '11', '1', '0');
INSERT INTO `t_resource` VALUES ('18', '学生管理', '2', '/admin/student.do/student.view', '11', '1', '0');
INSERT INTO `t_resource` VALUES ('19', ' 秘书审核', '2', '/admin/orderbook.do/orderbook_review.view', '11', '1', '0');

-- ----------------------------
-- Table structure for t_resource_type
-- ----------------------------
DROP TABLE IF EXISTS `t_resource_type`;
CREATE TABLE `t_resource_type` (
  `id` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL COMMENT '资源类型',
  `desc` varchar(20) DEFAULT NULL COMMENT '资源描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource_type
-- ----------------------------
INSERT INTO `t_resource_type` VALUES ('1', '1', '菜单');
INSERT INTO `t_resource_type` VALUES ('2', '2', '子菜单');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `role` varchar(20) NOT NULL COMMENT '角色标识字符串',
  `desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `resourceIds` varchar(50) DEFAULT NULL COMMENT '资源集合，逗号分隔',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '角色状态:1-可用 -1不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '超级管理员', '1,2,3,11,12,13,14,15,16,17,18,19', '1');
INSERT INTO `t_role` VALUES ('2', 'teacher', '老师', '8', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  `name` varchar(16) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(10) DEFAULT NULL COMMENT '盐：密码加密使用',
  `roleIds` varchar(100) DEFAULT NULL COMMENT '角色主键集,用逗号分隔',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态',
  `createTime` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `loginTime` datetime DEFAULT NULL COMMENT '登录时间',
  `loginAddress` varchar(100) DEFAULT NULL COMMENT '登录地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'tete', 'ca52659d995989a059fd6adeb87f76dc', '', '2', '1', '2017-12-13 06:48:29.433', null, 'qw');
INSERT INTO `t_user` VALUES ('2', 'admin', '0192023a7bbd73250516f069df18b500', null, '1', '1', '2017-12-15 07:48:05.081', null, '2');
INSERT INTO `t_user` VALUES ('6', 'one', '5a1ac3ea6adb8bc472100aa0d8f39818', null, '3', '1', '2017-12-20 05:46:08.600', null, null);
