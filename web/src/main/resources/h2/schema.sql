drop table if exists product;
drop table if exists produce_comment;
drop table if exists user;

-- 商品表
create table product
(
    id          int not null auto_increment comment '主键',
    name        varchar(100) comment '商品名称',
    cover_image varchar(100) comment '商品封面图片',
    price       int not null default 0 comment '商品价格',
    primary key (id)
);

-- 商品评论表
create table product_comment
(
    id         int not null auto_increment comment '主键',
    product_id int comment '所属商品',
    author_id  int comment '作者ID',
    content    varchar(200) comment '评论内容',
    created    TIMESTAMP comment '创建时间',
    primary key (id)
);

-- 创建用户表
create table user
(
    id       int not null auto_increment comment '主键',
    nickname varchar(50) comment '用户昵称',
    avatar   varchar(255) comment '用户头像',
    primary key (id)
);