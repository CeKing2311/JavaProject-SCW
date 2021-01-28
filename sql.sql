CREATE DATABASE `project_crowd` CHARACTER SET utf8;

USE project_crowd;

DROP TABLE IF EXISTS t_admin;
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