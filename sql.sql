CREATE DATABASE `project_crowd` CHARACTER SET utf8;

USE project_crowd;

DROP TABLE IF EXISTS t_admin;project_crowd
#创建管理员数据库表
CREATE TABLE t_admin(
	id INT NOT NULL AUTO_INCREMENT, # 主键
	login_acct VARCHAR(255) NOT NULL, # 登录账号
	user_pswd  CHAR(32) NOT NULL,	# 登录密码
	user_name VARCHAR(255) NOT NULL,# 昵称
	email  VARCHAR(255) NOT NULL,# 邮件地址
	create_time CHAR(19), # 创建时间
	PRIMARY KEY (id)
);
#添加索引，唯一约束
ALTER TABLE t_admin ADD UNIQUE INDEX (`login_acct`);

#角色表
CREATE TABLE t_role(
	id INT NOT NULL AUTO_INCREMENT, # 主键
	NAME CHAR(100),
	PRIMARY KEY(id)
);
#菜单表
CREATE TABLE t_menu(
	id  INT(11) NOT NULL AUTO_INCREMENT,
	pid INT(11),
	NAME VARCHAR(200),
	url VARCHAR(200),
	icon VARCHAR(200),
	PRIMARY KEY(id)
);
#插入数据菜单数据
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('1',NULL,'系统权限菜单','glyphicon
glyphicon-th-list',NULL);
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('2','1',' 控 制 面 板 ','glyphicon
glyphicon-dashboard','main.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('3','1','权限管理','glyphicon glyphicon
glyphicon-tasks',NULL);
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('4','3',' 用 户 维 护 ','glyphicon
glyphicon-user','user/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('5','3',' 角 色 维 护 ','glyphicon
glyphicon-king','role/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('6','3',' 菜 单 维 护 ','glyphicon
glyphicon-lock','permission/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('7','1',' 业 务 审 核 ','glyphicon
glyphicon-ok',NULL);
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('8','7',' 实 名 认 证 审 核 ','glyphicon
glyphicon-check','auth_cert/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('9','7',' 广 告 审 核 ','glyphicon
glyphicon-check','auth_adv/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('10','7',' 项 目 审 核 ','glyphicon
glyphicon-check','auth_project/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('11','1',' 业 务 管 理 ','glyphicon
glyphicon-th-large',NULL);
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('12','11',' 资 质 维 护 ','glyphicon
glyphicon-picture','cert/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('13','11',' 分 类 管 理 ','glyphicon
glyphicon-equalizer','certtype/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('14','11',' 流 程 管 理 ','glyphicon
glyphicon-random','process/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('15','11',' 广 告 管 理 ','glyphicon
glyphicon-hdd','advert/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('16','11',' 消 息 模 板 ','glyphicon
glyphicon-comment','message/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('17','11',' 项 目 分 类 ','glyphicon
glyphicon-list','projectType/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('18','11',' 项 目 标 签 ','glyphicon
glyphicon-tags','tag/index.htm');
INSERT INTO `t_menu` (`id`, `pid`, `name`, `icon`, `url`) VALUES('19','1',' 参 数 管 理 ','glyphicon
glyphicon-list-alt','param/index.htm');





