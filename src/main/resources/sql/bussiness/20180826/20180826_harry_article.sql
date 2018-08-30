CREATE TABLE `cw_article` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `content` varchar(500) COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `from_url` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '来源链接',
  `from_web` varchar(500) COLLATE utf8mb4_unicode_ci COMMENT '来源网站',
  `is_read` varchar(20) COLLATE utf8mb4_unicode_ci COMMENT '是否已读：默认0：未读，1：已读',
  `is_focus` varchar(20) COLLATE utf8mb4_unicode_ci COMMENT '是否关注：默认0：不关注，1：关注',
  `remark` varchar(500) COLLATE utf8mb4_unicode_ci COMMENT '备注',
  `publish_date` DATETIME COLLATE utf8mb4_unicode_ci COMMENT '发布日期',
  `create_time` DATETIME COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建时间',
  `update_time` DATETIME COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

ALTER TABLE `cw_article`
  ADD PRIMARY KEY (`id`);