-- 2023年5月10日 数据服务菜单
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark) VALUES (1061, '数据服务', 0, 0, 'data', null, null, 1, 0, 'M', '0', '0', null, 'shopping', 'admin', '2023-05-10 05:39:41', '', null, '');

-- RSSHub
drop table if exists t_rsshub;

CREATE TABLE `t_rsshub` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `guid` varchar(1024) DEFAULT NULL,
                            `title` mediumtext COMMENT '标题',
                            `author` varchar(128) DEFAULT NULL COMMENT '作者',
                            `content` mediumtext COMMENT '内容',
                            `publish_date` timestamp NULL DEFAULT NULL COMMENT '发布时间',
                            `link` varchar(1024) DEFAULT NULL COMMENT '链接',
                            `type` varchar(128) DEFAULT NULL COMMENT '所属模块',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('RSSHub', '1061', '1', 'rsshub', 'data/rsshub/index', 1, 0, 'C', '0', '0', 'data:rsshub:list', '#', 'admin', sysdate(), '', null, 'rsshub菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('rsshub查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'data:rsshub:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('rsshub新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'data:rsshub:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('rsshub修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'data:rsshub:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('rsshub删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'data:rsshub:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('rsshub导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'data:rsshub:export',       '#', 'admin', sysdate(), '', null, '');