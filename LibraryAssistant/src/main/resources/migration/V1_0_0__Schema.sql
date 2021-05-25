-- ----------------------------
-- "班次"表
-- ----------------------------

CREATE TABLE `schedule`
(
    `seq`  int         NOT NULL COMMENT '班次 ID',
    `day`  int         NOT NULL COMMENT '班次星期几',
    `shift`  int         NOT NULL COMMENT '哪一班',
    PRIMARY KEY (`seq`)
) COMMENT = '班次';

-- ----------------------------
-- "队员"表
-- ----------------------------
CREATE TABLE `assistant`
(
    `seq`  int         NOT NULL COMMENT 'ID',
    `name` varchar(50) NOT NULL COMMENT '名字',
    `rank`  int         NOT NULL COMMENT '等级',
    `phone` varchar(11) COMMENT '电话',
    PRIMARY KEY (`seq`)
) COMMENT = '队员';

-- ----------------------------
-- "班次成员"表
-- ----------------------------
CREATE TABLE `schedule_member`
(
    `seq`          int NOT NULL AUTO_INCREMENT COMMENT '班次成员 ID',
    `scheduleseq`          int NOT NULL COMMENT '班次内部编号',
    `schedule`         int NOT NULL COMMENT '班次 ID',
    `assistant`       int NOT NULL COMMENT '队员 ID',
    `name`       int NOT NULL COMMENT '队员姓名',
    `is_captain`   boolean COMMENT '队员是否为班次负责人',
    PRIMARY KEY (`seq`),
    INDEX `fk__schedule_member__shedule` (`schedule`) USING BTREE,
    INDEX `fk__schedule_member__assistant` (`assistant`) USING BTREE,
    CONSTRAINT `fk__schedule_member__schedule` FOREIGN KEY (`schedule`) REFERENCES `schedule` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk__schedule_member__assistant` FOREIGN KEY (`assistant`) REFERENCES `assistant` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) COMMENT = '班次成员';
