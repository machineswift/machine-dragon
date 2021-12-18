BEGIN;
INSERT INTO `dragon_system`.`t_dragon_tenant` (`id`, `tenant_id`, `name`, `status`, `create_time`, `update_time`,
                                               `is_deleted`)
VALUES ('b90ba9d30e6d427fb94645a1c9535b7a', 10000000, 'machineswift', 0, 1639731002290, 1639731002290, 0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_department` (`id`, `tenant_id`, `department_id`, `parent_id`, `code`, `name`,
                                                   `sort`, `is_deleted`, `create_time`, `update_time`)
VALUES ('821098a85de14e249cca08378d49a38c', 10000000, 1, 0, '000001', '全部', 0, 0, 1639731002290, 1639731002290);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_user` (`id`, `tenant_id`, `account`, `password`, `code`, `name`, `create_user`,
                                             `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('831098a85de14e249cca08378d49a38c', 10000000, 'superadmin',
        '$2a$10$UNynLuoZnZ2N/LfqdJ6fE./l.tJkNsBLJibbBxhs4tpJzkzJjzave', NULL, '超级管理员',
        '831098a85de14e249cca08378d49a38c', 1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_role` (`id`, `tenant_id`, `role_id`, `parent_id`, `code`, `name`, `sort`,
                                             `create_user`,
                                             `create_time`, `update_user`, `update_time`, `is_deleted`)
VALUES ('811098a85de14e249cca08378d49a38c', 10000000, 1, 0, 'SUPER_ADMIN', '超级管理员', 0,
        '831098a85de14e249cca08378d49a38c',
        1639731002290, '831098a85de14e249cca08378d49a38c', 1639731002290, 0);
COMMIT;

BEGIN;
INSERT INTO `dragon_system`.`t_dragon_user_department` (`id`, `tenant_id`, `department_id`, `user_id`, `create_time`,
                                                        `update_time`)
VALUES ('811098a85de14e249cca08378d49a38c', 10000000, 1, '831098a85de14e249cca08378d49a38c', 1639731002290,
        1639731002290);
COMMIT;