package com.x.product.dao;

import com.x.data.entity.Product;
import com.x.data.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品评论DAO
 *
 * @author AD
 * @date 2021/10/4 19:05
 */
public interface IProductCommentDao extends JpaRepository<ProductComment,Long> {
}
