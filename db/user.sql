/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : spdb

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-12-06 08:53:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(200) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$2SEEBYecvUr0MeP7.afSvu1VQmnsRPR.2tLRx0pIX3vgMUjZUcOqG');
INSERT INTO `user` VALUES ('2', 'user', '$2a$10$2SEEBYecvUr0MeP7.afSvu1VQmnsRPR.2tLRx0pIX3vgMUjZUcOqG');
