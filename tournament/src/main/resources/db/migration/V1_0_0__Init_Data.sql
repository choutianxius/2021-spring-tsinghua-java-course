-- ----------------------------
-- "球队"表初始数据
-- ----------------------------
INSERT INTO `team`(`seq`, `name`)
VALUES (1, '计01');
INSERT INTO `team`(`seq`, `name`)
VALUES (2, '计02');
INSERT INTO `team`(`seq`, `name`)
VALUES (3, '计03');
INSERT INTO `team`(`seq`, `name`)
VALUES (4, '计04');

-- ----------------------------
-- "球员"表初始数据
-- ----------------------------
INSERT INTO `player`(`seq`, `name`)
VALUES (1, '刘一');
INSERT INTO `player`(`seq`, `name`)
VALUES (2, '陈二');
INSERT INTO `player`(`seq`, `name`)
VALUES (3, '张三');
INSERT INTO `player`(`seq`, `name`)
VALUES (4, '李四');
INSERT INTO `player`(`seq`, `name`)
VALUES (5, '王五');
INSERT INTO `player`(`seq`, `name`)
VALUES (6, '赵六');
INSERT INTO `player`(`seq`, `name`)
VALUES (7, '孙七');
INSERT INTO `player`(`seq`, `name`)
VALUES (8, '周八');
INSERT INTO `player`(`seq`, `name`)
VALUES (9, '吴九');
INSERT INTO `player`(`seq`, `name`)
VALUES (10, '郑十');
INSERT INTO `player`(`seq`, `name`)
VALUES (11, '姜十一');
INSERT INTO `player`(`seq`, `name`)
VALUES (12, '齐十二');

-- ----------------------------
-- "球队成员"表初始数据
-- ----------------------------

INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (1, 1, 1, 1);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (1, 2, 2, 0);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (1, 3, 3, 0);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (2, 4, 1, 1);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (2, 5, 2, 0);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (2, 6, 3, 0);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (3, 7, 1, 1);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (3, 8, 2, 0);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (3, 9, 3, 0);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (4, 10, 1, 1);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (4, 11, 2, 0);
INSERT INTO `team_member`(`team`, `player`, `squad_number`, `is_captain`)
VALUES (4, 12, 3, 0);
