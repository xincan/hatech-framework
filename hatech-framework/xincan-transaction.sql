/*
 Navicat Premium Data Transfer

 Source Server         : git.hatech.com.cn
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : git.hatech.com.cn:33306
 Source Schema         : xincan-transaction

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 11/03/2020 12:00:39
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
INSERT INTO `menu` VALUES ('b4308df5d7c403f2a2b2ffe444df5518', '长度测试长度测试长度测试长度测', '长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度', '长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试', 'b4db1d88465211eab7f60a0027000011', '长度测试长度测试长度测试长度测试长度测试长度测试长', '{}', 3, 1, NULL, '2020-02-21 10:00:41.642000');
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
INSERT INTO `menu_operation` VALUES ('57b72690301c7cce5de4f439b45473b1', 'b4db1d7b465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
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
INSERT INTO `oauth_client_details` VALUES ('1', 'hatech-oauth-server ', '$2a$10$Eok/qFlygRDGgZNF8.b/KeHa9rHjhBng9GuOYvlwfyuxw2T94LeUu', 'server', 'authorization_code', 'http://127.0.0.1:8070/doc.html', '', 6000, 6000, '', '');
INSERT INTO `oauth_client_details` VALUES ('hatech-oauth-rbac', NULL, '$2a$10$4V71Z4Yqne6ilzwMcW1izONdixn6iUZ.J4ZOdmcDBr3exAITpXc4e', 'server', 'client_credentials,refresh_token,password', '', 'ROLE_ADMIN,ROLE_DEVELOP,ROLE_TENANT', 6000, 6000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('hatech-oauth-server', NULL, '$2a$10$4V71Z4Yqne6ilzwMcW1izONdixn6iUZ.J4ZOdmcDBr3exAITpXc4e', 'server', 'client_credentials,refresh_token,password', '', 'ROLE_ADMIN,ROLE_DEVELOP,ROLE_TENANT', 6000, 6000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('swagger', NULL, '$2a$10$4V71Z4Yqne6ilzwMcW1izONdixn6iUZ.J4ZOdmcDBr3exAITpXc4e', 'server', 'authorization_code,client_credentials,refresh_token,password', 'http://127.0.0.1:8070/doc.html', 'ROLE_ADMIN,ROLE_DEVELOP,ROLE_TENANT', 6000, 6000, NULL, 'true');
INSERT INTO `oauth_client_details` VALUES ('test-1', 'hatech-oauth-server ', '$2a$10$7pQ3xHyXrRcaw9Q5k/xFue2NvMCifIoTVjUQBeBpKOlmcKEgHvYuG', 'server', 'authorization_code,client_credentials,refresh_token,password', 'http://127.0.0.1:8070/doc.html', '', 6000, 6000, '', '');
INSERT INTO `oauth_client_details` VALUES ('test-2', 'hatech-oauth-server ', '$2a$10$ADACW8THMk.ePvcTDxNjiOT03biaVCnfLq7ECJud0DMOnF7/axySy', 'server', 'authorization_code,client_credentials,refresh_token,password', 'http://127.0.0.1:8070/doc.html', '', 6000, 6000, '', 'ROLE_ADMIN,ROLE_DEVELOP,ROLE_TENANT');
INSERT INTO `oauth_client_details` VALUES ('测试客户端', 'hatech-oauth-server ', '$2a$10$iC1.ONFcZtka35V4fWmfc.z5yyGPtgre4vf/1hzKnfsMQOZcKgq76', 'server', 'authorization_code,client_credentials,refresh_token,password', 'http://127.0.0.1:8070/doc.html', '', 6000, 6000, '', '');
INSERT INTO `oauth_client_details` VALUES ('测试长度', 'hatech-oauth-server ', '$2a$10$vi0/33rdVqCGhT5jH/5UKuOs6DLU/IiFBfCYalz5me6FScC8tElxa', 'server', 'authorization_code', 'http://127.0.0.1:8070/doc.html', '', 6000, 6000, '', '');

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
INSERT INTO `organization` VALUES ('1f117902b5e2c7759278f24a39d3ef6e', '同创中国', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('2befa325f27ca08db3dbf765f002e396', '同创集团', '0', NULL, 1, '机构描述', NULL, NULL);
INSERT INTO `organization` VALUES ('2c6a97b4c9523e371559af8c0dce8e8f', '层级3', '1f117902b5e2c7759278f24a39d3ef6e', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('3ad9bee5910b8b6d70ab5966ef930c75', '层级4', '2c6a97b4c9523e371559af8c0dce8e8f', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('4e231c6f29987246b44ac2fdcbccd498', '长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('4f6335ccdafa9412f3a02b0f34389982', '134c长度测试134c长度测试134c长度测试134c长度测试134c长度测试134c长度测试134c长度测试134c长度测试134c长度测试134c长度测试134c长度测试134c长度测试134c', '0', NULL, 2, '机构描述', NULL, NULL);
INSERT INTO `organization` VALUES ('67b7e52b5ae8c49d41444785a0ab515d', '长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试长度测试', '4e231c6f29987246b44ac2fdcbccd498', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('6c7259278ffdd3609df78a96755dfd9a', '层级5', '3ad9bee5910b8b6d70ab5966ef930c75', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('7a7ac7101d2dbc6aac3d7337794a4a28', '同创中国', '4e231c6f29987246b44ac2fdcbccd498', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('96ce50b24a485aa97cfe8ee460df93c7', '需求与产品规划部', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('a238cec5290069de2f6ef85f78032c88', '测试组织', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('a576905d9f55db0fac1f05c9f1e25e40', '测试组织', '2befa325f27ca08db3dbf765f002e396', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('a71da55a96971f25b430ba12a1e7e1c3', '层级7', 'f1f387130ea28529af1e60479a4ab3bb', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('ddd671521d334806d0d4bd4463a46983', '接口测试', '0', NULL, 2, '机构描述', NULL, NULL);
INSERT INTO `organization` VALUES ('f1f387130ea28529af1e60479a4ab3bb', '层级6', '6c7259278ffdd3609df78a96755dfd9a', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `organization` VALUES ('fd600e1a44c304f7499dcbb48b604d00', '层级8', 'a71da55a96971f25b430ba12a1e7e1c3', NULL, NULL, NULL, NULL, NULL);

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
INSERT INTO `role` VALUES ('0a87a66cd9ae4c830ba59317f7d013ee', '角色翻页-11', 1, '测试描述', NULL, '2020-02-21 09:03:33.366000');
INSERT INTO `role` VALUES ('0f14e4aa4843cf3400c1a314e4d0a227', 'ADMIN', 1, '超级管理员', NULL, '2020-02-20 15:25:20.000000');
INSERT INTO `role` VALUES ('153f956fd6037aa28e428264df74d77d', '角色翻页-7', 1, '测试描述', NULL, '2020-02-21 09:02:44.641000');
INSERT INTO `role` VALUES ('26f1ebfb0ed620f56d17389a0e7add79', '角色翻页-1', 1, NULL, NULL, '2020-02-21 09:01:27.272000');
INSERT INTO `role` VALUES ('2a2dbf61691eed49675c36b9c44b69bc', '角色翻页-13', 1, '测试描述', NULL, '2020-02-21 09:03:41.779000');
INSERT INTO `role` VALUES ('4c5d8e90ad77db254e112d91c77d5649', '角色翻页87', 1, '测试描述', NULL, '2020-02-21 09:02:48.541000');
INSERT INTO `role` VALUES ('52ab2eda3a7693739289a6a66493b490', '角色翻页-6', 1, '测试描述', NULL, '2020-02-21 09:02:39.472000');
INSERT INTO `role` VALUES ('621aec11d4c157a4f95394b4fdf0c4e7', '角色翻页-5', 1, '测试描述', NULL, '2020-02-21 09:02:34.822000');
INSERT INTO `role` VALUES ('6de3a9eccf6408cc81c5c5fd0e51868b', '测试角色-菜单管理权限', 1, NULL, NULL, '2020-02-20 11:00:55.252000');
INSERT INTO `role` VALUES ('7270dc7659c101c56d1eab96ca134918', '测试', 1, NULL, NULL, '2020-02-20 09:51:52.761000');
INSERT INTO `role` VALUES ('8579a4b39dc2ac2dc63ff7eba2a5cee1', '角色翻页-9', 1, '测试描述', NULL, '2020-02-21 09:03:02.285000');
INSERT INTO `role` VALUES ('8e6db86f0e2a037b924471e48907f566', '角色翻页-4', 1, NULL, NULL, '2020-02-21 09:01:53.825000');
INSERT INTO `role` VALUES ('a784e37f6c0d095304cb8c597769f410', '角色翻页-8', 1, '测试描述', NULL, '2020-02-21 09:02:58.715000');
INSERT INTO `role` VALUES ('c822d16c4e68f542bfb9fd1d519b20be', 'TENANT_INIT', 1, '租户初始化角色', NULL, '2020-02-20 15:26:31.000000');
INSERT INTO `role` VALUES ('ccbb227451d6d14b6bcc3ef8ca7c5909', '角色翻页-12', 1, '测试描述', NULL, '2020-02-21 09:03:36.813000');
INSERT INTO `role` VALUES ('d530bf2944390ae1385d215cb253af2c', '角色翻页-2', 0, '测试描述', NULL, '2020-02-21 08:59:47.729000');
INSERT INTO `role` VALUES ('e119745e364147d5f513397600f864d9', '角色翻页-3', 1, '测试描述', NULL, '2020-02-21 08:59:52.392000');
INSERT INTO `role` VALUES ('f1d72e0927b30200952089570e4a8f3e', '测试角色-用户管理权限', 1, NULL, NULL, '2020-02-21 01:59:00.141000');
INSERT INTO `role` VALUES ('ff2956b813687e05ab4df07dd18463a9', '角色翻页-10', 1, '测试描述', NULL, '2020-02-21 09:03:28.666000');

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
INSERT INTO `role_group` VALUES ('d54b4d63e1028cd24fd4c40ea6b6cd04', '角色-菜单管理、用户管理权限', 1, NULL, NULL, NULL);
INSERT INTO `role_group` VALUES ('e14193ba9cdc7860b5ad38b64940dd40', '角色组1', 1, NULL, NULL, NULL);
INSERT INTO `role_group` VALUES ('fd0e65cbf0a4020d4c2a13392a58ac47', '角色翻页-菜单管理权限', 1, NULL, NULL, NULL);

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
INSERT INTO `role_group_role` VALUES ('72455f0b9580af1399685110e29cb834', 'd54b4d63e1028cd24fd4c40ea6b6cd04', '6de3a9eccf6408cc81c5c5fd0e51868b');
INSERT INTO `role_group_role` VALUES ('3cfda11b28803f664509c3e0cb85d272', 'd54b4d63e1028cd24fd4c40ea6b6cd04', 'f1d72e0927b30200952089570e4a8f3e');
INSERT INTO `role_group_role` VALUES ('50fafae41fbc506733e429839130768c', 'e14193ba9cdc7860b5ad38b64940dd40', '0f14e4aa4843cf3400c1a314e4d0a227');
INSERT INTO `role_group_role` VALUES ('cb01a3a38f171ba4a1160029920cf9a4', 'e14193ba9cdc7860b5ad38b64940dd40', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `role_group_role` VALUES ('985ba844582f32673fd327c68109b52c', 'e14193ba9cdc7860b5ad38b64940dd40', 'aa2044042c467986506f1e0bedfed4d7');
INSERT INTO `role_group_role` VALUES ('17d3a6ccb1cd01ceaabacb084251e44c', 'e14193ba9cdc7860b5ad38b64940dd40', 'c822d16c4e68f542bfb9fd1d519b20be');
INSERT INTO `role_group_role` VALUES ('6516eb6beabb3bfbbcdaa9460606c5c4', 'fd0e65cbf0a4020d4c2a13392a58ac47', '6de3a9eccf6408cc81c5c5fd0e51868b');

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
INSERT INTO `role_group_user` VALUES ('43b9955e84f7c4def643841ad1732e95', '2', '391972aef187679ca53154b5244f3c92');
INSERT INTO `role_group_user` VALUES ('9d776990f8ad24f363dd8cd15124e87d', '3', '391972aef187679ca53154b5244f3c92');
INSERT INTO `role_group_user` VALUES ('298f3f439d5a0e7cfe05bea29da9ad40', '7dbe1c2ac455d85d6f1a64fd9a2a0b00', '2a5b0b0cdfc9f9db93aede79848a089f');
INSERT INTO `role_group_user` VALUES ('d82b0ef0c709073ef3c879f805c045bb', '7dbe1c2ac455d85d6f1a64fd9a2a0b00', '6ae38d4c069a780c12dfbcd0a8a4041c');
INSERT INTO `role_group_user` VALUES ('9eccda3fd7333666cc441026d274a84c', '7dbe1c2ac455d85d6f1a64fd9a2a0b00', '9177c011aec8633dc487e83c0f6fa097');
INSERT INTO `role_group_user` VALUES ('4f7294b7ef12861424c47e8f4c415024', '7dbe1c2ac455d85d6f1a64fd9a2a0b00', 'c2ccf22f67c0d23b4f015509a6c5fc60');
INSERT INTO `role_group_user` VALUES ('4161c606802f33667b0d48ec90aae480', '7dbe1c2ac455d85d6f1a64fd9a2a0b00', 'e90d3b67b28b6a47fe3d77642d08ecd4');
INSERT INTO `role_group_user` VALUES ('ef6b2e24a128c3dda6bcfc041ca76c54', '9ed4784afbc2565fb6789dff07dcc9f6', '056414612def61c7d3960aee17be4d74');
INSERT INTO `role_group_user` VALUES ('ec38b3766229a7de9300bd878a953356', '9ed4784afbc2565fb6789dff07dcc9f6', '1896de4c3297068497651735fb86a6a2');
INSERT INTO `role_group_user` VALUES ('cbe3ae93ee279aeca488b7cc8b580e68', '9ed4784afbc2565fb6789dff07dcc9f6', '44d015619a51393ddb80e62acfc1c4b2');
INSERT INTO `role_group_user` VALUES ('48fe57496422f127049c9f599a03dc99', '9ed4784afbc2565fb6789dff07dcc9f6', '52806d7f0a23d5074efc11bb8c957f4b');
INSERT INTO `role_group_user` VALUES ('68d6d876a45fb323ee99aca403144d2a', '9ed4784afbc2565fb6789dff07dcc9f6', '7e620c9cc31cdcd14766588ec2073012');
INSERT INTO `role_group_user` VALUES ('d130bfd9319e2edbf72e35e3ef4e84a7', '9ed4784afbc2565fb6789dff07dcc9f6', '8228582e9cc8771f833f3f2b109d04f2');
INSERT INTO `role_group_user` VALUES ('b759f93f2ffcc676fad262b452e49d78', '9ed4784afbc2565fb6789dff07dcc9f6', '8d47f811deac6f2c62c5a2aa67c96e52');
INSERT INTO `role_group_user` VALUES ('1ae53b1c5ce9c1e98dfae9e6c4147cf1', '9ed4784afbc2565fb6789dff07dcc9f6', '9d9a92dd6f312c722be8554ae5d80479');
INSERT INTO `role_group_user` VALUES ('d8cf5b8f3519a203a4a7ad10511d45e2', '9ed4784afbc2565fb6789dff07dcc9f6', 'da359e627d908d13178ce0c31f3ad50d');
INSERT INTO `role_group_user` VALUES ('53ef7844d5ea9e343775490db55268e5', '9ed4784afbc2565fb6789dff07dcc9f6', 'f4f212cea8e1337d7caf361e557e57f2');
INSERT INTO `role_group_user` VALUES ('b61749c1a4f941b3f19baf50136b3463', 'd54b4d63e1028cd24fd4c40ea6b6cd04', '056414612def61c7d3960aee17be4d74');
INSERT INTO `role_group_user` VALUES ('940d184b0c6b7c4e4f810d4aa692085c', 'e14193ba9cdc7860b5ad38b64940dd40', '056414612def61c7d3960aee17be4d74');
INSERT INTO `role_group_user` VALUES ('89681c29e4bf38bfff268b5fc884c74e', 'e14193ba9cdc7860b5ad38b64940dd40', '1896de4c3297068497651735fb86a6a2');
INSERT INTO `role_group_user` VALUES ('c5ef43af28cea534d63ff7d66d629729', 'e14193ba9cdc7860b5ad38b64940dd40', '417ccd302900a46f97d2c9d248c030dc');
INSERT INTO `role_group_user` VALUES ('a17fedcbbe98ee663bd933847bd5fa8e', 'e14193ba9cdc7860b5ad38b64940dd40', '7e620c9cc31cdcd14766588ec2073012');
INSERT INTO `role_group_user` VALUES ('de55b1a96053871cabc1056dd7ecca87', 'e14193ba9cdc7860b5ad38b64940dd40', '8228582e9cc8771f833f3f2b109d04f2');
INSERT INTO `role_group_user` VALUES ('9d5b5b5b83e0993db017ade2906e327b', 'e14193ba9cdc7860b5ad38b64940dd40', '9d9a92dd6f312c722be8554ae5d80479');
INSERT INTO `role_group_user` VALUES ('28c0d7621a8ad6e5a8de978c6ea7cac8', 'e14193ba9cdc7860b5ad38b64940dd40', 'da359e627d908d13178ce0c31f3ad50d');
INSERT INTO `role_group_user` VALUES ('52009902b65210227baba28d98b6947b', 'e14193ba9cdc7860b5ad38b64940dd40', 'f4f212cea8e1337d7caf361e557e57f2');
INSERT INTO `role_group_user` VALUES ('51e497a6a8d4abe499f54d3be865602f', 'fd0e65cbf0a4020d4c2a13392a58ac47', '056414612def61c7d3960aee17be4d74');

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
INSERT INTO `role_menu_operation` VALUES ('00b417e9b922e8be127fdaa7e65176af', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('049a01505a790ce1c3933ad9ca77b817', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('084669392ef6134d3ccc162e60c72576', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('09de9250a818e4b6f9e4e17d6eb7994c', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('0b3c9f6c92565557bf1c97624d5277a4', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('0bd26073d2fe4af71c6c0d18b586c394', '0a87a66cd9ae4c830ba59317f7d013ee', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('0bef224cfc10c0ffc0a3833b13bbdb68', 'ccbb227451d6d14b6bcc3ef8ca7c5909', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('11aabfaadfa07a544b59c5410e0612d0', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('12d9dae4925175d9f6ac81b5d421bb3a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('14b3d272424339105588e4084347d431', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1538a4442b72e9431b1d6535c76f2776', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `role_menu_operation` VALUES ('161c8a3800429a1e31a85c9576c27ac0', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1667b74e924bdbdacea34c8ee8d52759', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1669c90ceacb6d84e1d453391bb02ef3', '8579a4b39dc2ac2dc63ff7eba2a5cee1', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('16e4955be82e8bdfdddba6bfff3d0170', '4c5d8e90ad77db254e112d91c77d5649', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('18908b105b4d8234fd750610e04973a2', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1906c67af37857cd8cef55038caffed5', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('198fb61cfa6279d73f62ef6f3e230a3e', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('19edc4d6d4a3fb2cbdefd2f0e5226ba5', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1b89e52a8c370d666ef173b81160b83f', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1c47936970ca0447997de02032fcf27c', 'f1d72e0927b30200952089570e4a8f3e', '3207886eb99c5c0b80519440637b09e8', NULL);
INSERT INTO `role_menu_operation` VALUES ('1c5e996ce78a0aaa6cd0e26ec637baa7', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('1d06256eb8a06ce9cd6eed9c5fb05ad7', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('1fff964c82bde11fe2e2bbaf97d0de6d', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('202395f4bad07dec6b2d6618457e9e4c', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('211579750cdd6f81921e32095ea6e7b1', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('21cdb39ce6c69b9d8031712aebcc00f3', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('23310748ba97b6792850e565f966dba3', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('23a08d0dc7f5b5c31d534cbe7ec95cdd', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('23c0f14b3087587dedc7ebea2ed8b6d0', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('25d844b411e007596b2c79bde8412d91', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('2684a2b873b5d32f4dd94e8cdcdfb3de', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('28d2841ce578945ccff5b63aded5d8bc', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('2c4510c2e3b1f6339d55d5f3c6a4ab30', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('2e8795170b7301f5ba0c319fa03d1d01', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('302bbb6da8569276e87f2bff058ad8cf', '8e6db86f0e2a037b924471e48907f566', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('316204fadb8eb0b08dce019fce62f956', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('32770e1e8fa8c5b337cf79d9e4d7d8f0', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('33a50df33f441b41fb7f1281e33f054f', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('33cf3419fece37729b6a1fdb1b3a15dc', '621aec11d4c157a4f95394b4fdf0c4e7', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('3489d77507dca2db518723720769a0dc', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3584910082b100e02f9a6a0deef4da7b', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3671b5ed34c01b6c4192bdcbb0b49bfa', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3739a885baf47746b3bdbacd59c4e20d', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3aecaab7f7250dc99f42c42000042f11', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3b0f74ea6ed5d294b3ddab040b27bb76', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3b2252072d43d7cfa0cc3069af04e2da', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3b63d5db3bef32e549d94f2e1ecd840c', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3d67819a5da87aba14a14e2f09f8d53b', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3d86d70b7820605685e548e589855bdd', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('3da80b30d02216740c20eda8dfbe1651', 'e119745e364147d5f513397600f864d9', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('419884fa89399d9dc600fdd7219e7f04', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d7b465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('41b35e0bab9266c67bf398cda042b170', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('41d3451bf6016d3aff43b2b42480eb99', 'a784e37f6c0d095304cb8c597769f410', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('41ec22082fbd2df9c7ab973629c80c59', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('43a6dd283fe47b0c885c09b219dae48f', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('448a5e1e22efcbe820cbb814144e1b8a', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('472ba89db2df609cbe7feee2b7e52298', '8e6db86f0e2a037b924471e48907f566', 'b4db1d93465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('497fb22f9ae5d14585d850740f57eea6', '8e6db86f0e2a037b924471e48907f566', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('4d3a53c77dad03302cf4d7d6e5c291e3', 'ff2956b813687e05ab4df07dd18463a9', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('4eea990e1da30dfd5e8b1e3ed7f68a3a', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('4f05ad11308c2315e1af48f3dad6fdff', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('4ff71f6d5b02791b1b01c14c91599283', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('50cd5fe4402e610762361da2b7e49ba4', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('51746817f381a3d42f9fa617a73d981a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('548f772b671fc2366e449123be01a326', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('55f4ad6e3e30c7c0c2857ce0625d364f', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('57de9417189148ab89262e3d8b9de3db', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('57f6ef88d91a53529c86c1568e18ecf2', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5912ca2a4b79681632dc4a19ca835c7f', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('59d3aff1c2eeec8c8480059af9fcc56c', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5a0bcc4eb184473dac7ae7b5fb39966b', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5aa8accae8a896dc4f6b733cecaed344', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5c5efd53ba5490470620d073ebc37ab1', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5d0d3ef8aeb6e88b82d079afffd925da', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d7b465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('5d66f9d8360ab7fea39ed88ecd8056ac', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d88465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('5e0c862fdd3adc36313d243050574e9a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('5f6431263824be964efe1d074e2714e1', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('6090c4a8743d8821271c49521c5428a6', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('60b6f28a0ff650b7c50682ab92b7ec09', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('60b83c563a0025eaa1f5249be92f0b30', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d7b465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('617a0abb13a800a654e2485192e4a148', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('61c87e364be02adf590476e846d14baa', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `role_menu_operation` VALUES ('61ecf0377bf5431974509940a899a932', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('631c7325ace1d2ee6125ffa232f1e632', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('649f0916298e8925cc6ab4ebeceef91a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('66c2f93087518b495cd5ee207bdf00d8', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('6887e8a6084dbe56dfbc61aac7fb4306', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('69584fb70f14c3be429ca5f5ace4410e', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('699d84961fc9940f4d98c46fa041e96d', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('69a908eee8c575f1264d00578fc924ba', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('6b7887496dd6b3dcbb78f1ba6b1bbaef', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('6c1da1dc176e02b4915b6d95e8c2b3f2', '52ab2eda3a7693739289a6a66493b490', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('6cc1fde510cb1a59c563ac1a0d5db533', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d93465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('7083840971581cfb42116dd8fad2849b', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('70b0cf0e126ea1b97d64171416ca21b6', 'f1d72e0927b30200952089570e4a8f3e', '60d1c0776aa2cc59256017afa5db361d', NULL);
INSERT INTO `role_menu_operation` VALUES ('70bb12d9404e357dfe55827713805925', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('70c1899267799202a2de9d679a4aabb6', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('73ae2eb63254cdeecdfbc716750f1fc6', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('7402e1c1667e608f34640f22b40f18f7', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('75e7e7e30550841607d240a3ae7f8406', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('76b37e230abcbd2e40f7fe5828976d10', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('775a646d52303bc3c2c030e9711473e0', 'f1d72e0927b30200952089570e4a8f3e', '19333dbfd110c5efa16bd23f35a95cf5', NULL);
INSERT INTO `role_menu_operation` VALUES ('77ba6593294a35b8d7b83138f209a044', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('789b4f100713eb3e8f88581b85e0bcd4', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('7ac68692f9d7d142eb1bda6dbd7716d2', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('7b02d22748dfaa8b316b5af020a8a382', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('7d3968c661919bb8bfe00b89b1936280', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('7dec0cc84390228ecbd6c66e76d7d532', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('7e569fd059475992638366f98dc8c513', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('808f060d225f7b4b4fb884edcbfe06ac', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('81bfe2701db022b4c7b93da5f7f4829b', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('81ce42ce0c93982b6c5da8eae7349fb5', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('82a37c34cb33212e833edae3a9735d6b', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('836dbdae48643afc935abc87929a7944', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('8527a35b7d038c4b356d46e8fccff86d', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('85b016e2d98ed631ba2e9b9126205f6b', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('85de007e7310576b4fab0061278b0ead', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('8646175fc2a13d0768624ac5f9bf0556', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a110700465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('882541404f7ebd25470c898b8e1effdb', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('8c5c1daa1357f2941dd9abe66bc0c3f2', 'e119745e364147d5f513397600f864d9', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('8c88c179d6671c0b8b0e9cd01dab4e93', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('8d3376782d062a164380cbf17d82f817', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('8d37cb57b736d67b248c3763dcb94353', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('8e1d8c8f852fac57b7dc9718c7101c84', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9078a2f4e7d2337e979da9ff17fa1e40', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('907e0ff78a563288b6a543fa4fc1170a', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('909e6cbec56bc1c9fe51213389ecbd42', 'e119745e364147d5f513397600f864d9', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('91d6328f51ad3d69543c78df9eed5873', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `role_menu_operation` VALUES ('92120f618e162974d09ab6382e30d06a', 'f1d72e0927b30200952089570e4a8f3e', '8a0927c8bb3938bbc5d9066d67772cc9', NULL);
INSERT INTO `role_menu_operation` VALUES ('92733023ee30f7369124bfe0f81d971a', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('93beb4d1e1b7370553aa142c8f67a28e', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('94afee620f4f5ce4fcb085dc386bdd09', 'e119745e364147d5f513397600f864d9', 'b4db1d93465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('950ca31a840b98cccfd2c5e0f8afeb80', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('951e3ee9b938c6df858748fb77f4c8b5', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9678982b2107d7e822d5d34e2679c1a1', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9692aa184a6ce8b143f9e7246610a0b4', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('9696015e164e64b88e9a114c3a1cadea', 'f1d72e0927b30200952089570e4a8f3e', '06c1dc468bc18c1e45f1416c8ccf3d7e', NULL);
INSERT INTO `role_menu_operation` VALUES ('96a40b39b6fa0d256c80b38ddd7065ac', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9741bee660cccb5ef4846b9043a2c546', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('99522b5ace22100ba742c2aabc5bda26', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9b205feb4272d3d58f3e91ef31893bb2', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('9b6f2ca57a227dd45df21abc9d5ec98d', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9bd210447cacbbb1d4d197b07e2adcb2', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9dc484bcec70ed712e1f280b32397445', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a1117f0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9e58b736b2c780d5dd1662b4236e4e9c', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9eeab226035248a32644527eccb4b9e0', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('9f5627f177a41ca26b562966238fe82c', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('9fb997108670243e9acf87b513a91512', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('a0997ce5e3fb25dd747fbd1b96566999', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('a4b43503be5e8f4c180894211c1caebd', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('a4b883f2f6b5a940f431aed173f800d4', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('a571b37d7d2910e533cf3ef57b080b4b', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('a59d80b7bf2552d02d1adc8c08cc7b77', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('a833ba3359d3fd3e4f009e7eb09b2fc6', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('a9990d4c895e08ad7ea612167a15abda', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('acced33883737011e6a8222d1bbef615', 'f1d72e0927b30200952089570e4a8f3e', '24ea22b06d154b057148a0ed2fee6fe4', NULL);
INSERT INTO `role_menu_operation` VALUES ('ace9c975982a495c3354fd97614fa841', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('adaebca678673e42183e9b77b01ddb1c', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('ae2bb50e16a239ff80918d184e113faf', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('aee7ff0e8bc9b78fc2f5edec524132d4', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('af4e18818a0d01554cd3e6c0f3ad4daa', 'f1d72e0927b30200952089570e4a8f3e', 'fa91461332130aadf4b8bd8fb7a37fb3', NULL);
INSERT INTO `role_menu_operation` VALUES ('b00fba2b1f7efce9665b2d7fc6a5aa6e', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b0df329bed6838ed0b3d9cdcbb991666', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b169089d7de7e8e2e7afc02e2084357e', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b5a3500006dc7ea7288be8a410f3a368', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b5bfe65504c20ea6425de276590af57e', '153f956fd6037aa28e428264df74d77d', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('b5c06cd126a04c9e22191c5c24366bcf', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b74f6f223517a7fd6887d2e1368a5750', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b8b07a9a808dddb81aad88be4f844e69', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('b96435d650bc4d187bbee0e9ab0ca0f0', 'd530bf2944390ae1385d215cb253af2c', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('ba4b318c5a4a9756af2abfbeba783bcd', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('bb58b87e9ee59ee55fe3b5c172b2a7b2', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d2e465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('bc6053244ade9f58575fc5cd0624d387', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('bd1ebf5cb31fccc3a04a43b856768e2f', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('bd9939d59e0305fed9cff332174bee1e', '8e6db86f0e2a037b924471e48907f566', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('bd99b98b86e62f70423adfb8e8669fa0', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('bfa58178f3b63c585707cc4082f9e4e2', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d93465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('c1ac12877482985a4d2f23025c4d1e1b', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c24552b47081223f9c00455608151ac6', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c36901ebaf58b5a05618232314720bc3', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c52f20a476cabfd52e9e359a18bdce0a', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c8b0aad182fc7c7d9f28790b9cbdbdfb', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c8f20d54d8d972615def7a8d843a63a8', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c98c598e8e2f99bc4f58b01fec489b70', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('c9a06939d2aa4504ec5a973b0c1a8a2b', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('c9bfc9b8e4eb770d45e85220438f1821', '8e6db86f0e2a037b924471e48907f566', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('ca4df37b3dcc9df7dbe3460e9430a3e3', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('cba59a8b0a93ecec82a463a5cd2ffff7', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('cbc5706a9b8c719be6bcf0778b47d606', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('cc05efbe544db639c91f8c7f0edfd64d', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('ccac42bf8845a513a9eaf09df7b71afb', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('cf2a7e052aed4a1e640a443daa506ef1', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('cfa4d6c859309166f39378b7042d9ce8', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d04627eca3efcc0d129e382904ff9105', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d1e51cc584618f741fd0b164c6473db4', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d88465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('d263903403806db7888bf72a9a401014', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d2fb805e0e59fe0e37f2d9a142ee9209', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a1116fe465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d4f74228d33ceb20396c444b390d32c6', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d4fc026d52105b5b7490fb32a6afbf37', '8e6db86f0e2a037b924471e48907f566', 'b4db1d93465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d561614fdf3cf3e49b628344cbff44d4', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d5674a15c4c6697a4807bff62c7c7495', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d635f436ce92f924397da1d6efa011ff', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d6583a02f0b42fd98304f3c3ca22c922', 'f1d72e0927b30200952089570e4a8f3e', '5d87e3417c3c98202ab94dac11cbb0bb', NULL);
INSERT INTO `role_menu_operation` VALUES ('d761ce7f79a1281b1f656bb68b352b12', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('d80cdde0faa20b2f0ee29a7d69ad24be', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('d85cc1715d94ef3333af7353b55901b0', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d90d4928da28858292310a530ea37797', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d953c8fde9edb7db567133f3544ce5be', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('d9568ec8a0ea43e59216d143c50bc479', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d2e465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d996dbbaed4df6117e32f0e2956374ed', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('d9ca1f31cde002d0a99ca5df7ea338ca', '8e6db86f0e2a037b924471e48907f566', 'b4db1d44465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('dd0876f268e932e01223343e3fbb5f13', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d93465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('dde87569a454c27ddb53765f5cb1dbf4', '2a2dbf61691eed49675c36b9c44b69bc', '', NULL);
INSERT INTO `role_menu_operation` VALUES ('e00bdacb2d39607bcd983eacbb550789', 'e119745e364147d5f513397600f864d9', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e1af2163999f5a0cf8c99d7a5d83885e', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e1fc1e430679347df21e500152511d57', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e38c24cf836fc393d54e922e4515e1fc', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e491bdb406866dc3d05ca7513ba361ca', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e58c50d64cd5c78f496a90fccab40416', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e5fa99806110a18bb421674c7f02596c', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `role_menu_operation` VALUES ('e89793d62f34a51f08d5a0da27189d9b', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d93465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('e9d85cd5eb8f29776a4f54a5783d6fb7', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('e9fbff8c148fc8e5ef3456f6fd7608a6', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('eaf5e460c53d472835ad7cac2b0033c2', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d93465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('eb8bb178462453d061bd0c553536190d', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('eb988d89c3d5c7ae25af0c8dfa92af40', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('ecdaa0060ed9eb98ac5ce893c9374da4', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', '1a110cf3465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('ecfef7729431f63aa54494525281270a', 'f1d72e0927b30200952089570e4a8f3e', '95bcbc9c6cceeeb981021ce32e4ae86b', NULL);
INSERT INTO `role_menu_operation` VALUES ('ed2c8b1bed9dbe52caafa38440043671', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `role_menu_operation` VALUES ('efd19fb875776ca9cb9f8a63c1470fd2', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f1d5cab54dd03873f7cd4f5017ecb8cd', 'e119745e364147d5f513397600f864d9', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f1f36c4e12223c480972e7c663b12d20', '8e6db86f0e2a037b924471e48907f566', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f383c0be4af43f5af61e7ec7884fcb8f', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f43789998a70bcf46e4159355938ef6d', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a1107cb465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f4e58bc85c589ae238dbebee2b7f3bda', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f5613e4782220d52e5cef9fee8796794', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', '8fb11a6e687f804434e8e39481ff9e44');
INSERT INTO `role_menu_operation` VALUES ('f589baae6d81b9925c421993ebc9e0a6', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d54465211eab7f60a0027000011', '1a10fe26465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f69e5579d346b0a95fffa1d59a14696a', 'e119745e364147d5f513397600f864d9', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f7028ad5ccd2dd807bdc4ac7a2c7ae71', 'e119745e364147d5f513397600f864d9', 'b4db1ccb465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('f78e7ee733c2a3c5358a1f89be3fa67e', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d54465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('f7be27ce157ff7f9ef666b5b0edff537', '6de3a9eccf6408cc81c5c5fd0e51868b', 'b4db1d2e465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f922a3a641881f1cfb230d6fd89bb0b2', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d44465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('f9a260c0ba142bbf040f2f79a7b69c86', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('fbbb7d996615177f8b4f35b26bd51820', 'd530bf2944390ae1385d215cb253af2c', 'b4db1d44465211eab7f60a0027000011', '1a11138d465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('fc3e60a01cc63ae6a62b503446cd5cf7', '0f14e4aa4843cf3400c1a314e4d0a227', 'b4db1d54465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('fe25b132d0ab1812490a7db5f2c113ff', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', '1a111904465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('feababb0e89c09dad0f477929c9907a5', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a1110e0465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('feb72537d3fc0d0565aa435b736f686e', '8e6db86f0e2a037b924471e48907f566', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('fecbf801ffb39113609ad53c2cf5900e', 'c822d16c4e68f542bfb9fd1d519b20be', 'b4db1d44465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('feeed705289350ed27e980d3936959ca', 'f1d72e0927b30200952089570e4a8f3e', 'b4db1d44465211eab7f60a0027000011', NULL);
INSERT INTO `role_menu_operation` VALUES ('ff8a34395558c44b09935e0834eac152', '26f1ebfb0ed620f56d17389a0e7add79', 'b4db1d2e465211eab7f60a0027000011', '1a1108a6465411eab7f60a0027000011');
INSERT INTO `role_menu_operation` VALUES ('ffb1fad95c7c2226ab1bad90d15ff800', 'e119745e364147d5f513397600f864d9', 'b4db1d2e465211eab7f60a0027000011', '1a110dc2465411eab7f60a0027000011');

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
) ENGINE = InnoDB AUTO_INCREMENT = 632 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `tenant` VALUES ('1224896381099503617', 'tenant1@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1225015935528177665', 'tenant2@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1225021613290397697', 'tenant3@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1225335019057278978', 'admin@qq.com');
INSERT INTO `tenant` VALUES ('1227161416453140481', 'tenant4@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1227177555993870338', 'tenant11@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1228135766052339713', '8899@qq.com');
INSERT INTO `tenant` VALUES ('1228136304881991681', '889911@qq.com');
INSERT INTO `tenant` VALUES ('1229603936038576129', 'lisi@1.cn');
INSERT INTO `tenant` VALUES ('1229702038296748033', 'zhangbing1@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229706393246785537', 'zhangbing2@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229944611317768194', 'zhangbing3@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229952608437821442', 'zhangbing4@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229953322027343874', 'zhangbing5@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229958234077421569', 'zhangbing7@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229958574550048769', 'zhangbing8@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229961437221249025', 'zhangbing9@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229964535822049281', 'zhangbing10@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229965463996358657', 'zhangbing11@hatech.com.cn');
INSERT INTO `tenant` VALUES ('1229966993252179970', 'zhangbing12@hatechcomcn');
INSERT INTO `tenant` VALUES ('1229968078243127297', 'zhangbing13@1');
INSERT INTO `tenant` VALUES ('1229996828083118081', 'zhangbing13@1.com');
INSERT INTO `tenant` VALUES ('1230389272285044738', 'zhangbing23@1.com');
INSERT INTO `tenant` VALUES ('1230389968854081537', 'zhangbing24@1com.cn');
INSERT INTO `tenant` VALUES ('1230795290257154050', 'zhangbing123412344444444444444444444444444444444444444444444444444444444444444444444444444444@qq.com');
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
INSERT INTO `tenant_datasource` VALUES ('1224213306437341185', 'tenant_main-datasource', 'jdbc:mysql://git.hatech.com.cn:33306/xincan-transaction?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1224896385478356994', 'tenant_1224896381099503617', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1224896381099503617?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1225015938208337921', 'tenant_1225015935528177665', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1225015935528177665?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1225021617736359937', 'tenant_1225021613290397697', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1225021613290397697?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1225335027051622401', 'tenant_1225335019057278978', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1225335019057278978?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1227161419418513409', 'tenant_1227161416453140481', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1227161416453140481?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1227177558661447681', 'tenant_1227177555993870338', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1227177555993870338?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1228135770145980417', 'tenant_1228135766052339713', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1228135766052339713?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1228136307201441793', 'tenant_1228136304881991681', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1228136304881991681?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229603937363976194', 'tenant_1229603936038576129', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1229603936038576129?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229702039160774657', 'tenant_1229702038296748033', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1229702038296748033?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229706394173726722', 'tenant_1229706393246785537', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1229706393246785537?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229944612257292290', 'tenant_1229944611317768194', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1229944611317768194?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229952609196990465', 'tenant_1229952608437821442', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1229952608437821442?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229953322698432513', 'tenant_1229953322027343874', 'jdbc:mysql://git.hatech.com.cn:33306/tenant_1229953322027343874?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229958234924670978', 'tenant_1229958234077421569', 'jdbc:mysql://192.168.1.186:3306/tenant_1229958234077421569?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229958575338577921', 'tenant_1229958574550048769', 'jdbc:mysql://192.168.1.186:3306/tenant_1229958574550048769?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229961437879754754', 'tenant_1229961437221249025', 'jdbc:mysql://192.168.1.186:3306/tenant_1229961437221249025?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229964536656715777', 'tenant_1229964535822049281', 'jdbc:mysql://192.168.1.186:3306/tenant_1229964535822049281?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229965464742944770', 'tenant_1229965463996358657', 'jdbc:mysql://192.168.1.186:3306/tenant_1229965463996358657?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229966993910685697', 'tenant_1229966993252179970', 'jdbc:mysql://192.168.1.186:3306/tenant_1229966993252179970?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229968078993907714', 'tenant_1229968078243127297', 'jdbc:mysql://192.168.1.186:3306/tenant_1229968078243127297?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1229996829437878273', 'tenant_1229996828083118081', 'jdbc:mysql://192.168.1.186:3306/tenant_1229996828083118081?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1230389273346203650', 'tenant_1230389272285044738', 'jdbc:mysql://192.168.1.186:3306/tenant_1230389272285044738?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1230389969739079682', 'tenant_1230389968854081537', 'jdbc:mysql://192.168.1.186:3306/tenant_1230389968854081537?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);
INSERT INTO `tenant_datasource` VALUES ('1230795291305730050', 'tenant_1230795290257154050', 'jdbc:mysql://192.168.1.186:3306/tenant_1230795290257154050?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT', 'root', '123456', 'com.mysql.cj.jdbc.Driver', 'com.zaxxer.hikari.HikariDataSource', NULL);

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
INSERT INTO `tenant_user` VALUES ('1224896383062437889', 'tenant1@hatech.com.cn', '13333333333', '1224896381099503617');
INSERT INTO `tenant_user` VALUES ('1224929979424894977', 'test@hatech.com.cn', '15555555555', '1224896381099503617');
INSERT INTO `tenant_user` VALUES ('1225015937302368257', 'tenant2@hatech.com.cn', '13333333333', '1225015935528177665');
INSERT INTO `tenant_user` VALUES ('1225021616440320002', 'tenant3@hatech.com.cn', '18888888888', '1225021613290397697');
INSERT INTO `tenant_user` VALUES ('1225298967701487617', '888@qq.com', '17800000000', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1225335022207201281', 'admin@qq.com', '17099999999', '1225335019057278978');
INSERT INTO `tenant_user` VALUES ('1226697631621246977', '999@qq.com', '15555555555', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1227161418298634242', 'tenant4@hatech.com.cn', '18888888888', '1227161416453140481');
INSERT INTO `tenant_user` VALUES ('1227177557642231810', 'tenant11@hatech.com.cn', '15555555555', '1227177555993870338');
INSERT INTO `tenant_user` VALUES ('1227431054051139586', 'hanlifeng@hatech.com.cn', '15711101677', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1228135768279515137', '8899@qq.com', '17800000000', '1228135766052339713');
INSERT INTO `tenant_user` VALUES ('1228136305947344897', '889911@qq.com', '17800000000', '1228136304881991681');
INSERT INTO `tenant_user` VALUES ('1229603727447449602', '1@1.cn', '13111111111', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1229603936881631233', 'lisi@1.cn', '13123123213', '1229603936038576129');
INSERT INTO `tenant_user` VALUES ('1229694154628423682', 'zhangbing@hatech.com.cn', '13232322222', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1229702038762315777', 'zhangbing1@hatech.com.cn', '13233333333', '1229702038296748033');
INSERT INTO `tenant_user` VALUES ('1229706393687187458', 'zhangbing2@hatech.com.cn', '13232322222', '1229706393246785537');
INSERT INTO `tenant_user` VALUES ('1229944611800113153', 'zhangbing3@hatech.com.cn', '13232222222', '1229944611317768194');
INSERT INTO `tenant_user` VALUES ('1229952608794337282', 'zhangbing4@hatech.com.cn', '13232222222', '1229952608437821442');
INSERT INTO `tenant_user` VALUES ('1229953322333528065', 'zhangbing5@hatech.com.cn', '13232222222', '1229953322027343874');
INSERT INTO `tenant_user` VALUES ('1229958234387800066', 'zhangbing7@hatech.com.cn', '13232222222', '1229958234077421569');
INSERT INTO `tenant_user` VALUES ('1229958574931730434', 'zhangbing8@hatech.com.cn', '13232222222', '1229958574550048769');
INSERT INTO `tenant_user` VALUES ('1229961437560987650', 'zhangbing9@hatech.com.cn', '13232222222', '1229961437221249025');
INSERT INTO `tenant_user` VALUES ('1229964536241479681', 'zhangbing10@hatech.com.cn', '13232222222', '1229964535822049281');
INSERT INTO `tenant_user` VALUES ('1229965464331902978', 'zhangbing11@hatech.com.cn', '13232222222', '1229965463996358657');
INSERT INTO `tenant_user` VALUES ('1229966993541586945', 'zhangbing12@hatechcomcn', '13232222222', '1229966993252179970');
INSERT INTO `tenant_user` VALUES ('1229968078587060225', 'zhangbing13@1', '13232222222', '1229968078243127297');
INSERT INTO `tenant_user` VALUES ('1229996828787761153', 'zhangbing13@1.com', '13232222222', '1229996828083118081');
INSERT INTO `tenant_user` VALUES ('1230001695023456257', 'zhangbing13@hatech.com.cn', '13223232323', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230002878442135553', 'zhangbing@163.com', '13212111111', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230003897079193601', 'zhangbing14@hatech.com.cn', '13232333333', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230004767472771074', 'zhangbing15@hatech.com.cn', '13232222222', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230007592890163202', 'zhangbing16@hatech.com.cn', '13232322222', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230007734993182722', 'zhangbing17@hatech.com.cn', '13232322222', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230013334556794881', 'zhangbing18@hatech.com.cn', '13232322222', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230015675951505409', 'zhangbing19@hatech', '13122233333', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230021840835993602', 'zhangbing19@hatech.com.cn', '13232222222', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230030775827587074', 'zhangbing20@hatech.com.cn', '13122233330', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230389272918384641', 'zhangbing23@1.com', '13232222222', '1230389272285044738');
INSERT INTO `tenant_user` VALUES ('1230389969281900545', 'zhangbing24@1com.cn', '13232222222', '1230389968854081537');
INSERT INTO `tenant_user` VALUES ('1230419550613299201', 'zhangbing22@hatech.com.cn', '13233333333', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230432694106611714', 'zhangbing21@hatech.com.cn', '13122233330', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230433028765933569', 'zhangbing23@hatech.com.cn', '13122233330', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230433057190731777', 'zhangbing24@hatech.com.cn', '13122233330', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230433131186642946', 'zhangbing26@hatech.com.cn', '13122233330', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230447991345668098', 'zhangbing28@hatech.com.cn', '13233333333', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230738957822615553', 'token@qq.com', '13232222222', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230775811594805250', 'zhangbin.comg@1.co', '13233333333', 'main-datasource');
INSERT INTO `tenant_user` VALUES ('1230795290710138881', 'zhangbing123412344444444444444444444444444444444444444444444444444444444444444444444444444444@qq.com', '13232333333', '1230795290257154050');

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
INSERT INTO `user` VALUES ('056414612def61c7d3960aee17be4d74', 'zhangbing28@hatech.com.cn', '$2a$10$Vmd3/m2PEa5D8EP1qjq7xeHic4nrL7xYe5KlhaykrzB2ngEhm8SDK', '角色组-多角色权限测试', '13233333333', NULL, 0, 1, 0, NULL, NULL, NULL, 'a238cec5290069de2f6ef85f78032c88', '056414612def61c7d3960aee17be4d74', '2020-02-20 11:03:56.630000');
INSERT INTO `user` VALUES ('1896de4c3297068497651735fb86a6a2', 'zhangbing15@hatech.com.cn', '$2a$10$4hwACT1qo6OpzOGZ5Jp/IOpLeHCRjmfjdn423OFHtNxoVX0B0BM5G', '同创中国-15', '13232222222', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 05:42:43.830000');
INSERT INTO `user` VALUES ('219538f46a82e31aaaf6ff00d44b1c78', 'zhangbing@hatech.com.cn', '$2a$10$ieSf8RLLv.uPeYaTqtQ4C.QJH9zZ9JrQqn4hNCx/D7LRYxpr7QKUa', '同创中国', '13232322222', NULL, 0, 1, 0, NULL, NULL, NULL, 'a238cec5290069de2f6ef85f78032c88', '6f8ecbf6465311eab7f60a0027000011', '2020-02-18 09:08:28.049000');
INSERT INTO `user` VALUES ('2c4164af5c459c9ec366026fd8ae223c', 'zhangbing@163.com', '$2a$10$a9ich6ZR94pOrkXwnui5TeEmxCvq8QQMqifdlRjHl5jPLXOzKwLZ6', '同创中国-13', '13212111111', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 05:35:13.438000');
INSERT INTO `user` VALUES ('38cce565fa9d2ab06e42c1d6b38d1c09', 'zhangbing13@hatech.com.cn', '$2a$10$RyNJkqqRbNTD8mIQFh.yiew4P0q6oNFXuFNGmOQmASIlXLBXZsiPG', '同创中国-13', '13223232323', NULL, 0, 0, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 05:30:31.416000');
INSERT INTO `user` VALUES ('3c3ccd159c7999195f364905c9f57386', '1@1.cn', '$2a$10$3UFw/pSRn0rro2Zyz0meruFy3ov/Riw0Fnu60hKRZTVtfCU/lK.ZC', '张三', '13111111111', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-18 03:09:08.924000');
INSERT INTO `user` VALUES ('417ccd302900a46f97d2c9d248c030dc', 'zhangbing14@hatech.com.cn', '$2a$10$qNgfKyC7nso9i6JmJuNd0.r7kDsJ4eohliGg9M9LmlxI6Alivrcfi', '同创中国-14', '13232333333', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 05:39:16.313000');
INSERT INTO `user` VALUES ('44d015619a51393ddb80e62acfc1c4b2', '888@qq.com', '$2a$10$52HQoRzcSPxUEe5HQT6T2u/R54Sfb9xC2zwHJ94BpF.uT3NQd9xxq', '运营001', '17800000000', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '44d015619a51393ddb80e62acfc1c4b2', '2020-02-06 06:03:34.296000');
INSERT INTO `user` VALUES ('52806d7f0a23d5074efc11bb8c957f4b', '999@qq.com', '$2a$10$z/ytEFDYc0cjvbt9pQQTsefUvX3qLWRij6Ydf4ow0xEjw8Fb6SYRe', '用户1', '15555555555', NULL, 0, 1, 0, NULL, NULL, NULL, 'a238cec5290069de2f6ef85f78032c88', '44d015619a51393ddb80e62acfc1c4b2', '2020-02-10 02:41:21.359000');
INSERT INTO `user` VALUES ('66335d9a65ec79b77a0bbff163f77a6c', 'zhangbing19@hatech.com.cn', '$2a$10$k32WE7V4xLzW.ngn50FQ3.MWt3ZYfv5Pj6/pmXo0YZ8cHYJEaBDmW', '同创中国19同创中国19同创中国19同创中国19同创中国19同创中国19同创中国19同创中国19同创', '13232222222', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 06:50:34.441000');
INSERT INTO `user` VALUES ('6ae38d4c069a780c12dfbcd0a8a4041c', 'zhangbing24@hatech.com.cn', '$2a$10$qqiQtbB4I0PLHzN0xDkbnenxEnb7Diok7jbpd0ARiBWw8UNDspSQ6', '同创中国24', '13122233330', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-20 10:04:36.050000');
INSERT INTO `user` VALUES ('6f8ecbf6465311eab7f60a0027000011', 'admin@hatech.com.cn', '$2a$10$fT2GdLmNDqbgxeyEkLyDW.14V4DNXGwTd7d2D4OdaZdKJuMkI0NbW', '超级管理员', '15888888888', 'admin@hatech.com.cn', 1, 1, 1, 'UUID', NULL, 'UUID', '2befa325f27ca08db3dbf765f002e396', '6', '2020-01-17 14:28:38.000000');
INSERT INTO `user` VALUES ('6fc8363cb6794f515dabf4d71c9d8d59', 'zhangbin.comg@1.co', '$2a$10$JgcUK4nfZC0PoUaCUycT7ufZjzNmp9i0ETwRV.0zBhlZt983tZ9aK', '测试邮箱', '13233333333', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-21 08:46:35.142000');
INSERT INTO `user` VALUES ('71db53cd6d52a2e8e9dc41e7949f286e', 'token@qq.com', '$2a$10$qpILYUH7ZcVD7R1oCjtZqOWy4zHRTZkz/EZZfWtWT.caVRGavXzvC', '认证中心账号测试', '13232222222', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-21 06:20:08.646000');
INSERT INTO `user` VALUES ('7e620c9cc31cdcd14766588ec2073012', 'zhangbing17@hatech.com.cn', '$2a$10$oZv/8SWGdjeGWJi4hs2.j.IOCbSaqTfDHr20DUZsmMHGEUeO9mMsm', '同创中国17', '13232322222', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 05:54:31.353000');
INSERT INTO `user` VALUES ('81665d75f4125ac02c92b097480022c2', 'zhangbing22@hatech.com.cn', '$2a$10$X76bnqxZErTAizjR80BdZO4v2Ng0XEwCO/AB8Zk2z6MMdSC3.o1ne', '同创中国22', '13233333333', NULL, 0, 1, 0, NULL, NULL, NULL, '2befa325f27ca08db3dbf765f002e396', '6f8ecbf6465311eab7f60a0027000011', '2020-02-20 09:10:55.846000');
INSERT INTO `user` VALUES ('8228582e9cc8771f833f3f2b109d04f2', 'zhangbing16@hatech.com.cn', '$2a$10$d071hCb6zIvfT8C15E43zuIO8UZmq//NmllJJWzINiAG1QGNcXiCm', '同创中国16', '13232322222', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 05:53:57.470000');
INSERT INTO `user` VALUES ('8d47f811deac6f2c62c5a2aa67c96e52', 'hanlifeng@hatech.com.cn', '$2a$10$rOUH0nBKnUuoK1vwYAjOTe.1ElzPTVuPoQy3odP.nH.Dcyf7oJkte', '韩立峰', '15711101677', NULL, 0, 1, 0, NULL, NULL, NULL, '96ce50b24a485aa97cfe8ee460df93c7', '6f8ecbf6465311eab7f60a0027000011', '2020-02-12 03:15:42.835000');
INSERT INTO `user` VALUES ('9177c011aec8633dc487e83c0f6fa097', 'zhangbing23@hatech.com.cn', '$2a$10$hMbWSsSN78q3qfFDl5uNKObT28WrPrgRDgwvNG91boaoku7I608Vi', '同创中国23', '13122233330', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-20 10:04:29.310000');
INSERT INTO `user` VALUES ('c2ccf22f67c0d23b4f015509a6c5fc60', 'zhangbing21@hatech.com.cn', '$2a$10$56XywG1PgrPctyR4vsTBz.qDpEkrV/O4WIcgez4/iLskmZNEKpKRq', '同创中国21', '13122233330', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-20 10:03:09.512000');
INSERT INTO `user` VALUES ('da359e627d908d13178ce0c31f3ad50d', 'zhangbing20@hatech.com.cn', '$2a$10$1SD5C8QZVTeYMRJol7.zHeW6eVcJmniAX9KXoW6ok4EKihCjkMkri', '同创中国201', '13222233330', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-19 07:26:04.715000');
INSERT INTO `user` VALUES ('e90d3b67b28b6a47fe3d77642d08ecd4', 'zhangbing26@hatech.com.cn', '$2a$10$syJ9vayvnwukVxASMKD4w.HxQ2X/57jYSg8KSrlQw8IZVu0x6qKk2', '同创中国26长度测试同创中国26长度测试同创中国26长度测试同创中国26长度测试同创中国26长度测试同创中国26长度测试同创中国26长度测试同创中国26长度测试同创中国26长度测试同创中国26长度测试', '13122233330', NULL, 0, 1, 0, NULL, NULL, NULL, '1f117902b5e2c7759278f24a39d3ef6e', '6f8ecbf6465311eab7f60a0027000011', '2020-02-20 10:04:53.714000');

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
INSERT INTO `user_role` VALUES ('8c93081884b3742ea1aa1df5a9132795', '056414612def61c7d3960aee17be4d74', 'f1d72e0927b30200952089570e4a8f3e');
INSERT INTO `user_role` VALUES ('07a7f6bd229494f34b30f1e48d4ab9d6', '1896de4c3297068497651735fb86a6a2', '0f14e4aa4843cf3400c1a314e4d0a227');
INSERT INTO `user_role` VALUES ('8d6634395d6044f5fa79d26a6206b4b8', '1896de4c3297068497651735fb86a6a2', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('ceb83c858f39e409bd196834bde3f279', '1896de4c3297068497651735fb86a6a2', 'c822d16c4e68f542bfb9fd1d519b20be');
INSERT INTO `user_role` VALUES ('a24d007d1d55d9b4068982f59f15cc34', '219538f46a82e31aaaf6ff00d44b1c78', 'f1d72e0927b30200952089570e4a8f3e');
INSERT INTO `user_role` VALUES ('6aaca8aca1848b7f5bdf17b3b327801b', '2a5b0b0cdfc9f9db93aede79848a089f', '1');
INSERT INTO `user_role` VALUES ('aea54ba558c03ce38e650ccae96784f7', '38cce565fa9d2ab06e42c1d6b38d1c09', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('a3f1b3b3491249a8a6e51806a6fbb243', '391972aef187679ca53154b5244f3c92', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('e765639054d134e35780922bd01ba1e4', '3c3ccd159c7999195f364905c9f57386', '0f14e4aa4843cf3400c1a314e4d0a227');
INSERT INTO `user_role` VALUES ('ea83372962e2cbe255e64384b9c763d1', '417ccd302900a46f97d2c9d248c030dc', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('a5a3d07770e474f4b33dd68053abda8d', '44d015619a51393ddb80e62acfc1c4b2', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('052d98c9725aefd5d2a19fa4325a2ee5', '6ae38d4c069a780c12dfbcd0a8a4041c', '1');
INSERT INTO `user_role` VALUES ('c2d8f345a02e33776d42e5eb24b1b31a', '6f8ecbf6465311eab7f60a0027000011', '0f14e4aa4843cf3400c1a314e4d0a227');
INSERT INTO `user_role` VALUES ('b49bf3931979b275caa337c0ac496fe8', '7e620c9cc31cdcd14766588ec2073012', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('4f2f7f1dcfa653a083caf65ba5a4807e', '8228582e9cc8771f833f3f2b109d04f2', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('cafa8d9221f7942d81e302529848f292', '8d47f811deac6f2c62c5a2aa67c96e52', '0f14e4aa4843cf3400c1a314e4d0a227');
INSERT INTO `user_role` VALUES ('e685b0f33113c277f78f9c137dd67215', '9177c011aec8633dc487e83c0f6fa097', '1');
INSERT INTO `user_role` VALUES ('05f67146ef343c76d849e12fef76cc2d', '9d9a92dd6f312c722be8554ae5d80479', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('eaabd06bd0a434741aba71bdcbe33c3f', 'c2ccf22f67c0d23b4f015509a6c5fc60', '1');
INSERT INTO `user_role` VALUES ('25f6695dc026e28925a865ceede47ef0', 'da359e627d908d13178ce0c31f3ad50d', '8370a3313c20ddf9d2e5f31390a5ae05');
INSERT INTO `user_role` VALUES ('9f499aee78e031bfef6312711a1f677c', 'e90d3b67b28b6a47fe3d77642d08ecd4', '1');
INSERT INTO `user_role` VALUES ('010a0c27beb0a5b99eb5fc0a79db258a', 'f4f212cea8e1337d7caf361e557e57f2', '8370a3313c20ddf9d2e5f31390a5ae05');

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
