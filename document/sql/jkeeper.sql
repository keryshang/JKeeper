/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.106
 Source Server Type    : MySQL
 Source Server Version : 50743
 Source Host           : 192.168.1.106:3306
 Source Schema         : jkeeper

 Target Server Type    : MySQL
 Target Server Version : 50743
 File Encoding         : 65001

 Date: 25/09/2023 10:54:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ums_member
-- ----------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_level_id` bigint(20) NULL DEFAULT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `status` int(1) NULL DEFAULT NULL COMMENT '帐号启用状态:0->禁用；1->启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所做城市',
  `job` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `personalized_signature` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `source_type` int(1) NULL DEFAULT NULL COMMENT '用户来源',
  `integration` int(11) NULL DEFAULT NULL COMMENT '积分',
  `growth` int(11) NULL DEFAULT NULL COMMENT '成长值',
  `luckey_count` int(11) NULL DEFAULT NULL COMMENT '剩余抽奖次数',
  `history_integration` int(11) NULL DEFAULT NULL COMMENT '历史积分数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username`) USING BTREE,
  UNIQUE INDEX `idx_phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
