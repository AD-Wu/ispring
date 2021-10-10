insert into product (id, name, cover_image, price)
values (1, '测试商品-001', '/products/cover/001.png', 100),
       (2, '测试商品-002', '/products/cover/002.png', 200),
       (3, '测试商品-003', '/products/cover/003.png', 300),
       (4, '测试商品-004', '/products/cover/004.png', 400),
       (5, '测试商品-005', '/products/cover/005.png', 500);

insert into user (id, nickname, avatar)
values (1, 'zhangsan', '/users/avatar/zhangsan.png'),
       (2, 'lisi', '/users/avatar/lisi.png'),
       (3, 'wangwu', '/users/avatar/wangwu.png'),
       (4, 'zhaoliu', '/users/avatar/zhaoliu.png');

insert into product_comment (id, product_id, author_id, content, created)
values (1, 3, 1, '非常不错的商品', current_timestamp()),
       (2, 3, 3, '非常不错的商品+1', current_timestamp()),
       (3, 3, 4, '哈哈，谁用谁知道', current_timestamp());