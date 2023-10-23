-- ----------------------------
-- Table structure for branch_table
-- ----------------------------
DROP TABLE IF EXISTS `branch_table`;
CREATE TABLE `branch_table`  (
    `branch_id` bigint(20) NOT NULL,
    `xid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `transaction_id` bigint(20) NULL DEFAULT NULL,
    `resource_group_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `resource_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `branch_type` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `status` tinyint(4) NULL DEFAULT NULL,
    `client_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `application_data` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `gmt_create` datetime(6) NULL DEFAULT NULL,
    `gmt_modified` datetime(6) NULL DEFAULT NULL,
    PRIMARY KEY (`branch_id`) USING BTREE,
    INDEX `idx_xid`(`xid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for distributed_lock
-- ----------------------------
DROP TABLE IF EXISTS `distributed_lock`;
CREATE TABLE `distributed_lock`  (
    `lock_key` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `lock_value` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `expire` bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`lock_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of distributed_lock
-- ----------------------------
INSERT INTO `distributed_lock` VALUES ('AsyncCommitting', ' ', 0);
INSERT INTO `distributed_lock` VALUES ('RetryCommitting', ' ', 0);
INSERT INTO `distributed_lock` VALUES ('RetryRollbacking', ' ', 0);
INSERT INTO `distributed_lock` VALUES ('TxTimeoutCheck', ' ', 0);

-- ----------------------------
-- Table structure for global_table
-- ----------------------------
DROP TABLE IF EXISTS `global_table`;
CREATE TABLE `global_table`  (
     `xid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     `transaction_id` bigint(20) NULL DEFAULT NULL,
     `status` tinyint(4) NOT NULL,
     `application_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     `transaction_service_group` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     `transaction_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     `timeout` int(11) NULL DEFAULT NULL,
     `begin_time` bigint(20) NULL DEFAULT NULL,
     `application_data` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     `gmt_create` datetime(0) NULL DEFAULT NULL,
     `gmt_modified` datetime(0) NULL DEFAULT NULL,
     PRIMARY KEY (`xid`) USING BTREE,
     INDEX `idx_gmt_modified_status`(`gmt_modified`, `status`) USING BTREE,
     INDEX `idx_transaction_id`(`transaction_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for lock_table
-- ----------------------------
DROP TABLE IF EXISTS `lock_table`;
CREATE TABLE `lock_table`  (
    `row_key` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `xid` varchar(96) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `transaction_id` bigint(20) NULL DEFAULT NULL,
    `branch_id` bigint(20) NOT NULL,
    `resource_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `table_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `pk` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `gmt_create` datetime(0) NULL DEFAULT NULL,
    `gmt_modified` datetime(0) NULL DEFAULT NULL,
    PRIMARY KEY (`row_key`) USING BTREE,
    INDEX `idx_branch_id`(`branch_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id` bigint(20) NOT NULL,
    `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `rollback_info` longblob NOT NULL,
    `log_status` int(11) NOT NULL,
    `log_created` datetime(0) NOT NULL,
    `log_modified` datetime(0) NOT NULL,
    `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seata_account
-- ----------------------------
DROP TABLE IF EXISTS `seata_account`;
CREATE TABLE `seata_account`  (
    `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` bigint(11) NULL DEFAULT NULL COMMENT '用户id',
    `total` decimal(10, 0) NULL DEFAULT NULL COMMENT '总额度',
    `used` decimal(10, 0) NULL DEFAULT NULL COMMENT '已用余额',
    `residue` decimal(10, 0) NULL COMMENT '剩余可用额度',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seata_account
-- ----------------------------
INSERT INTO `seata_account` VALUES (1, 1, 1000, 0, 1000);

-- ----------------------------
-- Table structure for seata_order
-- ----------------------------
DROP TABLE IF EXISTS `seata_order`;
CREATE TABLE `seata_order`  (
    `id` bigint(11) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(11) NULL DEFAULT NULL COMMENT '用户id',
    `product_id` bigint(11) NULL DEFAULT NULL COMMENT '产品id',
    `count` int(11) NULL DEFAULT NULL COMMENT '数量',
    `money` decimal(11, 0) NULL DEFAULT NULL COMMENT '金额',
    `status` int(1) NULL DEFAULT NULL COMMENT '订单状态：0：创建中；1：已完结',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for seata_storage
-- ----------------------------
DROP TABLE IF EXISTS `seata_storage`;
CREATE TABLE `seata_storage`  (
    `id` bigint(11) NOT NULL AUTO_INCREMENT,
    `product_id` bigint(11) NULL DEFAULT NULL COMMENT '产品id',
    `total` int(11) NULL DEFAULT NULL COMMENT '总库存',
    `used` int(11) NULL DEFAULT NULL COMMENT '已用库存',
    `residue` int(11) NULL DEFAULT NULL COMMENT '剩余库存',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seata_storage
-- ----------------------------
INSERT INTO `seata_storage` VALUES (1, 1, 100, 0, 100);

