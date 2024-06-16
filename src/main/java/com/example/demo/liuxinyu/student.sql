/*
 Navicat Premium Data Transfer

 Source Server         : baicai
 Source Server Type    : MySQL
 Source Server Version : 50734 (5.7.34-log)
 Source Host           : localhost:3306
 Source Schema         : mysql_demo

 Target Server Type    : MySQL
 Target Server Version : 50734 (5.7.34-log)
 File Encoding         : 65001

 Date: 16/06/2024 16:20:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `classroomid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `classroomid`(`classroomid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '白菜', 11, '101');
INSERT INTO `student` VALUES ('2', '狗蛋', 12, '101');
INSERT INTO `student` VALUES ('3', '臭臭', 8, '201');
INSERT INTO `student` VALUES ('4', '二蛋', 15, '103');
INSERT INTO `student` VALUES ('5', '迪迪', 11, '101');

SET FOREIGN_KEY_CHECKS = 1;
