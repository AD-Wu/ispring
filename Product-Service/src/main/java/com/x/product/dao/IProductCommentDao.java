package com.x.product.dao;

import com.x.data.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品评论DAO
 *
 * @author AD
 * @date 2021/10/4 19:05
 */
public interface IProductCommentDao extends JpaRepository<ProductComment,Long> {

    List<ProductComment> findByProductIdOrderByCreated(Long id);
}
