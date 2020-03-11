/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : hatech-transaction

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 27/02/2020 17:14:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for data_permission
-- ----------------------------
DROP TABLE IF EXISTS `data_permission`;
CREATE TABLE `data_permission`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `data_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '表名',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户id',
  `operation_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for data_table
-- ----------------------------
DROP TABLE IF EXISTS `data_table`;
CREATE TABLE `data_table`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data_table
-- ----------------------------
INSERT INTO `data_table` VALUES ('1', 'row1');
INSERT INTO `data_table` VALUES ('2', 'row2');

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
INSERT INTO `menu` VALUES ('b4db1ccb465211eab7f60a0027000011', '系统管理', '/system/manage/user', 'SystemManage', '0', 'guanlizhongxin_icon', '\"{\\\"menu\\\":\\\"系统管理\\\"}\"', 1, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('b4db1d2e465211eab7f60a0027000011', '菜单管理', '/system/manage/menu', 'MenuManage', 'b4db1ccb465211eab7f60a0027000011', 'chang_jing_guan_li', '\"{\\\"menu\\\":\\\"菜单管理\\\"}\"', 2, 2, NULL, NULL);
INSERT INTO `menu` VALUES ('b4db1d44465211eab7f60a0027000011', '用户管理', '/system/manage/user', 'UserManage', 'b4db1ccb465211eab7f60a0027000011', 'zu_zhi_yong_hu', '\"{\\\"menu\\\":\\\"用户管理\\\"}\"', 2, 3, NULL, NULL);
INSERT INTO `menu` VALUES ('b4db1d54465211eab7f60a0027000011', '角色管理', '/system/manage/role', 'RoleManage', 'b4db1ccb465211eab7f60a0027000011', 'jiao_se_guan_li', '\"{\\\"menu\\\":\\\"角色管理\\\"}\"', 2, 4, NULL, NULL);
INSERT INTO `menu` VALUES ('b4db1d7b465211eab7f60a0027000011', '预警管理', '/system/warn/warn', 'Warn', '0', 'rongzaizhihui_icon', '\"{\\\"menu\\\":\\\"预警管理\\\"}\"', 1, 2, NULL, NULL);
INSERT INTO `menu` VALUES ('b4db1d88465211eab7f60a0027000011', '预警编辑', '/system/warn/warn', 'WarnManage', 'b4db1d7b465211eab7f60a0027000011', 'chang_jing_guan_li', '\"{\\\"menu\\\":\\\"预警编辑\\\"}\"', 2, 1, NULL, NULL);
INSERT INTO `menu` VALUES ('b4db1d93465211eab7f60a0027000011', '操作管理', '/system/manage/operation', 'OperationManage', 'b4db1ccb465211eab7f60a0027000011', 'gong_dan_guan_li', '\"{\\\"menu\\\":\\\"操作管理\\\"}\"', 2, 3, NULL, NULL);

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
INSERT INTO `menu_operation` VALUES ('063f44964c5d89554a5d83f3eda9a859', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('06622ff6676f7c9403cf15eac7864f24', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('07f13649f48da3fe573af903378a3ed6', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('0a0c8a8e048ad21978d205e029f48472', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('2a298002739481415bc363d60b7ba039', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('340a9a7184066d5e88f25acd4c8243fd', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('3af5ab977d6dda0b63a0307151da16b8', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('3fb3602f7e0e2983456de5cd4a732303', 'b4db1d2e465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('49cfe29ba19873bc7251c62fb3d958a6', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('4edc64f46b5539b67b12be236b533614', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('52e84eed15eaa2498ade9f51be14010e', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('5fd08e3e7efa3155576c4f159a00f021', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `menu_operation` VALUES ('61ae8aa8ea5c33e2b19a289c93d2905b', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('76158f40ebcd1ebc3c72744160fe7389', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('79ca124e4c40aae8f1d263b52fffac51', 'b4db1d2e465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('81845d7f1f524f3d40fdb16de2e31dac', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('81adf5854cfb5e5bd8cc2cff68421d37', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('8389346785031b78e8c676ef053fe85b', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('8b93ed7136c667f9a06d3cdbbf157243', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('a9f61f2666d1886e1ba7abdc69cc0fa6', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('b7b09184f40836a7e128c5b5fd4f4244', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('b9fc390ccf23c33a870014e0c0496f65', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('bac902c85eeb8552f52b41d26eb5b499', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('c5dee55adf8b9be20413f39f101a81b1', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('c6e616a944d73583872e25a117b1b938', 'b4db1d2e465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('c9e0abe16c3d9a07726634f78c22e4be', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('daf2b1e5d0f4727a2bda47669e32828a', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('e4d279840891c5fe87cf4da7b6232a85', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('e52932d6bd99a5c2993a544b400590bb', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `menu_operation` VALUES ('f14a13dbdfbe160b12fe808617364ba7', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户端id',
  `resource_ids` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端所能访问的资源id集合,多个资源时用逗号,分隔',
  `client_secret` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端密钥',
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端申请的权限范围,可选值包括read,write等',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials, 若支持多个grant_type用逗号,分隔',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端的重定向URI,可为空, 当grant_type为authorization_code或implicit时, 在Oauth的流程中会使用并检查与注册时填写的redirect_uri是否一致.',
  `authorities` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指定客户端所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号,分隔, 如: ROLE_UNITY,ROLE_USER',
  `access_token_validity` int(11) NULL DEFAULT NULL COMMENT '设定客户端的access_token的有效时间值(单位:秒)',
  `refresh_token_validity` int(11) NULL DEFAULT NULL COMMENT '设定客户端的refresh_token的有效时间值(单位:秒)',
  `additional_information` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他信息, JSON格式',
  `autoapprove` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户是否自动Approval操作, 默认值为 \'false\', 可选值 true,false,read,write',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('hatech-oauth-rbac', NULL, '$2a$10$4V71Z4Yqne6ilzwMcW1izONdixn6iUZ.J4ZOdmcDBr3exAITpXc4e', 'server', 'client_credentials,refresh_token,password', '', 'ROLE_ADMIN,ROLE_DEVELOP,ROLE_TENANT', 6000, 6000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('hatech-oauth-server', NULL, '$2a$10$4V71Z4Yqne6ilzwMcW1izONdixn6iUZ.J4ZOdmcDBr3exAITpXc4e', 'server', 'client_credentials,refresh_token,password', '', 'ROLE_ADMIN,ROLE_DEVELOP,ROLE_TENANT', 6000, 6000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('swagger', NULL, '$2a$10$4V71Z4Yqne6ilzwMcW1izONdixn6iUZ.J4ZOdmcDBr3exAITpXc4e', 'server', 'authorization_code,client_credentials,refresh_token,password', 'http://127.0.0.1:8070/doc.html', 'ROLE_ADMIN,ROLE_DEVELOP,ROLE_TENANT', 6000, 6000, NULL, 'true');

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
INSERT INTO `operation` VALUES ('1a10fe26465411eab7f60a0027000011', '增加', '增加【表格头部】', 'add', 'add', 'table-header', 1, NULL, NULL);
INSERT INTO `operation` VALUES ('1a11016d465411eab7f60a0027000011', '提交', '提交【表格内部】', 'summit', 'fa-home', 'table-inner', 4, '2019-09-06 17:05:38.779680', NULL);
INSERT INTO `operation` VALUES ('1a11027c465411eab7f60a0027000011', '撤回', '撤回【表格内部】', 'recall', 'fa-home', 'table-inner', 5, '2019-09-06 17:05:58.533357', NULL);
INSERT INTO `operation` VALUES ('1a110364465411eab7f60a0027000011', '审批', '审批【表格内部】', 'approval', 'fa-home', 'table-inner', 6, '2019-09-06 17:06:14.202359', NULL);
INSERT INTO `operation` VALUES ('1a110468465411eab7f60a0027000011', '变更', '变更【表格内部】', 'modify', 'fa-home', 'table-inner', 7, '2019-09-06 17:06:27.013354', NULL);
INSERT INTO `operation` VALUES ('1a11056b465411eab7f60a0027000011', '生成', '生成【表格内部】', 'generate', 'fa-home', 'table-inner', 8, '2019-09-06 17:07:39.000000', NULL);
INSERT INTO `operation` VALUES ('1a11062e465411eab7f60a0027000011', '发布', '发布【表格内部】', 'publish', 'fa-home', 'table-inner', 9, '2019-09-06 17:08:27.913720', NULL);
INSERT INTO `operation` VALUES ('1a110700465411eab7f60a0027000011', '启用', '启用【表格内部】', 'start', 'fa-home', 'table-inner', 10, '2019-09-06 17:08:45.092553', NULL);
INSERT INTO `operation` VALUES ('1a1107cb465411eab7f60a0027000011', '停用', '停用【表格内部】', 'stop', 'fa-home', 'table-inner', 11, '2019-09-06 17:09:02.207449', NULL);
INSERT INTO `operation` VALUES ('1a1108a6465411eab7f60a0027000011', '配置按钮', '配置按钮【表格内部】', 'setting-button', NULL, 'table-inner', 12, '2020-01-17 02:37:13.894521', NULL);
INSERT INTO `operation` VALUES ('1a110cf3465411eab7f60a0027000011', '修改', '修改【表格内部】', 'update', 'bianji', 'table-inner', 1, '2019-09-06 12:50:52.968752', NULL);
INSERT INTO `operation` VALUES ('1a110dc2465411eab7f60a0027000011', '删除', '删除【表格头部】', 'delete', 'shanchu', 'table-header', 2, '2019-09-06 15:38:25.542525', NULL);
INSERT INTO `operation` VALUES ('1a110e7e465411eab7f60a0027000011', '上传', '上传【表格头部】', 'upload', 'fa-home', 'table-header', 3, '2019-09-06 16:30:17.260917', NULL);
INSERT INTO `operation` VALUES ('1a110f69465411eab7f60a0027000011', '下载', '下载【表格头部】', 'download', 'fa-home', 'table-header', 4, '2019-09-06 16:30:39.883451', NULL);
INSERT INTO `operation` VALUES ('1a1110e0465411eab7f60a0027000011', '编辑', '编辑【左侧树头部】', 'update', 'bianji', 'left-tree-header', 2, '2020-01-18 03:26:10.118506', NULL);
INSERT INTO `operation` VALUES ('1a1111c1465411eab7f60a0027000011', '导入', '导入【表格头部】', 'import', 'fa-home', 'table-header', 5, '2019-09-06 16:30:56.140745', NULL);
INSERT INTO `operation` VALUES ('1a11129c465411eab7f60a0027000011', '导出', '导出【表格头部】', 'export', 'fa-home', 'table-header', 6, '2019-09-06 16:31:15.712456', NULL);
INSERT INTO `operation` VALUES ('1a11138d465411eab7f60a0027000011', '查看', '查看【表格内部】', 'detail', 'chakan', 'table-inner', 2, '2019-09-06 17:04:58.966620', NULL);
INSERT INTO `operation` VALUES ('1a1115d9465411eab7f60a0027000011', '验证', '验证【表格内部】', 'validate', 'fa-home', 'table-inner', 3, NULL, NULL);
INSERT INTO `operation` VALUES ('1a1116fe465411eab7f60a0027000011', '增加', '增加【左侧树头部】', 'add', 'add', 'left-tree-header', 1, '2020-01-17 02:28:51.048439', NULL);
INSERT INTO `operation` VALUES ('1a1117f0465411eab7f60a0027000011', '重置密码', '重置密码【表格内部】', 'reset-password', 'fa-home', 'table-inner', 13, '2020-01-20 04:28:47.818374', NULL);
INSERT INTO `operation` VALUES ('1a111904465411eab7f60a0027000011', '删除', '删除【左侧树头部】', 'delete', 'shanchu', 'left-tree-header', 3, '2020-01-18 03:26:37.613307', NULL);
INSERT INTO `operation` VALUES ('8fb11a6e687f804434e8e39481ff9e44', '清空', '清空--左侧树头部', 'reset', 'chongzhi_icon', 'left-tree-header', 14, '2020-02-06 01:51:19.921703', NULL);

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
INSERT INTO `organization` VALUES ('106917ccd1785cd564ee18c74d96f11b', '测试组织', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('2befa325f27ca08db3dbf765f002e396', '同创集团', '0', NULL, 1, '机构描述', NULL, NULL);
INSERT INTO `organization` VALUES ('2db58e1ca48a18ea87514b4c5bee584a', '测试组织1', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('96ce50b24a485aa97cfe8ee460df93c7', '需求与产品规划部11', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('a238cec5290069de2f6ef85f78032c88', '测试组织111111111111111111111111111111111111111111111111111111111111111111', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('fef87b218cd63f4d74101f40952587e0', '测试组织fwefwfwefwfwefwfwefwfwefwfwefwfwefwfwefwfwefwfwefw', '2db58e1ca48a18ea87514b4c5bee584a', NULL, NULL, NULL, NULL, NULL);

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
INSERT INTO `role` VALUES ('0f14e4aa4843cf3400c1a314e4d0a227', 'ADMIN', 1, '超级管理员', NULL, NULL);
INSERT INTO `role` VALUES ('8370a3313c20ddf9d2e5f31390a5ae05', '测试角色', 0, NULL, NULL, NULL);
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
INSERT INTO `role_group` VALUES ('9ed4784afbc2565fb6789dff07dcc9f6', '测试角色组', 1, '测试角色组', NULL, NULL);
INSERT INTO `role_group` VALUES ('ae8b0d0003eaf5f18cbd4973b7b183d2', '角色组2', 1, NULL, NULL, NULL);
INSERT INTO `role_group` VALUES ('e14193ba9cdc7860b5ad38b64940dd40', '角色组1', 1, NULL, NULL, NULL);

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
INSERT INTO `role_group_role` VALUES ('b8f60b447c6d0c136e1c7bb01e16764d', '9ed4784afbc2565fb6789dff07dcc9f6', 'c822d16c4e68f542bfb9fd1d519b20be');
INSERT INTO `role_group_role` VALUES ('22231ac9f723c4aa94989ccb87d9984c', 'e14193ba9cdc7860b5ad38b64940dd40', '8370a3313c20ddf9d2e5f31390a5ae05');

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
INSERT INTO `role_group_user` VALUES ('cbe3ae93ee279aeca488b7cc8b580e68', '9ed4784afbc2565fb6789dff07dcc9f6', '44d015619a51393ddb80e62acfc1c4b2');
INSERT INTO `role_group_user` VALUES ('48fe57496422f127049c9f599a03dc99', '9ed4784afbc2565fb6789dff07dcc9f6', '52806d7f0a23d5074efc11bb8c957f4b');
INSERT INTO `role_group_user` VALUES ('b759f93f2ffcc676fad262b452e49d78', '9ed4784afbc2565fb6789dff07dcc9f6', '8d47f811deac6f2c62c5a2aa67c96e52');

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
INSERT INTO `role_menu_operation` VALUES ('049a01505a790ce1c3933ad9ca77b817', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('084669392ef6134d3ccc162e60c72576', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('12d9dae4925175d9f6ac81b5d421bb3a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('18908b105b4d8234fd750610e04973a2', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1d06256eb8a06ce9cd6eed9c5fb05ad7', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1fff964c82bde11fe2e2bbaf97d0de6d', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('202395f4bad07dec6b2d6618457e9e4c', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('2c4510c2e3b1f6339d55d5f3c6a4ab30', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('316204fadb8eb0b08dce019fce62f956', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3489d77507dca2db518723720769a0dc', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3b0f74ea6ed5d294b3ddab040b27bb76', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3b63d5db3bef32e549d94f2e1ecd840c', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3d86d70b7820605685e548e589855bdd', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('51746817f381a3d42f9fa617a73d981a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('548f772b671fc2366e449123be01a326', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('57de9417189148ab89262e3d8b9de3db', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5aa8accae8a896dc4f6b733cecaed344', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5c5efd53ba5490470620d073ebc37ab1', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5d0d3ef8aeb6e88b82d079afffd925da', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d7b465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('5d66f9d8360ab7fea39ed88ecd8056ac', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d88465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('5e0c862fdd3adc36313d243050574e9a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5f6431263824be964efe1d074e2714e1', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('617a0abb13a800a654e2485192e4a148', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('61ecf0377bf5431974509940a899a932', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('649f0916298e8925cc6ab4ebeceef91a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('69a908eee8c575f1264d00578fc924ba', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('7083840971581cfb42116dd8fad2849b', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('70bb12d9404e357dfe55827713805925', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('7402e1c1667e608f34640f22b40f18f7', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('789b4f100713eb3e8f88581b85e0bcd4', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('81bfe2701db022b4c7b93da5f7f4829b', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('81ce42ce0c93982b6c5da8eae7349fb5', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('82a37c34cb33212e833edae3a9735d6b', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('85b016e2d98ed631ba2e9b9126205f6b', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('85de007e7310576b4fab0061278b0ead', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('907e0ff78a563288b6a543fa4fc1170a', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('92733023ee30f7369124bfe0f81d971a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('96a40b39b6fa0d256c80b38ddd7065ac', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9b205feb4272d3d58f3e91ef31893bb2', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('9eeab226035248a32644527eccb4b9e0', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('9fb997108670243e9acf87b513a91512', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('ae2bb50e16a239ff80918d184e113faf', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b169089d7de7e8e2e7afc02e2084357e', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b5c06cd126a04c9e22191c5c24366bcf', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b74f6f223517a7fd6887d2e1368a5750', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('ba4b318c5a4a9756af2abfbeba783bcd', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('bb58b87e9ee59ee55fe3b5c172b2a7b2', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('bd99b98b86e62f70423adfb8e8669fa0', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c31442b4e86f5e1abbbb462e65cee8d8', '8370a3313c20ddf9d2e5f31390a5ae05', 'b4db1d88465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('c52f20a476cabfd52e9e359a18bdce0a', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c98c598e8e2f99bc4f58b01fec489b70', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('cc05efbe544db639c91f8c7f0edfd64d', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d2fb805e0e59fe0e37f2d9a142ee9209', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d635f436ce92f924397da1d6efa011ff', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d90d4928da28858292310a530ea37797', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d996dbbaed4df6117e32f0e2956374ed', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e491bdb406866dc3d05ca7513ba361ca', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e5fa99806110a18bb421674c7f02596c', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `role_menu_operation` VALUES ('e89793d62f34a51f08d5a0da27189d9b', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('e9d85cd5eb8f29776a4f54a5783d6fb7', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e9fbff8c148fc8e5ef3456f6fd7608a6', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('eb8bb178462453d061bd0c553536190d', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('ecd39759d08df507ce33a22e9249a1e2', '8370a3313c20ddf9d2e5f31390a5ae05', 'b4db1d7b465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('efd19fb875776ca9cb9f8a63c1470fd2', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f383c0be4af43f5af61e7ec7884fcb8f', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f5613e4782220d52e5cef9fee8796794', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `role_menu_operation` VALUES ('f78e7ee733c2a3c5358a1f89be3fa67e', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('f922a3a641881f1cfb230d6fd89bb0b2', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('fc3e60a01cc63ae6a62b503446cd5cf7', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('feababb0e89c09dad0f477929c9907a5', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('fecbf801ffb39113609ad53c2cf5900e', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');

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
) ENGINE = InnoDB AUTO_INCREMENT = 217 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '日志表主键ID',
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作用户ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作用户名称',
  `tenant_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作租户id',
  `company` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作用户所属公司',
  `department` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作用户所在机构部门',
  `ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作主机IP',
  `port` int(4) NULL DEFAULT NULL COMMENT '当前系统微服务端口',
  `micro_service` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统请求微服务名称',
  `class_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统请求微服务方法函数路径',
  `class_param` json NULL COMMENT '当前系统请求微服务方法函数参数',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '日志类型（录日志，操作日志，流程日志，脚本日志）',
  `business_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统业务日志类型（增删改查等等）',
  `model` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '系统操作模块',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作说明',
  `edit_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_log
-- ----------------------------
INSERT INTO `system_log` VALUES ('c2d8f345a02e33546d42e5eb24b1b31a', '1', 'user1', 'tenant1,tenant2', 'UUID', '123', '192.168.199.217', 8070, 'hatech-oauth-server', 'cn.com.hatechframework.server.controller.UserController.auth', '[{\"name\": \"user1\", \"details\": {\"tokenType\": \"Bearer\", \"tokenValue\": \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyMSIsInNjb3BlIjpbInNlcnZlciJdLCJleHAiOjE1NzczNzA5NzAsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iLCJST0xFX0RFVkxPUCIsIlJPTEVfVEVOQU5UIl0sImp0aSI6ImM0OGM2YjI3LWRjZmUtNDU0NC04MzVlLWQzYTgzZTM0NDhjZCIsInRlbmFudCI6WyJ0ZW5hbnQxIiwidGVuYW50MiJdLCJjbGllbnRfaWQiOiJoYXRlY2gtb2F1dGgtc2VydmVyIn0.Hit8ngr8EHLsTItLkJvSHqQ-tTHal2dK4d-WyTc-bOY\", \"remoteAddress\": \"127.0.0.1\"}, \"principal\": \"user1\", \"clientOnly\": false, \"authorities\": [{\"authority\": \"ROLE_ADMIN\"}, {\"authority\": \"ROLE_DEVLOP\"}, {\"authority\": \"ROLE_TENANT\"}], \"credentials\": \"\", \"authenticated\": true, \"oAuth2Request\": {\"scope\": [\"server\"], \"refresh\": false, \"approved\": true, \"clientId\": \"hatech-oauth-server\", \"extensions\": {}, \"authorities\": [], \"resourceIds\": [], \"responseTypes\": [], \"requestParameters\": {\"client_id\": \"hatech-oauth-server\"}}, \"userAuthentication\": {\"name\": \"user1\", \"principal\": \"user1\", \"authorities\": [{\"$ref\": \"$[0].authorities[0]\"}, {\"$ref\": \"$[0].authorities[1]\"}, {\"$ref\": \"$[0].authorities[2]\"}], \"credentials\": \"N/A\", \"authenticated\": true}}]', '操作日志', '查询', '用户接口', '解析token信息--解析token信息', '2019-12-26 12:58:37');

-- ----------------------------
-- Table structure for tenant
-- ----------------------------
DROP TABLE IF EXISTS `tenant`;
CREATE TABLE `tenant`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenant_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '租户名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '租户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant
-- ----------------------------
INSERT INTO `tenant` VALUES ('main-datasource', 'admin@hatech.com.cn');

-- ----------------------------
-- Table structure for tenant_datasource
-- ----------------------------
DROP TABLE IF EXISTS `tenant_datasource`;
CREATE TABLE `tenant_datasource`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenant_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户名称',
  `datasource_url` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '数据源连接地址',
  `datasource_username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '数据源用户名',
  `datasource_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '数据源密码',
  `datasource_driver` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '数据源驱动',
  `datasource_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '数据源连接池类型',
  `enabled` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否有效, 1有效, 0无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '租户数据源信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_datasource
-- ----------------------------
INSERT INTO `tenant_datasource` VALUES ('1224213306437341185', 'tenant_main-datasource', 'jdbc:mysql://127.0.0.1:3306/xincan-transaction?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);

-- ----------------------------
-- Table structure for tenant_user
-- ----------------------------
DROP TABLE IF EXISTS `tenant_user`;
CREATE TABLE `tenant_user`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户登录名称',
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `tenant_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '租户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '租户-用户 对应关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_user
-- ----------------------------
INSERT INTO `tenant_user` VALUES ('1224213306290540546', 'admin@hatech.com.cn', '15888888888', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1225298967701487617', '888@qq.com', '17800000000', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1226697631621246977', '999@qq.com', '15555555555', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1227431054051139586', 'hanlifeng@hatech.com.cn', '15711101677', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230113865377300481', 'ww1@qq.com', '13333333333', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230113969932910593', '23e23@qq.com', '13333333333', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230114026295967746', 'dwfer@qq.com', '14444444444', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230114104159027201', 'fwefw@qq.com', '15555555555', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230114151818903553', 'fwqrgre@qq.com', '15555555555', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230114204465807362', 'fwqrgeg@qq.com', '15555555555', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230114257259511810', 'fwhfiguweh@qq.com', '14444444444', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230114432120045570', 'fijowerfjo@1.com', '14444444444', 'main-datasource');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户登录名称',
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
INSERT INTO `user` VALUES ('007fb4e92a0758611f2a3c666e8dbbce', 'ww1@qq.com', '$2a$10$XwYOGP9wxJnzaxF.nhaNKObp1pCJjWzMBzkDdU2Kn5KusQmfTLXHW', 'ww1', '13333333333', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 12:56:15.158000');
INSERT INTO `user` VALUES ('1515a8486d9ed507f39afb773df4f596', 'fwefw@qq.com', '$2a$10$PqKYoqfNw26bIYmJbgwXM.hgK0zuI4VykivzsL3e99ShKF7oICfHq', 'fwefwfwefwfwefwfwefwfwefwfwefwfwefwfwefwfwefwfwefwfwefwfwefw', '15555555555', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 12:57:11.624000');
INSERT INTO `user` VALUES ('17e8c97d29f78aae2006a467abeb4982', 'fwqrgre@qq.com', '$2a$10$eaFliAIM/zvQYp4Rq31eWuW/n57p02zw7sm8eoWIgJGdzuAMd4NnO', 'fwqrgre', '15555555555', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 12:57:23.002000');
INSERT INTO `user` VALUES ('44d015619a51393ddb80e62acfc1c4b2', '888@qq.com', '$2a$10$52HQoRzcSPxUEe5HQT6T2u/R54Sfb9xC2zwHJ94BpF.uT3NQd9xxq', '运营001', '17800000000', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '44d015619a51393ddb80e62acfc1c4b2', '2020-02-06 06:03:34.296000');
INSERT INTO `user` VALUES ('45411059ad40cd916cce718e96d0c200', '23e23@qq.com', '$2a$10$S8hT7hry9i42nYLs8AAdx.f2DzU.ftb6DL.jQXOjWv4FrBqQyc2Ay', '23e23', '13333333333', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 12:56:39.633000');
INSERT INTO `user` VALUES ('6d8c50106eee2bd49437f477636c950c', 'zhangbin123zhangbin123zhangbin123zhangbin123zhangbin123zhangbin123zhangbin123zhangbin123@163.com', '$2a$10$b/huHGLSUld7U1J7YMFnDOSAyOEC2y1l9/kD9cZd92N5ynZfquOvm', 'zhangbin123zhangbin123zhangbin123zhangbin123zhangbin123zhangbin123zhangbin123zhangbin123@163.com', '15555555555', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-20 10:02:45.750000');
INSERT INTO `user` VALUES ('6f8ecbf6465311eab7f60a0027000011', 'admin@hatech.com.cn', '$2a$10$fT2GdLmNDqbgxeyEkLyDW.14V4DNXGwTd7d2D4OdaZdKJuMkI0NbW', '超级管理员', '15888888888', 'admin@hatech.com.cn', 1, 1, 1, 'UUID', NULL, 'UUID', '2befa325f27ca08db3dbf765f002e396', '6', '2020-01-17 14:28:38.000000');
INSERT INTO `user` VALUES ('80b09f44a0a7ad8494a830878fa1e1f1', 'fwqrgeg@qq.com', '$2a$10$E2edvBW/Ij6EMrE7XThgie7D/vvOej1hTXo2ddp3jB6RZdr.rnKyi', 'fwqrgeg', '15555555555', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 12:57:35.547000');
INSERT INTO `user` VALUES ('8d47f811deac6f2c62c5a2aa67c96e52', 'hanlifeng@hatech.com.cn', '$2a$10$rOUH0nBKnUuoK1vwYAjOTe.1ElzPTVuPoQy3odP.nH.Dcyf7oJkte', '韩立峰', '15711101677', NULL, 0, 1, 0, NULL, NULL, NULL, '96ce50b24a485aa97cfe8ee460df93c7', '6f8ecbf6465311eab7f60a0027000011', '2020-02-12 03:15:42.835000');
INSERT INTO `user` VALUES ('9a0b625f0a8eae7ce657f0c2f442e010', 'fijowerfjo@1.com', '$2a$10$qsf/g1BMyaXBKAVBnZsZb.kJ9bfK9lZAWE2lBfsqIl4h0bgVbc/f6', 'fijowerfjo', '14444444444', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 12:58:29.814000');
INSERT INTO `user` VALUES ('c501aa2593cb27ecdf064db50cc142a2', 'fwhfiguweh@qq.com', '$2a$10$PBTRrBsHaLiRAWQNt93wnOtJ4e6VlfUjbGOi2cOUFkLnBPTIhHAOe', 'fwhfiguweh', '14444444444', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 12:57:48.143000');
INSERT INTO `user` VALUES ('f1da83e513cb177f92e6f2dda72fca24', 'dwfer@qq.com', '$2a$10$ZVv3jc4tZtmufdYdD8wskO.orLlP45Swqu2VWxj9ivGX9gzIzo/oW', 'dwfer', '14444444444', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 12:56:53.064000');

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
INSERT INTO `user_role` VALUES ('a5a3d07770e474f4b33dd68053abda8d', '44d015619a51393ddb80e62acfc1c4b2', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('c2d8f345a02e33776d42e5eb24b1b31a', '6f8ecbf6465311eab7f60a0027000011', '0f14e4aa4843cf3400c1a314e4d0a227');
INSERT INTO `user_role` VALUES ('cafa8d9221f7942d81e302529848f292', '8d47f811deac6f2c62c5a2aa67c96e52', '0f14e4aa4843cf3400c1a314e4d0a227');

-- ----------------------------
-- View structure for role_view
-- ----------------------------
DROP VIEW IF EXISTS `role_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `role_view` AS select `t1`.`id` AS `id`,`t1`.`role_name` AS `name`,`t1`.`status` AS `status`,`t2`.`role_group_id` AS `parent_id` from (`role` `t1` left join `role_group_role` `t2` on((`t1`.`id` = `t2`.`role_id`))) union all select `role_group`.`id` AS `id`,`role_group`.`role_group_name` AS `name`,`role_group`.`status` AS `status`,'0' AS `parent_id` from `role_group`;

-- ----------------------------
-- View structure for user_view
-- ----------------------------
DROP VIEW IF EXISTS `user_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_view` AS select `t1`.`id` AS `id`,`t1`.`username` AS `username`,`t1`.`password` AS `password`,`t1`.`name` AS `name`,`t1`.`phone` AS `phone`,`t1`.`email` AS `email`,`t1`.`is_admin` AS `is_admin`,`t1`.`status` AS `status`,`t1`.`is_tenant` AS `is_tenant`,`t1`.`organization_id` AS `organization_id`,`t2`.`name` AS `organization_name`,`t1`.`edit_time` AS `edit_time` from (`user` `t1` left join `organization` `t2` on((`t1`.`organization_id` = `t2`.`id`)));

-- ----------------------------
-- View structure for user_role_view
-- ----------------------------
DROP VIEW IF EXISTS `user_role_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_role_view` AS select `t1`.`id` AS `id`,`t1`.`username` AS `username`,`t1`.`password` AS `password`,`t1`.`name` AS `name`,`t1`.`phone` AS `phone`,`t1`.`email` AS `email`,`t1`.`is_admin` AS `is_admin`,`t1`.`status` AS `status`,`t1`.`is_tenant` AS `is_tenant`,`t1`.`organization_id` AS `organization_id`,`t1`.`organization_name` AS `organization_name`,`t2`.`role_id` AS `role_id`,`t4`.`name` AS `role_name`,`t4`.`status` AS `role_status`,`t3`.`role_group_id` AS `role_group_id`,`t5`.`name` AS `role_group_name`,`t5`.`status` AS `role_group_status`,`t1`.`edit_time` AS `edit_time` from ((((`user_view` `t1` left join `user_role` `t2` on((`t1`.`id` = `t2`.`user_id`))) left join `role_group_user` `t3` on((`t1`.`id` = `t3`.`user_id`))) left join `role_view` `t4` on((`t2`.`role_id` = `t4`.`id`))) left join `role_view` `t5` on((`t3`.`role_group_id` = `t5`.`id`)));

-- ----------------------------
-- Function structure for getOrgCList
-- ----------------------------
DROP FUNCTION IF EXISTS `getOrgCList`;
delimiter ;;
CREATE FUNCTION `getOrgCList`(rootId VARCHAR(64))
 RETURNS varchar(4000) CHARSET utf8mb4
BEGIN
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
