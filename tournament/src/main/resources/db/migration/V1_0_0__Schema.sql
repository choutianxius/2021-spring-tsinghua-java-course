-- ----------------------------
-- "球队"表
-- ----------------------------

CREATE TABLE `team`
(
    `seq`  int(9) NOT NULL COMMENT '球队ID',
    `name` varchar(50) NOT NULL COMMENT '球队名称',
    PRIMARY KEY (`seq`) USING BTREE
) COMMENT = '球队';

-- ----------------------------
-- "球员"表
-- ----------------------------
CREATE TABLE `player`
(
    `seq`  int(9) NOT NULL COMMENT '球员ID',
    `name` varchar(50) NOT NULL COMMENT '球员姓名',
    PRIMARY KEY (`seq`)
) COMMENT = '球员';

-- ----------------------------
-- "比赛"表
-- ----------------------------
CREATE TABLE `fixture`
(
    `seq`             int(9) NOT NULL COMMENT '比赛ID',
    `fixture_date`    date COMMENT '比赛日期',
    `kickoff_time`    time(0) COMMENT '比赛开始时间',
    `field`           varchar(50) COMMENT '比赛场地',
    `home_team`       int(9) COMMENT '主队',
    `away_team`       int(9) COMMENT '客队',
    `home_team_score` int(3) COMMENT '主队得分',
    `away_team_score` int(3) COMMENT '客队得分',
    PRIMARY KEY (`seq`),
    INDEX             `fk__fixture__home_team` (`home_team`) USING BTREE,
    INDEX             `fk__fixture__away_team` (`away_team`) USING BTREE,
    CONSTRAINT `fk__fixture__away_team` FOREIGN KEY (`away_team`) REFERENCES `team` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk__fixture__home_team` FOREIGN KEY (`home_team`) REFERENCES `team` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) COMMENT = '比赛';

-- ----------------------------
-- "比赛事件"表
-- ----------------------------
CREATE TABLE `fixture_event`
(
    `seq`                 int(9) NOT NULL COMMENT '事件ID',
    `fixture`             int(9) NOT NULL COMMENT '比赛',
    `event`               varchar(10) NOT NULL COMMENT '事件类型。G: 进球; OG: 乌龙球; YC: 黄牌; RC: 红牌。',
    `event_minute_offset` int(3) COMMENT '事件发生时间，按比赛开始后第几分钟记录。比如：比赛第30分钟发生的事件，本列存储整数30。',
    `team`                int(9) COMMENT '事件涉及的球队，其含义随事件类型的不同而不同。',
    `player`              int(9) COMMENT '事件涉及的球员，其含义随事件类型的不同而不同。',
    PRIMARY KEY (`seq`) USING BTREE,
    INDEX                 `fk__fixture_event__fixture` (`fixture`) USING BTREE,
    INDEX                 `fk__team` (`team`) USING BTREE,
    INDEX                 `fk__player` (`player`) USING BTREE,
    CONSTRAINT `fk__fixture_event__fixture` FOREIGN KEY (`fixture`) REFERENCES `fixture` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk__player` FOREIGN KEY (`player`) REFERENCES `player` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fk__team` FOREIGN KEY (`team`) REFERENCES `team` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) COMMENT = '比赛过程发生的详细事件，比如进球、红黄牌等。';
