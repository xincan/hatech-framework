/*
 Navicat Premium Data Transfer

 Source Server         : git.hatech.com.cn
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : git.hatech.com.cn:33306
 Source Schema         : xincan-transaction-system

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 11/03/2020 12:00:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `code` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单编码',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单类型 menu   url   button',
  `parent_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '父级菜单ID',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `params` json NULL COMMENT '路由参数',
  `level` int(11) NULL DEFAULT NULL COMMENT '菜单级别',
  `order_info` int(11) NULL DEFAULT NULL COMMENT '菜单顺序',
  `edit_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` timestamp(6) NULL DEFAULT NULL COMMENT '编辑时间(时间戳)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', NULL, NULL, NULL, '-1', 'fa-home', '\"{\\\"menu\\\":\\\"系统管理\\\"}\"', 1, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('13', '操作管理', '/views/system/manage/OperationManage', NULL, NULL, '1', 'fa-home', '\"{\\\"menu\\\":\\\"操作管理\\\"}\"', 2, 6, NULL, NULL);
INSERT INTO `menu` VALUES ('2', '地区管理', '/views/system/manage/AreaManage', NULL, NULL, '1', 'fa-globe', '\"{\\\"menu\\\":\\\"地区管理\\\"}\"', 2, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('3', '菜单管理', '/views/system/manage/MenuManage', NULL, NULL, '1', 'fa-bars', '\"{\\\"menu\\\":\\\"菜单管理\\\"}\"', 2, 2, NULL, NULL);
INSERT INTO `menu` VALUES ('4', '用户管理', '/views/system/manage/UserManage', NULL, NULL, '1', 'fa-user-o', '\"{\\\"menu\\\":\\\"用户管理\\\"}\"', 2, 3, NULL, NULL);
INSERT INTO `menu` VALUES ('5', '角色管理', '/views/system/manage/RoleManage', NULL, NULL, '1', 'fa-user-md', '\"{\\\"menu\\\":\\\"角色管理\\\"}\"', 2, 4, NULL, NULL);
INSERT INTO `menu` VALUES ('6', '权限管理', '/views/system/manage/PermissionManage', NULL, NULL, '1', 'fa-home', '\"{\\\"menu\\\":\\\"权限管理\\\"}\"', 2, 5, NULL, NULL);
INSERT INTO `menu` VALUES ('67beafd9d23e575bbedb1d04ebbf7f46', '123456', '/user/list', NULL, NULL, '0', 'home', NULL, 1, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('7', '预警管理', NULL, NULL, NULL, '-1', 'fa-home', '\"{\\\"menu\\\":\\\"预警管理\\\"}\"', 1, 2, NULL, NULL);
INSERT INTO `menu` VALUES ('712e3ebf6d4d8a12c4f8c5d0161cfe9f', '123456', '/user/list', NULL, NULL, '0', 'home', NULL, 1, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('8', '预警编辑', '/views/system/warn/WarnManage', NULL, NULL, '7', 'fa-globe', '\"{\\\"menu\\\":\\\"预警编辑\\\"}\"', 2, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('9', '预案管理', '/views/system/manage/PlanManage', NULL, NULL, '-1', 'fa-home', '\"{\\\"menu\\\":\\\"预案管理\\\"}\"', 1, 3, NULL, NULL);
INSERT INTO `menu` VALUES ('fad7606f211066fa505a99bb78ffa24e', '用户列表查询', '/user/list', NULL, NULL, '0', 'home', '[]', 1, 1, NULL, NULL);

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '机构ID',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '机构名称',
  `parent_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '父级机构ID',
  `status` smallint(6) NULL DEFAULT NULL COMMENT '是否启用，1为启用，0为暂停',
  `order_info` int(11) NULL DEFAULT NULL COMMENT '机构顺序',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '机构描述',
  `edit_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` timestamp(0) NULL DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `status` smallint(255) NULL DEFAULT NULL COMMENT '是否启用，1为启用，0为暂停',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `edit_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` timestamp(6) NULL DEFAULT NULL COMMENT '编辑时间(时间戳)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0f14e4aa4843cf3400c1a314e4d0a227', 'ADMIN', NULL, NULL, NULL, '2019-12-25 05:04:22.000000');
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', NULL, NULL, NULL, '2019-12-25 12:29:39.000000');
INSERT INTO `role` VALUES ('2', 'ROLE_DEVLOP', NULL, NULL, NULL, '2019-12-25 09:29:42.000000');
INSERT INTO `role` VALUES ('3', 'ROLE_TENANT', NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES ('4', 'ROLE_USER', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role_group
-- ----------------------------
DROP TABLE IF EXISTS `role_group`;
CREATE TABLE `role_group`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组ID',
  `role_group_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组名称',
  `edit_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` timestamp(6) NULL DEFAULT NULL COMMENT '编辑时间(时间戳)',
  `status` smallint(6) NULL DEFAULT NULL COMMENT '是否启用，1为启用，0为暂停',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_group_role
-- ----------------------------
DROP TABLE IF EXISTS `role_group_role`;
CREATE TABLE `role_group_role`  (
  `role_group_id` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组ID',
  `role_id` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  UNIQUE INDEX `user_group_role_idx`(`role_group_id`, `role_id`) USING BTREE COMMENT '用户组-角色关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组-角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_group_user
-- ----------------------------
DROP TABLE IF EXISTS `role_group_user`;
CREATE TABLE `role_group_user`  (
  `role_group_id` decimal(6, 0) NOT NULL COMMENT '角色组ID',
  `user_id` decimal(6, 0) NOT NULL COMMENT '用户ID',
  UNIQUE INDEX `user_group_user`(`role_group_id`, `user_id`) USING BTREE COMMENT '用户组-用户关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组-用户关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `menu_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  INDEX `role_menu_id`(`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seata_log
-- ----------------------------
DROP TABLE IF EXISTS `seata_log`;
CREATE TABLE `seata_log`  (
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
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户登录名称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户登录密码',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `is_admin` smallint(6) NULL DEFAULT NULL COMMENT '是否是管理员',
  `status` smallint(6) NULL DEFAULT NULL COMMENT '是否启用，1为启用，0为暂停',
  `is_tenant` smallint(6) NULL DEFAULT NULL COMMENT '是否是租户',
  `company` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公司名称',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '企业统一码',
  `area_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '关联地区ID',
  `organization_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '关联机构ID',
  `edit_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` timestamp(6) NULL DEFAULT NULL COMMENT '编辑时间(时间戳)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('039189f89fc29c17b755c56f125c08aa', '11@qq.com', '$2a$10$aS.REGmEhFRrCoiAZDlMVOBABIB95yYXlVIwv5kZ8X0XR9g3edBqO', '张三', '17088888888', '11@qq.com', 0, 23, 1, 'UUID', NULL, 'UUID', 'UUID', NULL, '2019-12-23 04:11:46.000000');
INSERT INTO `user` VALUES ('1', 'www@ads.com', '$2a$10$FpLVasRp9DWHsVvaSfjqWO/yX.15iFi1PnXXUW3Si2mMJbTVC91nm', '', '111', 'www@ads.com', 0, 23, 1, 'UUID', NULL, 'UUID', '123', NULL, NULL);
INSERT INTO `user` VALUES ('2', 'asdf1@ads.com', '$2a$10$FpLVasRp9DWHsVvaSfjqWO/yX.15iFi1PnXXUW3Si2mMJbTVC91nm', '', '111', 'asdf1@ads.com', 0, 24, 1, 'UUID', NULL, 'UUID', '123', NULL, NULL);
INSERT INTO `user` VALUES ('3', 'asdf2@ads.com', '$2a$10$FpLVasRp9DWHsVvaSfjqWO/yX.15iFi1PnXXUW3Si2mMJbTVC91nm', '', '111', 'asdf2@ads.com', 0, 25, 1, 'UUID', NULL, 'UUID', '123', NULL, NULL);
INSERT INTO `user` VALUES ('4', 'asdf3@ads.com', '$2a$10$FpLVasRp9DWHsVvaSfjqWO/yX.15iFi1PnXXUW3Si2mMJbTVC91nm', '', '111', 'asdf3@ads.com', 1, 26, 0, 'UUID', NULL, 'UUID', '123', NULL, NULL);
INSERT INTO `user` VALUES ('5', 'asdf4@ads.com', '$2a$10$FpLVasRp9DWHsVvaSfjqWO/yX.15iFi1PnXXUW3Si2mMJbTVC91nm', '', '111', 'asdf4@ads.com', 1, 27, 0, 'UUID', NULL, 'UUID', '123', NULL, NULL);
INSERT INTO `user` VALUES ('b63ad3cce8720b83f7ce1e80a375c132', '12@qq.com', '$2a$10$Yfmvl6te9fhURZozS6dCD.MCxLA/jXizTHiYx9Cyz1ODRbnfrJVaK', '张三', '17088888888', '12@qq.com', 0, 23, 1, 'UUID', NULL, 'UUID', 'UUID', NULL, NULL);
INSERT INTO `user` VALUES ('cf270ff3197f06f6c927bbd5039e9040', '13@qq.com', '$2a$10$QyspmVxAletR50KuQzK9iOPb11c7Ax2KKb7wFEv6JUK7ulMjP0rsq', '张三', '17088888888', '13@qq.com', 0, 20, 1, 'UUID', NULL, 'UUID', 'UUID', NULL, '2019-12-23 04:10:55.000000');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  UNIQUE INDEX `user_role_idx`(`user_id`, `role_id`) USING BTREE COMMENT '用户-角色关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户-角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('1', '2');
INSERT INTO `user_role` VALUES ('1', '3');
INSERT INTO `user_role` VALUES ('2', '3');
INSERT INTO `user_role` VALUES ('b63ad3cce8720b83f7ce1e80a375c132', 'UUID');

SET FOREIGN_KEY_CHECKS = 1;
