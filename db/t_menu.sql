/*
 Navicat Premium Data Transfer

 Source Server         : docker-Mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.1.195:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 11/01/2020 11:48:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, 'eawedasd');
INSERT INTO `t_menu` VALUES (2, 'adsdasd');
INSERT INTO `t_menu` VALUES (3, 'dasdasda');
INSERT INTO `t_menu` VALUES (4, 'asdasdasd');
INSERT INTO `t_menu` VALUES (5, 'asdasdas');

SET FOREIGN_KEY_CHECKS = 1;
