/*
 Navicat Premium Data Transfer

 Source Server         : git.hatech.com.cn
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : git.hatech.com.cn:33306
 Source Schema         : xincan-transaction-rbac

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 11/03/2020 12:00:21
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
INSERT INTO `menu` VALUES ('1', '系统管理', '/system/manage/area', 'SystemManage', '0', 'guanlizhongxin_icon', '\"{\\\"menu\\\":\\\"系统管理\\\"}\"', 1, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('3', '菜单管理', '/system/manage/menu', 'MenuManage', '1', 'chang_jing_guan_li', '\"{\\\"menu\\\":\\\"菜单管理\\\"}\"', 2, 2, NULL, NULL);
INSERT INTO `menu` VALUES ('4', '用户管理', '/system/manage/user', 'UserManage', '1', 'zu_zhi_yong_hu', '\"{\\\"menu\\\":\\\"用户管理\\\"}\"', 2, 3, NULL, NULL);
INSERT INTO `menu` VALUES ('5', '角色管理', '/system/manage/role', 'RoleManage', '1', 'jiao_se_guan_li', '\"{\\\"menu\\\":\\\"角色管理\\\"}\"', 2, 4, NULL, NULL);
INSERT INTO `menu` VALUES ('7', '预警管理', '/system/warn/warn', 'Warn', '0', 'rongzaizhihui_icon', '\"{\\\"menu\\\":\\\"预警管理\\\"}\"', 1, 2, NULL, NULL);
INSERT INTO `menu` VALUES ('8', '预警编辑', '/system/warn/warn', 'WarnManage', '7', 'chang_jing_guan_li', '\"{\\\"menu\\\":\\\"预警编辑\\\"}\"', 2, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('9', '操作管理', '/system/manage/operation', 'OperationManage', '1', 'gong_dan_guan_li', '\"{\\\"menu\\\":\\\"操作管理\\\"}\"', 2, 3, NULL, NULL);

-- ----------------------------
-- Table structure for menu_operation
-- ----------------------------
DROP TABLE IF EXISTS `menu_operation`;
CREATE TABLE `menu_operation`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源ID',
  `menu_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单ID',
  `operation_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单操作关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_operation
-- ----------------------------
INSERT INTO `menu_operation` VALUES ('10001', '3', '1');
INSERT INTO `menu_operation` VALUES ('10002', '3', '2');
INSERT INTO `menu_operation` VALUES ('10003', '3', '3');
INSERT INTO `menu_operation` VALUES ('10004', '3', '8');
INSERT INTO `menu_operation` VALUES ('10005', '3', '18');
INSERT INTO `menu_operation` VALUES ('30001', '9', '1');
INSERT INTO `menu_operation` VALUES ('30002', '9', '2');
INSERT INTO `menu_operation` VALUES ('30003', '9', '3');
INSERT INTO `menu_operation` VALUES ('30004', '9', '8');
INSERT INTO `menu_operation` VALUES ('61e0ce749abf3975ef34cde3172b101b', '8', '1');
INSERT INTO `menu_operation` VALUES ('69cccbce39a211ea92d80242ac110002', '4', '1');
INSERT INTO `menu_operation` VALUES ('69ccd1b839a211ea92d80242ac110002', '4', '3');
INSERT INTO `menu_operation` VALUES ('69ccd2d639a211ea92d80242ac110002', '4', '2');
INSERT INTO `menu_operation` VALUES ('69ccd4e639a211ea92d80242ac110002', '4', '8');
INSERT INTO `menu_operation` VALUES ('69ccd61039a211ea92d80242ac110002', '4', 'ab7e361c332534b83264a74eb99488ff');
INSERT INTO `menu_operation` VALUES ('69ccd6ed39a211ea92d80242ac110002', '4', '5e3f7211425c7c589501aa5ec20c1e17');
INSERT INTO `menu_operation` VALUES ('69ccd7c539a211ea92d80242ac110002', '4', 'e438fca55f49136ea26f739e46d36a0b');
INSERT INTO `menu_operation` VALUES ('749e5bba39ad11ea92d80242ac110002', '5', '1');
INSERT INTO `menu_operation` VALUES ('749e61f439ad11ea92d80242ac110002', '5', '3');
INSERT INTO `menu_operation` VALUES ('749e630d39ad11ea92d80242ac110002', '5', '2');
INSERT INTO `menu_operation` VALUES ('749e653939ad11ea92d80242ac110002', '5', '8');
INSERT INTO `menu_operation` VALUES ('749e666b39ad11ea92d80242ac110002', '5', 'ab7e361c332534b83264a74eb99488ff');
INSERT INTO `menu_operation` VALUES ('749e676439ad11ea92d80242ac110002', '5', '5e3f7211425c7c589501aa5ec20c1e17');
INSERT INTO `menu_operation` VALUES ('749e682b39ad11ea92d80242ac110002', '5', 'e438fca55f49136ea26f739e46d36a0b');
INSERT INTO `menu_operation` VALUES ('e438fca55f497985a26f739e46d36a0b', '4', 'bfa1ed3b5746b607722f9c2544b7dd2e');
INSERT INTO `menu_operation` VALUES ('ed6c7fdb28fa9e11765fc6cc0ec56b10', '8', '3');

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作ID',
  `operation_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '按钮名称',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '按钮描述',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '按钮编码（用于前端触发按钮调用函数名称）',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '按钮图标',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '按钮类型(view:页面按钮（包括检索条件按钮，表格头部按钮），table:表格右侧操作列按钮)',
  `order_info` smallint(6) NULL DEFAULT NULL COMMENT '按钮顺序',
  `edit_time` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '编辑时间',
  `edit_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '操作按钮' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES ('1', '增加', '增加【表格头部】', 'add', 'add', 'table-header', 1, NULL, NULL);
INSERT INTO `operation` VALUES ('10', '提交', '提交【表格内部】', 'summit', 'fa-home', 'table-inner', 4, '2019-09-06 17:05:38.779680', NULL);
INSERT INTO `operation` VALUES ('11', '撤回', '撤回【表格内部】', 'recall', 'fa-home', 'table-inner', 5, '2019-09-06 17:05:58.533357', NULL);
INSERT INTO `operation` VALUES ('12', '审批', '审批【表格内部】', 'approval', 'fa-home', 'table-inner', 6, '2019-09-06 17:06:14.202359', NULL);
INSERT INTO `operation` VALUES ('13', '变更', '变更【表格内部】', 'modify', 'fa-home', 'table-inner', 7, '2019-09-06 17:06:27.013354', NULL);
INSERT INTO `operation` VALUES ('14', '生成', '生成【表格内部】', 'generate', 'fa-home', 'table-inner', 8, '2019-09-06 17:07:39.000000', NULL);
INSERT INTO `operation` VALUES ('15', '发布', '发布【表格内部】', 'publish', 'fa-home', 'table-inner', 9, '2019-09-06 17:08:27.913720', NULL);
INSERT INTO `operation` VALUES ('16', '启用', '启用【表格内部】', 'start', 'fa-home', 'table-inner', 10, '2019-09-06 17:08:45.092553', NULL);
INSERT INTO `operation` VALUES ('17', '停用', '停用【表格内部】', 'stop', 'fa-home', 'table-inner', 11, '2019-09-06 17:09:02.207449', NULL);
INSERT INTO `operation` VALUES ('18', '配置按钮', '配置按钮【表格内部】', 'setting-button', NULL, 'table-inner', 12, '2020-01-17 02:37:13.894521', NULL);
INSERT INTO `operation` VALUES ('2', '修改', '修改【表格内部】', 'update', 'bianji', 'table-inner', 1, '2019-09-06 12:50:52.968752', NULL);
INSERT INTO `operation` VALUES ('3', '删除', '删除【表格头部】', 'delete', 'shanchu', 'table-header', 2, '2019-09-06 15:38:25.542525', NULL);
INSERT INTO `operation` VALUES ('4', '上传', '上传【表格头部】', 'upload', 'fa-home', 'table-header', 3, '2019-09-06 16:30:17.260917', NULL);
INSERT INTO `operation` VALUES ('5', '下载', '下载【表格头部】', 'download', 'fa-home', 'table-header', 4, '2019-09-06 16:30:39.883451', NULL);
INSERT INTO `operation` VALUES ('5e3f7211425c7c589501aa5ec20c1e17', '编辑', '编辑【左侧树头部】', 'update', 'bianji', 'left-tree-header', 2, '2020-01-18 03:26:10.118506', NULL);
INSERT INTO `operation` VALUES ('6', '导入', '导入【表格头部】', 'import', 'fa-home', 'table-header', 5, '2019-09-06 16:30:56.140745', NULL);
INSERT INTO `operation` VALUES ('7', '导出', '导出【表格头部】', 'export', 'fa-home', 'table-header', 6, '2019-09-06 16:31:15.712456', NULL);
INSERT INTO `operation` VALUES ('8', '查看', '查看【表格内部】', 'detail', 'chakan', 'table-inner', 2, '2019-09-06 17:04:58.966620', NULL);
INSERT INTO `operation` VALUES ('9', '验证', '验证【表格内部】', 'validate', 'fa-home', 'table-inner', 3, NULL, NULL);
INSERT INTO `operation` VALUES ('ab7e361c332534b83264a74eb99488ff', '增加', '增加【左侧树头部】', 'add', 'add', 'left-tree-header', 1, '2020-01-17 02:28:51.048439', NULL);
INSERT INTO `operation` VALUES ('bfa1ed3b5746b607722f9c2544b7dd2e', '重置密码', '重置密码【表格内部】', 'reset-password', 'fa-home', 'table-inner', 13, '2020-01-20 04:28:47.818374', NULL);
INSERT INTO `operation` VALUES ('e438fca55f49136ea26f739e46d36a0b', '删除', '删除【左侧树头部】', 'delete', 'shanchu', 'left-tree-header', 3, '2020-01-18 03:26:37.613307', NULL);

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
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('2befa325f27ca08db3dbf765f002e396', '同创集团', '0', NULL, 1, '机构描述', NULL, NULL);
INSERT INTO `organization` VALUES ('7d6a08887d2c3daec4eb5d09f4a10490', '同创分公司', '2befa325f27ca08db3dbf765f002e396', NULL, 1, '机构描述', NULL, NULL);
INSERT INTO `organization` VALUES ('a053adc5ba416296c536fdc926e81bf1', '1111', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('c8384fcb8c335ad747f4b72fac5dce9c', '222', 'a053adc5ba416296c536fdc926e81bf1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('eeb0fd85b5c39296e497c2cd1dfc3cf2', '分公司1', '7d6a08887d2c3daec4eb5d09f4a10490', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('sw', '分公司', '2befa325f27ca08db3dbf765f002e396', NULL, 1, '机构描述', NULL, NULL);

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
INSERT INTO `role` VALUES ('0f14e4aa4843cf3400c1a314e4d0a227', 'ADMIN', 1, NULL, NULL, NULL);
INSERT INTO `role` VALUES ('111', 'USER', 1, NULL, NULL, NULL);
INSERT INTO `role` VALUES ('9f186f350a5ae1d166f53a27034c5006', '测试角色', 1, '222', NULL, NULL);
INSERT INTO `role` VALUES ('c822d16c4e68f542bfb9fd1d519b20be', 'TENANT_INIT', 1, '租户初始化角色', NULL, NULL);

-- ----------------------------
-- Table structure for role_group
-- ----------------------------
DROP TABLE IF EXISTS `role_group`;
CREATE TABLE `role_group`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组ID',
  `role_group_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组名称',
  `status` smallint(6) NULL DEFAULT NULL COMMENT '是否启用，1为启用，0为暂停',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `edit_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` timestamp(6) NULL DEFAULT NULL COMMENT '编辑时间(时间戳)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_group
-- ----------------------------
INSERT INTO `role_group` VALUES ('222', 'USER组', 1, '用户组', NULL, NULL);
INSERT INTO `role_group` VALUES ('333', 'TENANT组', 1, '租户组', NULL, NULL);
INSERT INTO `role_group` VALUES ('e91d433d7d5a452345de1cc34a4d607e', 'ADMIN组', 1, '超级管理员', NULL, NULL);

-- ----------------------------
-- Table structure for role_group_role
-- ----------------------------
DROP TABLE IF EXISTS `role_group_role`;
CREATE TABLE `role_group_role`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键ID',
  `role_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组ID',
  `role_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_group_role_idx`(`role_group_id`, `role_id`) USING BTREE COMMENT '用户组-角色关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组-角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_group_role
-- ----------------------------
INSERT INTO `role_group_role` VALUES ('1', '222', '111');
INSERT INTO `role_group_role` VALUES ('2', 'e91d433d7d5a452345de1cc34a4d607e', '0f14e4aa4843cf3400c1a314e4d0a227');

-- ----------------------------
-- Table structure for role_group_user
-- ----------------------------
DROP TABLE IF EXISTS `role_group_user`;
CREATE TABLE `role_group_user`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键ID',
  `role_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组ID',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_group_user`(`role_group_id`, `user_id`) USING BTREE COMMENT '用户组-用户关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组-用户关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_group_user
-- ----------------------------
INSERT INTO `role_group_user` VALUES ('dd434830b2d162edd8e1b491a306f8dc', '222', '5');
INSERT INTO `role_group_user` VALUES ('b0c4a2d9d8a6b1cc80431da17a799d08', '222', '6a607af591693660f8c6f3cbffaafcb9');
INSERT INTO `role_group_user` VALUES ('a86071555cd9328b3a2a0385d0efdee7', '222', '9eb7ea07b5bafe28a25b7d08976e1609');
INSERT INTO `role_group_user` VALUES ('b9d7b139d773de5742b8055345911512', '222', 'a511317fafcdd7d3a32bafb8cf5d872d');
INSERT INTO `role_group_user` VALUES ('fe409698e4cdae8a3b8f490ae812f0ff', '222', 'd88b4f12dbad6518f6217ee20575ccb5');
INSERT INTO `role_group_user` VALUES ('0747f7a82333bdd8973049538007321f', '333', '6');
INSERT INTO `role_group_user` VALUES ('0f4391648f0d0f0b3ddd299a8390e906', '333', '9eb7ea07b5bafe28a25b7d08976e1609');
INSERT INTO `role_group_user` VALUES ('537d6c19144b6f70fd369391508f8c60', '333', 'a126fb86046ec9e65467c67b8f8d42bb');
INSERT INTO `role_group_user` VALUES ('362624f867cdad9c97bbb9a6ca9b4797', '333', 'd88b4f12dbad6518f6217ee20575ccb5');
INSERT INTO `role_group_user` VALUES ('a1a40ef062aa3679c5dfba60aaa7b8b7', 'e91d433d7d5a452345de1cc34a4d607e', '20e28261252332628f3fdedc1bc171b2');
INSERT INTO `role_group_user` VALUES ('887da92b0355d734f522bb82ccf01168', 'e91d433d7d5a452345de1cc34a4d607e', '6');

-- ----------------------------
-- Table structure for role_menu_operation
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_operation`;
CREATE TABLE `role_menu_operation`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键ID',
  `role_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  `menu_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单ID',
  `operation_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_menu_id`(`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu_operation
-- ----------------------------
INSERT INTO `role_menu_operation` VALUES ('0304a234d99cd6d6fadfe88ede3ea354', '0f14e4aa4843cf3400c1a314e4d0a227', '3', '1');
INSERT INTO `role_menu_operation` VALUES ('05f35451170444d99f32c5260b3d3de0', '0f14e4aa4843cf3400c1a314e4d0a227', '5', '5e3f7211425c7c589501aa5ec20c1e17');
INSERT INTO `role_menu_operation` VALUES ('0a50fbb62f943efa3c558dbb488aaae5', '0f14e4aa4843cf3400c1a314e4d0a227', '4', '5e3f7211425c7c589501aa5ec20c1e17');
INSERT INTO `role_menu_operation` VALUES ('0b858d6dd0b058b2efe218707614c42d', '0f14e4aa4843cf3400c1a314e4d0a227', '3', '2');
INSERT INTO `role_menu_operation` VALUES ('0d96ef75b3ff0affcef7d8f68e2b7ac5', 'c822d16c4e68f542bfb9fd1d519b20be', '3', '2');
INSERT INTO `role_menu_operation` VALUES ('0edfc12d2a536c5d7fb16266202ab610', '111', '4', NULL);
INSERT INTO `role_menu_operation` VALUES ('0fb39a10ec637be127491601f9625bcc', '0f14e4aa4843cf3400c1a314e4d0a227', '5', '1');
INSERT INTO `role_menu_operation` VALUES ('12674d4b95ed4c69e079108fe05de8ac', 'c822d16c4e68f542bfb9fd1d519b20be', '4', 'ab7e361c332534b83264a74eb99488ff');
INSERT INTO `role_menu_operation` VALUES ('14d6eb651779ac5ed1b47c987221d10e', '0f14e4aa4843cf3400c1a314e4d0a227', '4', '1');
INSERT INTO `role_menu_operation` VALUES ('1842b400de0728cc4f8fcd417e6c41b4', '111', '9', '1');
INSERT INTO `role_menu_operation` VALUES ('18816ae20ea1dcb01d96fdb9f9b6e011', '111', '4', '3');
INSERT INTO `role_menu_operation` VALUES ('1f02ad165d349d071b6c31b2cb1cec4e', '0f14e4aa4843cf3400c1a314e4d0a227', '4', 'ab7e361c332534b83264a74eb99488ff');
INSERT INTO `role_menu_operation` VALUES ('1f35ce890e311e13d3d6ec4c3608e461', 'c822d16c4e68f542bfb9fd1d519b20be', '5', '1');
INSERT INTO `role_menu_operation` VALUES ('20e47a4010cf27765c3aeaf9ed7d55ea', 'c822d16c4e68f542bfb9fd1d519b20be', '3', '1');
INSERT INTO `role_menu_operation` VALUES ('227bbfe2063291e4a97fe0e874bf162e', 'c822d16c4e68f542bfb9fd1d519b20be', '9', NULL);
INSERT INTO `role_menu_operation` VALUES ('22ab827becc086b525eac55ac65b2236', 'c822d16c4e68f542bfb9fd1d519b20be', '9', '3');
INSERT INTO `role_menu_operation` VALUES ('264287913b72d74644a8948feab8f4dc', 'c822d16c4e68f542bfb9fd1d519b20be', '4', '3');
INSERT INTO `role_menu_operation` VALUES ('277f961c0f3f3f73a91ae6178ceeebf5', '0f14e4aa4843cf3400c1a314e4d0a227', '4', '8');
INSERT INTO `role_menu_operation` VALUES ('2a764edacb1132324238b437d53e2ba6', '0f14e4aa4843cf3400c1a314e4d0a227', '5', '8');
INSERT INTO `role_menu_operation` VALUES ('2a8ec2f232eb34dd3f751f0c793051e8', '111', '5', '1');
INSERT INTO `role_menu_operation` VALUES ('2ccbec4eb538688b33ece29f7b32496f', 'c822d16c4e68f542bfb9fd1d519b20be', '4', 'bfa1ed3b5746b607722f9c2544b7dd2e');
INSERT INTO `role_menu_operation` VALUES ('2cf56c3189c599e46b542ea8bdffb942', 'c822d16c4e68f542bfb9fd1d519b20be', '5', '8');
INSERT INTO `role_menu_operation` VALUES ('2e0fcd97f020bc1a0adb55085f96210d', '111', '9', '3');
INSERT INTO `role_menu_operation` VALUES ('37451dcecaf45210f91899f648acec20', '111', '3', '18');
INSERT INTO `role_menu_operation` VALUES ('3945e178c87f7aa1467b29b69a5da469', '0f14e4aa4843cf3400c1a314e4d0a227', '5', 'ab7e361c332534b83264a74eb99488ff');
INSERT INTO `role_menu_operation` VALUES ('399bcc6d58d52a47b9572369a4008238', '111', '4', '1');
INSERT INTO `role_menu_operation` VALUES ('3c0c64d4610286bcab6ba4237b965425', '0f14e4aa4843cf3400c1a314e4d0a227', '7', NULL);
INSERT INTO `role_menu_operation` VALUES ('3c3b60464adca55b0045e455d5ff9b37', '0f14e4aa4843cf3400c1a314e4d0a227', '3', '8');
INSERT INTO `role_menu_operation` VALUES ('3e315fc28ce8ffd1133db92b3238421b', 'c822d16c4e68f542bfb9fd1d519b20be', '9', '8');
INSERT INTO `role_menu_operation` VALUES ('3e82ce46cc52b4dcaca8fe8b14b27981', '111', '9', NULL);
INSERT INTO `role_menu_operation` VALUES ('406336474b135d97fed6bfc6a746f39c', '111', '9', '8');
INSERT INTO `role_menu_operation` VALUES ('417820485de23c2c4efe87290b812ab2', '0f14e4aa4843cf3400c1a314e4d0a227', '5', '3');
INSERT INTO `role_menu_operation` VALUES ('43984d0145c76c0f38b223de2e8c0a6b', '0f14e4aa4843cf3400c1a314e4d0a227', '5', 'e438fca55f49136ea26f739e46d36a0b');
INSERT INTO `role_menu_operation` VALUES ('4658493c7c38bb6dcce0029305b4ec00', '0f14e4aa4843cf3400c1a314e4d0a227', '8', NULL);
INSERT INTO `role_menu_operation` VALUES ('4c7a4ae2d3f721308957461428aeda0e', '111', '4', '5e3f7211425c7c589501aa5ec20c1e17');
INSERT INTO `role_menu_operation` VALUES ('4fa063f752c19e36529ff1f98f6614f0', 'c822d16c4e68f542bfb9fd1d519b20be', '3', NULL);
INSERT INTO `role_menu_operation` VALUES ('4fc87853a1fc68d4c43a6638308b86cd', 'c822d16c4e68f542bfb9fd1d519b20be', '9', '1');
INSERT INTO `role_menu_operation` VALUES ('51d951a7d855ed2ac2554d1d037a332f', '111', '9', '2');
INSERT INTO `role_menu_operation` VALUES ('52f88fc9e572e2e8ba54b794232ec85b', '111', '3', '8');
INSERT INTO `role_menu_operation` VALUES ('552bc8580f406d7ca115f5a4f0d6b866', '111', '3', '2');
INSERT INTO `role_menu_operation` VALUES ('5ab1f86ae4ec5b0e5c01e3d1b73b9d7d', '0f14e4aa4843cf3400c1a314e4d0a227', '4', '3');
INSERT INTO `role_menu_operation` VALUES ('61fff5df88531840d5c22977a6bba67d', '0f14e4aa4843cf3400c1a314e4d0a227', '1', NULL);
INSERT INTO `role_menu_operation` VALUES ('6356d9901bc907936fad6016f89fb0ba', 'c822d16c4e68f542bfb9fd1d519b20be', '5', '2');
INSERT INTO `role_menu_operation` VALUES ('6470caf86397f69809da9316342dd814', '0f14e4aa4843cf3400c1a314e4d0a227', '4', NULL);
INSERT INTO `role_menu_operation` VALUES ('71e4803d942a0cfeaea36a8096aa8bca', '111', '1', NULL);
INSERT INTO `role_menu_operation` VALUES ('72abdbdb9d9ecc3382c05fa68b9c5c4f', '111', '3', '1');
INSERT INTO `role_menu_operation` VALUES ('77c3527c71a710968c7b6fe9a3ce9dcd', 'c822d16c4e68f542bfb9fd1d519b20be', '4', '1');
INSERT INTO `role_menu_operation` VALUES ('78bfc163df170bfee7ab02cafa2a44ef', '111', '5', NULL);
INSERT INTO `role_menu_operation` VALUES ('7937f2b813bbed89d1e96964edb82261', 'c822d16c4e68f542bfb9fd1d519b20be', '9', '2');
INSERT INTO `role_menu_operation` VALUES ('869b9e340c5f0a10e48b23d0913d3f8e', '0f14e4aa4843cf3400c1a314e4d0a227', '8', '1');
INSERT INTO `role_menu_operation` VALUES ('86d1f211976c5f35f41570dd22aad450', '111', '5', '2');
INSERT INTO `role_menu_operation` VALUES ('88065ef761884fae67c9947f5f7d9440', '0f14e4aa4843cf3400c1a314e4d0a227', '4', 'bfa1ed3b5746b607722f9c2544b7dd2e');
INSERT INTO `role_menu_operation` VALUES ('8fe7c0fc93e4b692d6f2e8ae4e353af9', '0f14e4aa4843cf3400c1a314e4d0a227', '9', '1');
INSERT INTO `role_menu_operation` VALUES ('92c45d81a09a04fe376856f66ffa407d', '111', '4', 'ab7e361c332534b83264a74eb99488ff');
INSERT INTO `role_menu_operation` VALUES ('97043082aa2a0c9b9a72e62e9a37e0e5', '111', '3', NULL);
INSERT INTO `role_menu_operation` VALUES ('9976ba1a03254f37747dd9f70a415ae8', '111', '5', 'ab7e361c332534b83264a74eb99488ff');
INSERT INTO `role_menu_operation` VALUES ('9d50736f4ba7ec463c6c2f52c8e1c6cd', '0f14e4aa4843cf3400c1a314e4d0a227', '3', NULL);
INSERT INTO `role_menu_operation` VALUES ('a059c6a8aef21c1203254cc906b996be', '0f14e4aa4843cf3400c1a314e4d0a227', '9', '2');
INSERT INTO `role_menu_operation` VALUES ('a14b1ec340f56dd2951e0d2792f2e1e4', 'c822d16c4e68f542bfb9fd1d519b20be', '5', '5e3f7211425c7c589501aa5ec20c1e17');
INSERT INTO `role_menu_operation` VALUES ('a46ccc5a76f0d309b38b79f3132e9afa', '0f14e4aa4843cf3400c1a314e4d0a227', '4', 'e438fca55f49136ea26f739e46d36a0b');
INSERT INTO `role_menu_operation` VALUES ('a77473407c98fc0209e937ef3c7c67c2', 'c822d16c4e68f542bfb9fd1d519b20be', '4', NULL);
INSERT INTO `role_menu_operation` VALUES ('a7fcb94ee396c175ae00262d4c8851a9', 'c822d16c4e68f542bfb9fd1d519b20be', '3', '8');
INSERT INTO `role_menu_operation` VALUES ('ac9afd06208e8d7a03638fe599193532', '0f14e4aa4843cf3400c1a314e4d0a227', '5', '2');
INSERT INTO `role_menu_operation` VALUES ('b04708a68ed0221062caef8abfef064f', '111', '4', 'e438fca55f49136ea26f739e46d36a0b');
INSERT INTO `role_menu_operation` VALUES ('b4067b1692dee89fec9abc0914a769b5', 'c822d16c4e68f542bfb9fd1d519b20be', '5', NULL);
INSERT INTO `role_menu_operation` VALUES ('b4bddc5bc28e2afccd1b4d7e0dda9357', 'c822d16c4e68f542bfb9fd1d519b20be', '3', '3');
INSERT INTO `role_menu_operation` VALUES ('b9695e54a9b123262199afa54723e5fa', '111', '5', '5e3f7211425c7c589501aa5ec20c1e17');
INSERT INTO `role_menu_operation` VALUES ('b9de3881fbc19df85bd9c148f42c5ecb', 'c822d16c4e68f542bfb9fd1d519b20be', '3', '18');
INSERT INTO `role_menu_operation` VALUES ('bf1b84dcec96736cdca9f8171eb2cdaa', '0f14e4aa4843cf3400c1a314e4d0a227', '9', NULL);
INSERT INTO `role_menu_operation` VALUES ('c3b5404702ff24e56a19a35b6d5e41cd', '0f14e4aa4843cf3400c1a314e4d0a227', '5', NULL);
INSERT INTO `role_menu_operation` VALUES ('c5e319ceac62eb1923fd51d93f78cb22', '0f14e4aa4843cf3400c1a314e4d0a227', '8', '3');
INSERT INTO `role_menu_operation` VALUES ('cb89474eb059975eea668cce191699e2', 'c822d16c4e68f542bfb9fd1d519b20be', '1', NULL);
INSERT INTO `role_menu_operation` VALUES ('cd55b0ade7e36dafea9158f09d4b866c', '111', '3', '3');
INSERT INTO `role_menu_operation` VALUES ('d3d2139ae638c10a44a36cf48e63d735', 'c822d16c4e68f542bfb9fd1d519b20be', '4', 'e438fca55f49136ea26f739e46d36a0b');
INSERT INTO `role_menu_operation` VALUES ('dc06954d53c266f0b97ba4b70db3ae21', '0f14e4aa4843cf3400c1a314e4d0a227', '4', '2');
INSERT INTO `role_menu_operation` VALUES ('df63deb973a7574928906ef60d72e86c', '111', '4', '8');
INSERT INTO `role_menu_operation` VALUES ('df7ce666ee9fcf8135c455682fedb3a7', '0f14e4aa4843cf3400c1a314e4d0a227', '9', '3');
INSERT INTO `role_menu_operation` VALUES ('e4ed04ef974e8a15e896d36be4ad752d', '111', '5', '3');
INSERT INTO `role_menu_operation` VALUES ('e73a54f71026cb2a0976d9aa7f4cbda9', 'c822d16c4e68f542bfb9fd1d519b20be', '4', '5e3f7211425c7c589501aa5ec20c1e17');
INSERT INTO `role_menu_operation` VALUES ('e89e2d3f1f43d5c46184c90ca4fd3eeb', '0f14e4aa4843cf3400c1a314e4d0a227', '3', '18');
INSERT INTO `role_menu_operation` VALUES ('f36e215a06bc01f312a07361bc36ab91', 'c822d16c4e68f542bfb9fd1d519b20be', '4', '8');
INSERT INTO `role_menu_operation` VALUES ('f46084fcf5331735128915b9ec45fd55', '111', '4', 'bfa1ed3b5746b607722f9c2544b7dd2e');
INSERT INTO `role_menu_operation` VALUES ('f5ad8b52f9a4c2452998e441e4cdb1d1', 'c822d16c4e68f542bfb9fd1d519b20be', '4', '2');
INSERT INTO `role_menu_operation` VALUES ('f7bfed9bc169b31b1cee8f2c26ddd1cf', 'c822d16c4e68f542bfb9fd1d519b20be', '5', '3');
INSERT INTO `role_menu_operation` VALUES ('f7c6334c3bbd4027b0f75d5ee38eee2f', '0f14e4aa4843cf3400c1a314e4d0a227', '9', '8');
INSERT INTO `role_menu_operation` VALUES ('f942c513125f16bb1fc8bce5564ed09e', '111', '5', '8');
INSERT INTO `role_menu_operation` VALUES ('faf2c75499f4f4ac1eccbb7ed64de250', '111', '5', 'e438fca55f49136ea26f739e46d36a0b');
INSERT INTO `role_menu_operation` VALUES ('fb5948356ab4080c4c4118e3b01235df', '0f14e4aa4843cf3400c1a314e4d0a227', '3', '3');
INSERT INTO `role_menu_operation` VALUES ('fbf28f55e133e30d76249798750e1530', '111', '4', '2');
INSERT INTO `role_menu_operation` VALUES ('fc8bf136102c63fd8b205e6ae233eac3', 'c822d16c4e68f542bfb9fd1d519b20be', '5', 'ab7e361c332534b83264a74eb99488ff');
INSERT INTO `role_menu_operation` VALUES ('ff4a309d09eac069be9efa712181afee', 'c822d16c4e68f542bfb9fd1d519b20be', '5', 'e438fca55f49136ea26f739e46d36a0b');

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
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seata_log
-- ----------------------------
INSERT INTO `seata_log` VALUES (38, 2031738262, '192.168.1.186:8091:2031738260', 'serializer=jackson', 0x7B7D, 1, '2020-01-17 11:04:28', '2020-01-17 11:04:28', NULL);
INSERT INTO `seata_log` VALUES (45, 2031738271, '192.168.1.186:8091:2031738269', 'serializer=jackson', 0x7B7D, 1, '2020-01-18 02:36:00', '2020-01-18 02:36:00', NULL);
INSERT INTO `seata_log` VALUES (47, 2031738274, '192.168.1.186:8091:2031738272', 'serializer=jackson', 0x7B7D, 1, '2020-01-18 02:52:11', '2020-01-18 02:52:11', NULL);
INSERT INTO `seata_log` VALUES (49, 2031738277, '192.168.1.186:8091:2031738275', 'serializer=jackson', 0x7B7D, 1, '2020-01-18 02:56:07', '2020-01-18 02:56:07', NULL);
INSERT INTO `seata_log` VALUES (51, 2031738280, '192.168.1.186:8091:2031738278', 'serializer=jackson', 0x7B7D, 1, '2020-01-18 03:05:08', '2020-01-18 03:05:08', NULL);
INSERT INTO `seata_log` VALUES (53, 2031738283, '192.168.1.186:8091:2031738281', 'serializer=jackson', 0x7B7D, 1, '2020-01-18 03:05:32', '2020-01-18 03:05:32', NULL);
INSERT INTO `seata_log` VALUES (55, 2031738286, '192.168.1.186:8091:2031738284', 'serializer=jackson', 0x7B7D, 1, '2020-01-18 03:05:38', '2020-01-18 03:05:38', NULL);

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
INSERT INTO `user` VALUES ('6', '11@qq.com', '$2a$10$fT2GdLmNDqbgxeyEkLyDW.14V4DNXGwTd7d2D4OdaZdKJuMkI0NbW', '11', '13333333333', '11@qq.com', 1, 1, 0, 'UUID', NULL, 'UUID', '7d6a08887d2c3daec4eb5d09f4a10490', '6', '2020-01-17 14:28:38.000000');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_role_idx`(`user_id`, `role_id`) USING BTREE COMMENT '用户-角色关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户-角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('abfcccd1227571b6efa42978c230e20f', '1c8caf1e53e17180478d6c7801252a18', '9f186f350a5ae1d166f53a27034c5006');
INSERT INTO `user_role` VALUES ('495afc9ea801d7f6c4396ba4007cd075', '20e28261252332628f3fdedc1bc171b2', '111');
INSERT INTO `user_role` VALUES ('9f4b3df9498ace4be19c7ff1ded5c40b', '6', '0f14e4aa4843cf3400c1a314e4d0a227');
INSERT INTO `user_role` VALUES ('93f10e8ab5cb587df64721a89f17dce5', '6', '111');
INSERT INTO `user_role` VALUES ('46bbf3e4c201ea7db6edf65a87fbc1a8', '6a607af591693660f8c6f3cbffaafcb9', '0f14e4aa4843cf3400c1a314e4d0a227');
INSERT INTO `user_role` VALUES ('0058d3a552ea7140bf26e15d24c62b4c', '6a607af591693660f8c6f3cbffaafcb9', '111');
INSERT INTO `user_role` VALUES ('5b8018b0c3ecaeacf80f40ca2401a21d', '6c06d6abd5318234c1d913e1c12366d7', '9f186f350a5ae1d166f53a27034c5006');
INSERT INTO `user_role` VALUES ('13ce8588a4047cbe6d067802aceddbf3', '8e8b02cf0c2ebb3b4c49157d1f27e3d0', '111');
INSERT INTO `user_role` VALUES ('0f167bd5d9eba3ac2925a943448a0594', '98051471d4339499d64478799d23d4fb', '111');
INSERT INTO `user_role` VALUES ('21cae60b32c51bc05fbdd59bdac85a4b', '99e421b5af2c0295a94caba212bb7272', '9f186f350a5ae1d166f53a27034c5006');
INSERT INTO `user_role` VALUES ('c214a3e07f6fd7eedb8f71a6c5dc2b08', '9eb7ea07b5bafe28a25b7d08976e1609', '111');
INSERT INTO `user_role` VALUES ('ad7aed743135936e512a886415d345bd', 'a511317fafcdd7d3a32bafb8cf5d872d', '111');
INSERT INTO `user_role` VALUES ('634a4735266e75e637a88497314159fd', 'a511317fafcdd7d3a32bafb8cf5d872d', '9f186f350a5ae1d166f53a27034c5006');
INSERT INTO `user_role` VALUES ('077544dcf7b32279269ced6ec62bab7a', 'bafdd4c94145150288f5415b351b23df', '111');
INSERT INTO `user_role` VALUES ('f5613df1299ea4e0cf2c625549781d95', 'd88b4f12dbad6518f6217ee20575ccb5', '111');

-- ----------------------------
-- View structure for role_view
-- ----------------------------
DROP VIEW IF EXISTS `role_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `role_view` AS select `t1`.`id` AS `id`,`t1`.`role_name` AS `name`,`t1`.`status` AS `status`,`t2`.`role_group_id` AS `parent_id` from (`role` `t1` left join `role_group_role` `t2` on((`t1`.`id` = `t2`.`role_id`))) union all select `role_group`.`id` AS `id`,`role_group`.`role_group_name` AS `name`,`role_group`.`status` AS `status`,'0' AS `parent_id` from `role_group`;

-- ----------------------------
-- View structure for user_role_view
-- ----------------------------
DROP VIEW IF EXISTS `user_role_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_role_view` AS select `t1`.`id` AS `id`,`t1`.`username` AS `username`,`t1`.`password` AS `password`,`t1`.`name` AS `name`,`t1`.`phone` AS `phone`,`t1`.`email` AS `email`,`t1`.`is_admin` AS `is_admin`,`t1`.`status` AS `status`,`t1`.`is_tenant` AS `is_tenant`,`t1`.`organization_id` AS `organization_id`,`t1`.`organization_name` AS `organization_name`,`t2`.`role_id` AS `role_id`,`t4`.`name` AS `role_name`,`t4`.`status` AS `role_status`,`t3`.`role_group_id` AS `role_group_id`,`t5`.`name` AS `role_group_name`,`t5`.`status` AS `role_group_status`,`t1`.`edit_time` AS `edit_time` from ((((`user_view` `t1` left join `user_role` `t2` on((`t1`.`id` = `t2`.`user_id`))) left join `role_group_user` `t3` on((`t1`.`id` = `t3`.`user_id`))) left join `role_view` `t4` on((`t2`.`role_id` = `t4`.`id`))) left join `role_view` `t5` on((`t3`.`role_group_id` = `t5`.`id`)));

-- ----------------------------
-- View structure for user_view
-- ----------------------------
DROP VIEW IF EXISTS `user_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_view` AS select `t1`.`id` AS `id`,`t1`.`username` AS `username`,`t1`.`password` AS `password`,`t1`.`name` AS `name`,`t1`.`phone` AS `phone`,`t1`.`email` AS `email`,`t1`.`is_admin` AS `is_admin`,`t1`.`status` AS `status`,`t1`.`is_tenant` AS `is_tenant`,`t1`.`organization_id` AS `organization_id`,`t2`.`name` AS `organization_name`,`t1`.`edit_time` AS `edit_time` from (`user` `t1` left join `organization` `t2` on((`t1`.`organization_id` = `t2`.`id`)));

-- ----------------------------
-- Function structure for getOrgCList
-- ----------------------------
DROP FUNCTION IF EXISTS `getOrgCList`;
delimiter ;;
CREATE FUNCTION `getOrgCList`(rootId VARCHAR(64))
 RETURNS varchar(4000) CHARSET utf8mb4
BEGIN 

-- 根据当前id查询所有下级子节点，包含当前节点
-- （向下查询） 
-- 操作方式
-- select * From area where FIND_IN_SET(id, getOrgCList('5c8131f4883e11e8b73168f7285847c8'));
	DECLARE sChildList VARCHAR(4000);
	DECLARE sChildTemp VARCHAR(4000);
	SET sChildTemp =cast(rootId as CHAR);
	WHILE sChildTemp is not null DO
		IF (sChildList is not null) THEN
			SET sChildList = concat(sChildList,',',sChildTemp);
		ELSE
			SET sChildList = concat(sChildTemp);
		END IF;
				SELECT group_concat(id) INTO sChildTemp FROM organization where FIND_IN_SET(parent_id,sChildTemp)>0;
	END WHILE;
	RETURN sChildList;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
