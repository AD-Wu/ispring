package com.x.web.dao;

import com.x.web.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 *
 * @author AD
 * @date 2021/10/4 19:07
 */
public interface IProductCommentDao extends JpaRepository<ProductComment,Long> {
}
