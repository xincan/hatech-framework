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

CREATE TABLE `menu_operation`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源ID',
  `menu_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单ID',
  `operation_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单操作关系表' ROW_FORMAT = Dynamic;

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

CREATE TABLE `role`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `status` smallint(255) NULL DEFAULT NULL COMMENT '是否启用，1为启用，0为暂停',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `edit_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` timestamp(6) NULL DEFAULT NULL COMMENT '编辑时间(时间戳)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

CREATE TABLE `role_group`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组ID',
  `role_group_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组名称',
  `status` smallint(6) NULL DEFAULT NULL COMMENT '是否启用，1为启用，0为暂停',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `edit_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` timestamp(6) NULL DEFAULT NULL COMMENT '编辑时间(时间戳)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组' ROW_FORMAT = Dynamic;

CREATE TABLE `role_group_role`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键ID',
  `role_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组ID',
  `role_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_group_role_idx`(`role_group_id`, `role_id`) USING BTREE COMMENT '用户组-角色关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组-角色关系表' ROW_FORMAT = Dynamic;

CREATE TABLE `role_group_user`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键ID',
  `role_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色组ID',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_group_user`(`role_group_id`, `user_id`) USING BTREE COMMENT '用户组-用户关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色组-用户关系表' ROW_FORMAT = Dynamic;

CREATE TABLE `role_menu_operation`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键ID',
  `role_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  `menu_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单ID',
  `operation_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_menu_id`(`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 122 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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

CREATE TABLE `user_role`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_role_idx`(`user_id`, `role_id`) USING BTREE COMMENT '用户-角色关联索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户-角色关系表' ROW_FORMAT = Dynamic;

CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `role_view` AS select `t1`.`id` AS `id`,`t1`.`role_name` AS `name`,`t1`.`status` AS `status`,`t2`.`role_group_id` AS `parent_id` from (`role` `t1` left join `role_group_role` `t2` on((`t1`.`id` = `t2`.`role_id`))) union all select `role_group`.`id` AS `id`,`role_group`.`role_group_name` AS `name`,`role_group`.`status` AS `status`,'0' AS `parent_id` from `role_group`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_view` AS select `t1`.`id` AS `id`,`t1`.`username` AS `username`,`t1`.`password` AS `password`,`t1`.`name` AS `name`,`t1`.`phone` AS `phone`,`t1`.`email` AS `email`,`t1`.`is_admin` AS `is_admin`,`t1`.`status` AS `status`,`t1`.`is_tenant` AS `is_tenant`,`t1`.`organization_id` AS `organization_id`,`t2`.`name` AS `organization_name`,`t1`.`edit_time` AS `edit_time` from (`user` `t1` left join `organization` `t2` on((`t1`.`organization_id` = `t2`.`id`)));
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_role_view` AS select `t1`.`id` AS `id`,`t1`.`username` AS `username`,`t1`.`password` AS `password`,`t1`.`name` AS `name`,`t1`.`phone` AS `phone`,`t1`.`email` AS `email`,`t1`.`is_admin` AS `is_admin`,`t1`.`status` AS `status`,`t1`.`is_tenant` AS `is_tenant`,`t1`.`organization_id` AS `organization_id`,`t1`.`organization_name` AS `organization_name`,`t2`.`role_id` AS `role_id`,`t4`.`name` AS `role_name`,`t4`.`status` AS `role_status`,`t3`.`role_group_id` AS `role_group_id`,`t5`.`name` AS `role_group_name`,`t5`.`status` AS `role_group_status`,`t1`.`edit_time` AS `edit_time` from ((((`user_view` `t1` left join `user_role` `t2` on((`t1`.`id` = `t2`.`user_id`))) left join `role_group_user` `t3` on((`t1`.`id` = `t3`.`user_id`))) left join `role_view` `t4` on((`t2`.`role_id` = `t4`.`id`))) left join `role_view` `t5` on((`t3`.`role_group_id` = `t5`.`id`)));

set global log_bin_trust_function_creators=1;

CREATE FUNCTION `getOrgCList`(rootId VARCHAR(64)) RETURNS varchar(4000) CHARSET utf8mb4
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
END;
