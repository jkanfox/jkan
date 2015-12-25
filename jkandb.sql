/**
 * 创建类别表 GROUP
 * @author larry.qi 2015-12-25
 */
CREATE TABLE `t_group` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`name` VARCHAR(36) NOT NULL COMMENT '名称',
	`title` VARCHAR(32) NOT NULL COMMENT '显示名称',
	`description` VARCHAR(256) NOT NULL COMMENT '描述',
	`state` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '状态[0=不可用，1=可用]',
	`position` INT(11) NOT NULL DEFAULT '0' COMMENT '排序位置',
	`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`last_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`),
	UNIQUE INDEX `title` (`title`),
	INDEX `state` (`state`)
)
COMMENT='类别表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

/**
 * 创建帖子内容表 Posts
 * @author larry.qi 2015-12-25
 */
CREATE TABLE `t_posts` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(36) NOT NULL COMMENT '名称',
	`title` VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '标题',
	`description` VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '描述',
	`tags` VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '标签',
	`url` VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '链接',
	`state` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '状态[1=可用，0=不可用]',
	`created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`last_modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间',
	`group_id` INT(11) NULL DEFAULT NULL COMMENT '分类',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`),
	INDEX `title` (`title`(255)),
	INDEX `url` (`url`(255)),
	FULLTEXT INDEX `tags` (`tags`)
)
COMMENT='帖子内容表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

