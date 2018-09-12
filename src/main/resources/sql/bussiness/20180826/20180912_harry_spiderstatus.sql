CREATE TABLE `cw_spider_status` (
  `status` varchar(500) COLLATE utf8mb4_unicode_ci COMMENT '状态：未执行、执行中',
  `create_time` DATETIME COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '开始时间',
  `update_time` DATETIME COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '结束时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into cw_spider_status VALUE ('未执行', now(), now());