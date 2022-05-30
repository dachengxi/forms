-- create schema forms collate utf8mb4_general_ci;
use forms;

DROP TABLE IF EXISTS widget;

CREATE TABLE widget
(
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    create_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator_id  bigint(20)                    NOT NULL COMMENT '创建人ID',
    modifier_id bigint(20)          DEFAULT NULL COMMENT '修改人ID',
    is_deleted  tinyint(2)          DEFAULT 0 NOT NULL COMMENT '是否已删除：0-未删除 1-已删除',
    code        varchar(32)                   NOT NULL COMMENT '模板编码',
    type        smallint(6)         DEFAULT 1 NOT NULL COMMENT '类型：1-单行文本 2-多行文本',
    title       varchar(255)                  NOT NULL COMMENT '标题',
    description varchar(500)        DEFAULT NULL COMMENT '描述',
    `rule`      text                          NOT NULL COMMENT '规则',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_code (code)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '组件';

DROP TABLE IF EXISTS template;

CREATE TABLE template (
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    create_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator_id  bigint(20)                    NOT NULL COMMENT '创建人ID',
    modifier_id bigint(20)          DEFAULT NULL COMMENT '修改人ID',
    is_deleted  tinyint(2)          DEFAULT 0 NOT NULL COMMENT '是否已删除：0-未删除 1-已删除',
    code        varchar(32)                   NOT NULL COMMENT '模板编码',
    type        smallint(6)         DEFAULT 1 NOT NULL COMMENT '类型：1-待定',
    title       varchar(255)                  NOT NULL COMMENT '标题',
    description varchar(500)        DEFAULT NULL COMMENT '描述',
    status      smallint(6)         DEFAULT 1 NOT NULL COMMENT '状态：1-新建 2-启用 3-禁用',
    total_page  bigint(20)          DEFAULT 1 NOT NULL COMMENT '总页数',
    mode        smallint(6)                   NOT NULL COMMENT '模式：1-分页模式 2-一题一页 3-一页',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_code(code)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '模板';

DROP TABLE IF EXISTS template_question;

CREATE TABLE template_question (
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    create_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator_id  bigint(20)                    NOT NULL COMMENT '创建人ID',
    modifier_id bigint(20)          DEFAULT NULL COMMENT '修改人ID',
    is_deleted  tinyint(2)          DEFAULT 0 NOT NULL COMMENT '是否已删除：0-未删除 1-已删除',
    template_id bigint(20)                    NOT NULL COMMENT '模板ID',
    title       varchar(255)                  NOT NULL COMMENT '标题',
    description varchar(500)        DEFAULT NULL COMMENT '描述',
    `order`     int(10)                       NOT NULL COMMENT '排序',
    page_number int(10)             DEFAULT 1 NOT NULL COMMENT '所属页',
    widget_type smallint(6)         DEFAULT 1 NOT NULL COMMENT '控件类型',
    widget_rule text                          NOT NULL COMMENT '控件规则',
    PRIMARY KEY (id),
    KEY idx_template_id(template_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '模板问题';

DROP TABLE IF EXISTS form;

CREATE TABLE form (
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    create_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator_id  bigint(20)                    NOT NULL COMMENT '创建人ID',
    modifier_id bigint(20)          DEFAULT NULL COMMENT '修改人ID',
    is_deleted  tinyint(2)          DEFAULT 0 NOT NULL COMMENT '是否已删除：0-未删除 1-已删除',
    template_id bigint(20)          DEFAULT 0 NOT NULL COMMENT '模板ID，0表示不使用模板生成',
    code        varchar(32)                   NOT NULL COMMENT '模板编码',
    version     bigint(20)          DEFAULT 1 NOT NULL COMMENT '版本号',
    type        smallint(6)         DEFAULT 1 NOT NULL COMMENT '类型：1-待定',
    title       varchar(255)                  NOT NULL COMMENT '标题',
    description varchar(500)        DEFAULT NULL COMMENT '描述',
    status      smallint(6)         DEFAULT 1 NOT NULL COMMENT '状态：1-新建 2-启用 3-禁用',
    total_page  bigint(20)          DEFAULT 1 NOT NULL COMMENT '总页数',
    mode        smallint(6)                   NOT NULL COMMENT '模式：1-分页模式 2-一题一页 3-一页',
    PRIMARY KEY (id),
    UNIQUE KEY uniq_code(code),
    KEY idx_template_id(template_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '表单';

DROP TABLE IF EXISTS form_question;

CREATE TABLE form_question (
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    create_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator_id  bigint(20)                    NOT NULL COMMENT '创建人ID',
    modifier_id bigint(20)          DEFAULT NULL COMMENT '修改人ID',
    is_deleted  tinyint(2)          DEFAULT 0 NOT NULL COMMENT '是否已删除：0-未删除 1-已删除',
    form_id     bigint(20)                    NOT NULL COMMENT '表单ID',
    title       varchar(255)                  NOT NULL COMMENT '标题',
    description varchar(500)        DEFAULT NULL COMMENT '描述',
    `order`     int(10)                       NOT NULL COMMENT '排序',
    page_number int(10)             DEFAULT 1 NOT NULL COMMENT '所属页',
    widget_type smallint(6)         DEFAULT 1 NOT NULL COMMENT '控件类型',
    widget_rule text                          NOT NULL COMMENT '控件规则',
    PRIMARY KEY (id),
    KEY idx_form_id(form_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '表单问题';

DROP TABLE IF EXISTS user_form;

CREATE TABLE user_form (
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    create_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator_id  bigint(20)                    NOT NULL COMMENT '创建人ID',
    modifier_id bigint(20)          DEFAULT NULL COMMENT '修改人ID',
    is_deleted  tinyint(2)          DEFAULT 0 NOT NULL COMMENT '是否已删除：0-未删除 1-已删除',
    user_id     bigint(20)                    NOT NULL COMMENT '用户ID',
    form_id     bigint(20)          DEFAULT 0 NOT NULL COMMENT '表单ID',
    status      smallint(6)         DEFAULT 1 NOT NULL COMMENT '状态：1-未提交 2-已提交',
    PRIMARY KEY (id),
    KEY idx_user_id(user_id),
    KEY idx_form_id(form_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '用户表单';

DROP TABLE IF EXISTS user_form_answer;

CREATE TABLE user_form_answer (
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    create_time  datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_time  datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    creator_id   bigint(20)                    NOT NULL COMMENT '创建人ID',
    modifier_id  bigint(20)          DEFAULT NULL COMMENT '修改人ID',
    is_deleted   tinyint(2)          DEFAULT 0 NOT NULL COMMENT '是否已删除：0-未删除 1-已删除',
    user_id      bigint(20)                   NOT NULL COMMENT '用户ID',
    user_form_id bigint(20)                   NOT NULL COMMENT '用户表单ID',
    question_id  bigint(20)                   NOT NULL COMMENT '表单问题ID',
    widget_type  smallint(6)        DEFAULT 1 NOT NULL COMMENT '控件类型',
    value        text                         NOT NULL COMMENT '用户表单问题答案',
    PRIMARY KEY (id),
    KEY idx_user_id(user_id),
    KEY idx_user_form_id(user_form_id),
    KEY idx_question_id(question_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '用户表单答案';