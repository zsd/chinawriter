CREATE TABLE `cw_article_config` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `from_web` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '来源网站',
  `list_url` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '列表链接',
  `article_url` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文章链接',
  `name_path` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题路径',
  `content_path` varchar(500) COLLATE utf8mb4_unicode_ci COMMENT '内容路径',
  `publish_date_path` varchar(500) COLLATE utf8mb4_unicode_ci COMMENT '发布日期路径',
  `publish_date_format` varchar(500) COLLATE utf8mb4_unicode_ci COMMENT '发布日期格式',
  `remark` varchar(500) COLLATE utf8mb4_unicode_ci COMMENT '备注',
  `create_time` DATETIME COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建时间',
  `update_time` DATETIME COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

ALTER TABLE `cw_article_config`
  ADD PRIMARY KEY (`id`);