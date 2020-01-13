drop table if exists blog_main;
/*==============================================================*/
/* Table: blog_main                                         */
/*==============================================================*/
create table blog_main
(
   fd_id                varchar(32)   not null,
   doc_subject          varchar(100)                COMMENT '博客标题',
   fd_content           mediumtext                  COMMENT '博客内容',
   fd_cate_id           varchar(32)                 COMMENT '所属分类',
   fd_publish 			varchar(1)    DEFAULT '0'   COMMENT '是否审核通过，1：通过，0未通过',
   doc_order            bigint(30)    DEFAULT NULL  COMMENT '内部排序',
   doc_creator_id       varchar(32)   NOT NULL      COMMENT '创建者ID',
   doc_alteror_id       varchar(32)   NOT NULL      COMMENT '修改者ID',
   doc_create_time      datetime      NOT NULL      COMMENT '创建时间',
   doc_alter_time       datetime      NOT NULL      COMMENT '修改时间',
   primary key (fd_id)
);
alter table blog_main comment '博客主表';

drop table if exists blog_main_auth;
/*==============================================================*/
/* Table: blog_main_auth                                         */
/*==============================================================*/
create table blog_main_auth
(
   fd_user_id           varchar(32)                 COMMENT '博客Id',
   fd_doc_id            varchar(32)                 COMMENT '人员Id'
);
alter table blog_main_auth comment '博客可见性表';

drop table if exists blog_main_cate;
/*==============================================================*/
/* Table: blog_main_cate                                         */
/*==============================================================*/
create table blog_main_cate
(
   fd_id                varchar(32)   not null,
   fd_name              varchar(100)                COMMENT '分类名称',
   fd_parent_id         varchar(32)                 COMMENT '上级分类',
   doc_order            bigint(30)    DEFAULT NULL  COMMENT '内部排序',
   doc_creator_id       varchar(32)   NOT NULL      COMMENT '创建者ID',
   doc_alteror_id       varchar(32)   NOT NULL      COMMENT '修改者ID',
   doc_create_time      datetime      NOT NULL      COMMENT '创建时间',
   doc_alter_time       datetime      NOT NULL      COMMENT '修改时间',
   primary key (fd_id)
);
alter table blog_main_cate comment '博客分类表';