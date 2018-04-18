DROP TABLE `cinema`;
DROP TABLE `hall`;
DROP TABLE `seat`;
DROP TABLE `movie`;
DROP TABLE `sys_user`;
DROP TABLE `comment`;
DROP TABLE `order`;
DROP TABLE `screening`;
DROP TABLE `discounts`;
-- 影院表
CREATE TABLE `cinema` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`name` varchar(50) NULL COMMENT '名称',
`code` varchar(10) NULL COMMENT '代码',
`location` varchar(255) NULL COMMENT '位置',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='影院表';

-- 大厅表
CREATE TABLE `hall` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`name` varchar(50) NULL COMMENT '名称',
`code` varchar(10) NULL COMMENT '代码',
`type` int(2) NULL DEFAULT 0 COMMENT '类型：1.普通。2.2D。3.3D。4.Imax3D',
`cinema_id` bigint(20) NULL COMMENT '影院id',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='大厅表';

-- 座位表
CREATE TABLE `seat` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`x_axis` int(5) NULL COMMENT '横坐标',
`y_axis` int(5) NULL COMMENT '纵坐标',
`hall_id` bigint(20) NULL COMMENT '影厅id',
`seat_state` int(2) NULL COMMENT '座位状态',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='座位表';

-- 电影表
CREATE TABLE `movie` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`name` varchar(50) NULL COMMENT '名称',
`code` varchar(10) NULL COMMENT '代码',
`type` int(2) NULL COMMENT '类型',
`year` timestamp NULL COMMENT '年代',
`start_time` timestamp NULL COMMENT '上映时间',
`end_time` timestamp NULL COMMENT '撤映时间',
`area` varchar(255) NULL COMMENT '地区',
`grade` numeric(5,0) NULL COMMENT '评分',
`duration` numeric(5,0) NULL COMMENT '时长',
`discounts` numeric(5,0) NULL COMMENT '优惠',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影表';

-- 用户表
CREATE TABLE `sys_user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`login_name` varchar(20) NULL COMMENT '登录名',
`user_name` varchar(20) NULL COMMENT '用户名',
`sex` int(2) NULL COMMENT '性别',
`mobile` varchar(20) NULL COMMENT '手机号',
`email` varchar(50) NULL COMMENT '邮箱',
`password` varchar(50) NULL COMMENT '密码',
`type` int(2) NULL DEFAULT 0 COMMENT '类型：0，普通用户。1.管理员',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 评论表
CREATE TABLE `comment` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`grade` numeric(5,0) NULL,
`content` text NULL,
`user_id` bigint(20) NULL,
`movie_id` bigint(20) NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- 订单表
CREATE TABLE `order` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`code` varchar(20) NULL COMMENT '序列号',
`price` decimal(4,3) NULL COMMENT '价格',
`move_id` bigint(20) NULL COMMENT '电影id',
`create_time` timestamp NULL,
`order_state` int(2) NULL COMMENT '订单状态。1，正常。0，退单',
`pay_state` int(2) NULL COMMENT '支付状态。0，未支付；1.已支付',
`disco_id` bigint(20) NULL COMMENT '优惠id',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 场次表
CREATE TABLE `screening` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`code` varchar(10) NULL COMMENT '场次代码',
`name` varchar(50) NULL COMMENT '场次名称',
`start_time` timestamp NULL COMMENT '开始时间',
`end_time` timestamp NULL COMMENT '结束时间',
`scr_state` int(2) NULL COMMENT '场次状态',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='场次表';

-- 优惠表
CREATE TABLE `discounts` (
`id` bigint(20) NOT NULL,
`code` varchar(10) NULL,
`name` varchar(20) NULL,
`percent` numeric(3,0) NULL COMMENT '优惠百分比',
`user_id` bigint(20) NULL COMMENT '用户id',
`movie_id` bigint(20) NULL COMMENT '电影id',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠表';
